<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>HTTP 404</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%-- <meta http-equiv="refresh" content="3; url=<%=basePath%>" /> --%>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<STYLE type=text/css>BODY {
	FONT-SIZE: 9pt; COLOR: #842b00; LINE-HEIGHT: 16pt; FONT-FAMILY: "Tahoma", "宋体"; TEXT-DECORATION: none
}
TABLE {
	FONT-SIZE: 9pt; COLOR: #842b00; LINE-HEIGHT: 16pt; FONT-FAMILY: "Tahoma", "宋体"; TEXT-DECORATION: none
}
TD {
	FONT-SIZE: 9pt; COLOR: #842b00; LINE-HEIGHT: 16pt; FONT-FAMILY: "Tahoma", "宋体"; TEXT-DECORATION: none
}
BODY {
	SCROLLBAR-HIGHLIGHT-COLOR: buttonface; SCROLLBAR-SHADOW-COLOR: buttonface; SCROLLBAR-3DLIGHT-COLOR: buttonhighlight; SCROLLBAR-TRACK-COLOR: #eeeeee; BACKGROUND-COLOR: #F1F1F1
}
A {
	FONT-SIZE: 9pt; COLOR: #842b00; LINE-HEIGHT: 16pt; FONT-FAMILY: "Tahoma", "宋体"; TEXT-DECORATION: none
}
A:hover {
	FONT-SIZE: 9pt; COLOR: #0188d2; LINE-HEIGHT: 16pt; FONT-FAMILY: "Tahoma", "宋体"; TEXT-DECORATION: underline
}
H1 {
	FONT-SIZE: 9pt; FONT-FAMILY: "Tahoma", "宋体"
}
</STYLE>
  </head>
  
  <body topMargin=20>
  <TABLE cellSpacing=0 width=600 align=center border=0 cepadding="0">
  <TBODY>
  <TR colspan="2">
    <TD vAlign=top align=middle><IMG height=231 src="<%=basePath%>images/erro.png" 
      width=200 border=0> 
    <TD>
    <TD><!--------System Return Begin------------>
      <H1>无法找到该页</H1>
      HTTP 错误 404：您正在搜索的页面可能已经删除、更名或暂时不可用。 
      <HR noShade SIZE=0>

      <P>☉ 请尝试以下操作：</P>
      <UL>
        <LI>确保浏览器的地址栏中显示的网站地址的拼写和格式正确无误。 
        <LI>如果通过单击链接而到达了该网页，请与网站管理员联系，通知他们该链接的格式不正确。 
        <LI>单击<A href="javascript:history.back(1)"><FONT 
        color=#ff0000>后退</FONT></A>按钮尝试另一个链接。 </LI></UL>
      <P>    
      <UL>
        <LI><A href="<%=basePath%>index.jsp" 
        target=_blank>母婴监护系统</A></LI>
      </UL>
      <HR noShade SIZE=0>

      <P>☉ 如果您对本站有任何疑问、意见、建议、咨询，请联系管理员QQ:1107455218</A> 
      <BR>
      &nbsp;&nbsp;&nbsp;<BR>
      </P><!------------End this!---------------></TD></TR>
  </body>
</html>
