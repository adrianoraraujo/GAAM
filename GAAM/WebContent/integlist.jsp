<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="page-header">
<h1> Lista Integrantes </h1>
</div>

<table class="table" >
<tr>
<th> Nome </th>

</tr>

<c:forEach var="e" items="${lista}">
<tr>
 <td> ${e.nome} </td>
 
<tr>
</c:forEach>
</table>
</div>

</body>
</html>