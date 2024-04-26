<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePathInpageContext", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>首页</title>
</head>
<body>

i am webapp/home.jsp<br/>

basePath: ${basePath} <br/>
basePath: <%=basePath%> <br/>
basePathInpageContext: ${basePathInpageContext} <br/>
page: <%=pageContext.getPage()%> <br/>
page: <%=page%> <br/>

</body>
</html>