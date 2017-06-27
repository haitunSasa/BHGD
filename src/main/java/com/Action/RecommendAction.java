package com.Action;

import com.Entity.Interest;
import com.Service.ClickRecordService;
import com.Service.EavesdropperService;
import com.Service.InterestService;
import com.Service.QuestionService;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.Action.ErrCode.SERVICE_ERR_INSIDE;

/**
 * Created by liyan on 2017/6/26.
 */
public class RecommendAction extends BaseAction implements ServletResponseAware {
    private HttpServletResponse response;

    private int flag = 0;
    private JSONObject returnJson = new JSONObject();

    static Logger logger = Logger.getLogger(RecommendAction.class.getName());
    Map<String, Double> rating_map = new HashMap<String, Double>();

    @Autowired
    private EavesdropperService eavesdropperService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ClickRecordService clickRecordService;
    @Autowired
    private InterestService interestService;

    //问题兴趣度计算
    public float getInterest(int count, int buy, int isAsk) {
        float interest = 0;
        interest = (float) (count + buy * 3 + isAsk * 4) / 8;
        return interest;
    }

    //衰减函数
    public double Ebbinghaus(int t) {
        double ebbinghaus = 10 * Math.pow(Math.E, 0.42) / Math.pow(t + 0.00255, 0.0225);
        return ebbinghaus;
    }

    //更新兴趣模型
    public void updateInterest(int userId, int questionId) throws SQLException {
        List<Interest> interestList = this.interestService.getByUIAndQI(userId, questionId);
        if (interestList == null && interestList.isEmpty()) {
            Interest interest = new Interest();
            interest.setInterestId(userId);
            interest.setQuestionId(questionId);
            interest.setInterestTime(new Timestamp(System.currentTimeMillis()));
            interest.setInterestUpdateTime(new Timestamp(System.currentTimeMillis()));
            //      interest.setInterestWeight(getInterest());
            interestService.save(interest);
            System.out.println("兴趣模型已保存");
        } else {
            interestList.get(0).setInterestUpdateTime(new Timestamp(System.currentTimeMillis()));
            //      interestList.get(0).setInterestWeight(getInterest());
            interestService.update(interestList.get(0));
            System.out.println("兴趣模型已更新");
        }
    }

    //获取用户兴趣度的平均数
    public double getAvg(int userId) {
        List<Interest> interestList = this.interestService.getByTagId(userId, "userId");
        //String sql="select avg(interestWeight)from Interest where userId="+userId;
        double avg = 0;
        if (interestList != null && !interestList.isEmpty()) {
            for (Interest interest : interestList) {
                avg = avg + interest.getInterestWeight();
            }
            avg = avg / interestList.size();
        }
        return avg;
    }

    //兴趣度相同
    public void recommend() throws Exception {
        try {
            int userId = getIntFromGet("userId");
            List<Interest> interestList = this.interestService.getByNU(userId);
            if (interestList != null && !interestList.isEmpty()) {
              returnJson.put("data",interestList);
              flag=1;
            }else {
                returnJson.put("errCode",NO_RECOMMEND);
                returnJson.put("cause",printErrCause(NO_RECOMMEND));
            }
        } catch (Exception e) {
            returnJson.put("errCode", SERVICE_ERR_INSIDE);
            returnJson.put("cause", e.toString());
        } finally {
            returnJson.put("flag", flag);
            writeJson(returnJson);
        }
    }


    //皮尔森相关
    public double getsimilarity_bydim(RecommendAction u) {
        double sim = 0d;
        double common_items_len = 0;
        double this_sum = 0d;
        double u_sum = 0d;
        double this_sum_sq = 0d;
        double u_sum_sq = 0d;
        double p_sum = 0d;

        Iterator<String> rating_map_iterator = this.rating_map.keySet().iterator();
        while (rating_map_iterator.hasNext()) {
            String rating_map_iterator_key = rating_map_iterator.next();
            Iterator<String> u_rating_map_iterator = u.rating_map.keySet().iterator();
            while (u_rating_map_iterator.hasNext()) {
                String u_rating_map_iterator_key = u_rating_map_iterator.next();
                if (rating_map_iterator_key.equals(u_rating_map_iterator_key)) {
                    double this_grade = this.rating_map.get(rating_map_iterator_key);
                    double u_grade = u.rating_map.get(u_rating_map_iterator_key);
                    //评分求和
                    //平方和
                    //乘积和
                    this_sum += this_grade;
                    u_sum += u_grade;
                    this_sum_sq += Math.pow(this_grade, 2);
                    u_sum_sq += Math.pow(u_grade, 2);
                    p_sum += this_grade * u_grade;
                    common_items_len++;
                }
            }
        }
        //如果等于零则无相同条目，返回sim=0即可
        if (common_items_len > 0) {
            logger.info("common_items_len:" + common_items_len);
            logger.info("p_sum:" + p_sum);
            logger.info("this_sum:" + this_sum);
            logger.info("u_sum:" + u_sum);
            double num = common_items_len * p_sum - this_sum * u_sum;
            double den = Math.sqrt((common_items_len * this_sum_sq - Math.pow(this_sum, 2)) * (common_items_len * u_sum_sq - Math.pow(u_sum, 2)));
            logger.info("" + num + ":" + den);
            sim = (den == 0) ? 1 : num / den;
        }

        //如果等于零则无相同条目，返回sim=0即可
        return sim;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = response;
    }
}
