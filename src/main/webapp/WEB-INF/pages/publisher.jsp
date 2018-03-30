<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Advertiser</title>
</head>
<body>
<div style="border:1px solid #ccc;text-align:right;padding:5px;">
   <a href="${pageContext.request.contextPath}/publisher/list">Publisher List</a>
   &nbsp;&nbsp;
   <a href="${pageContext.request.contextPath}/advertiser/list">Advertiser List</a>
</div>
 
<h1>Publisher Page</h1>
 
<c:forEach var="item" items="${publishers}" varStatus="status">
 
  ${item}  <br/>
  
</c:forEach>
 
</body>
</html>