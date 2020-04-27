<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="table-responsive">
<br/>
<br/>
<table  class="table table-hover table-sm table-bordered col-md-7">
    <tr>
      <th >Topic</th>
      <th >Author</th>
      <th >Replies</th>
      <th >Last Post</th>
    </tr>
    <c:forEach items="${entries}" var="entry"> 
    <tr>
    <td><a href='jsubtopics?id=${entry.id}'>${entry.topic}</a></td>
    <td>${entry.author}</td>
    <td>        <c:forEach items="${entries3}" var="entry"> 
    ${entry.replies}</c:forEach></td>
        <c:forEach items="${entries}" var="entry"> 
    <td>${entry.date}</td></c:forEach>
    </tr>
    </c:forEach>
</table>
<br/>
</div>
    <c:forEach items="${entries2}" var="entry"> 
<p><a href='jcreatetopic?id=${entry.id}'>Create Topic </a></p>
</c:forEach>
</body>
</html>