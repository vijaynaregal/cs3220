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
      <th >Forum</th>
      <th >Topics</th>
    </tr>
    <c:forEach items="${entries}" var="entry"> 
    <tr>
    <td><a href='jdisplaytopic?id=${entry.id}'>${entry.forum}</a></td>
        <c:forEach items="${entries2}" var="entry"> 
    <td>${entry.topics}</td></c:forEach>
    </tr>
    </c:forEach>
</table>
<br/>
</div>
<p><a href="jcreateforum"> Create Forum </a></p>
</body>
</html>