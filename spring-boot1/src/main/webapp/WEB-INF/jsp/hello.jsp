<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username="admin";
	pageContext.setAttribute("username", username);
%>
	<!-- if标签 -->
	<c:if test="${username=='admin'}">
		<c:out value="${username}"></c:out>
	</c:if>
<%
	List<String> strList=new ArrayList<String>();
	strList.add("0001");
	strList.add("0002");
	strList.add("0003");
	pageContext.setAttribute("strList", strList);
	
	 Map<String,String> stu = new LinkedHashMap<String,String>();  
	    stu.put("number", "N_1001");  
	    stu.put("name", "zhangSan");  
	    stu.put("age", "23");  
	    stu.put("sex", "male");  
	   pageContext.setAttribute("stu", stu);  
%>	
	<!-- foreach标签变量list -->
	<c:forEach items="${strList}" var="str" varStatus="vs">
		<p>
			第<c:out value="${vs.index+1}">个元素；</c:out> <c:out value="${str}"></c:out>
		</p>
	</c:forEach>
	<!-- foreach标签遍历map -->
	<c:forEach items="${stu}" var="stu">
		<h5>
			${stu.key}=<c:out value="${stu.value}"></c:out>
		</h5>
	</c:forEach>
<%
	Date date=new Date();
	pageContext.setAttribute("date", date);
	
	double a=2.333333;
	double b=3.6666;
	pageContext.setAttribute("a", b);
%>
	<!-- 使用fmt标签 -->
	<fmt:formatDate value="${date}" var="d" pattern="yyyy-MM-dd HH:mm:ss"/>
	<h5>
		时间：<c:out value="${d}"></c:out><br/>
		<fmt:formatNumber value="${a}" pattern="#.##" var="a"></fmt:formatNumber>
		${a}
	</h5>	
	<c:set value="这是一个页面变量" var="a" scope="page"></c:set>
	<p>Hello:${name}--------<c:out value="${a}"></c:out> 	
	</p>
	<p>
		项目上下文为：<c:url value="/" var="b"></c:url>
	</p>
	<ul>
	<c:forEach items="${str}" var="str" >
		<li>
		${str}
		</li>	
	</c:forEach>
	</ul>

</body>
</html>