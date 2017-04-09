package com.Action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class BaseAction {
	private JSONObject returnjsonP  = new JSONObject();
	int flagP = 0;

	public void writeJson(Object obj){
		try {
			String json=JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//检测字符串的合法性
	public boolean checkString(String str, String paramName){
		if(str == null || str.equals("")){
			String errString = "报错：" + paramName + " 参数为空";
			flagP = 2;
			printError(errString);
			return false;
		}
		return true;
	}
	//从post中获取string，返回""则为空
	public String getStringFromPost(String paramName){
		try {
			Map<String, String[]> paramsMap = ServletActionContext.getRequest().getParameterMap();
			String valueStr = paramsMap.get(paramName)[0];
			if(checkString(valueStr, paramName)){
//				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
//				valueStr = java.net.URLDecoder.decode(valueStr, "UTF-8");
				return valueStr;
			}
		}catch (Exception e){
			printError(e.toString());
			e.printStackTrace();
		}
		return "";
	}

	//从get中获取string,返回""则为空
	public String getStringFromGet(String paramName){
		try {
			String valueStr = ServletActionContext.getRequest().getParameter(paramName);
			if(checkString(valueStr, paramName)){
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
				valueStr = java.net.URLDecoder.decode(valueStr, "UTF-8");
				return valueStr;
			}
		}catch (Exception e){
			printError(e.toString());
			e.printStackTrace();
		}
		return "";
	}

	//从post中获取int值,返回0则为空
	public int getIntFromPost(String paramName){
		try{
			Map<String, String[]> paramsMap = ServletActionContext.getRequest().getParameterMap();
			String valueStr = paramsMap.get(paramName)[0];
			if(checkString(valueStr, paramName)){
				int valueInt = Integer.parseInt(valueStr);
				return valueInt;
			}
		}catch (Exception e){
			printError(e.toString());
			e.printStackTrace();
		}
		return 0;
	}

	//从get中获取int值，返回0则为空
	public int getIntFromGet(String paramName){
		try{
			String valueStr = ServletActionContext.getRequest().getParameter(paramName);
			if(checkString(valueStr, paramName)){
				int valueInt = Integer.parseInt(valueStr);
				return valueInt;
			}
		}catch (Exception e){
			printError(e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	//获取JSONObject值
	public JSONObject getJSONObjectFromJson(){
		try {
			ServletInputStream in= ServletActionContext.getRequest().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
			String inputLine = null;
			StringBuilder stringBuilder = new StringBuilder();
			while ( (inputLine = reader.readLine()) != null){
				stringBuilder.append(inputLine);
			}
			in.close();
			return JSON.parseObject(stringBuilder.toString());
		}catch (Exception e){
			printError(e.toString());
			e.printStackTrace();
		}
		return new JSONObject();
	}

	private void printError(String errStr){
		flagP = 2;
		returnjsonP.put("flag",flagP);
		returnjsonP.put("error",errStr);
		writeJson(returnjsonP);
	}
}
