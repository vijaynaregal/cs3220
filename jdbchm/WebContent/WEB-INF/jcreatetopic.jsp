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
           <c:forEach items="${entries2}" var="entry"> 

<p class="font-weight-bold"><a href='jdisplaytopic?id=${entry.id}'>C3220 Web Programming</a>>Create Topic</p>
<form action='jcreatetopic?id=${entry.id}' method='post'>
  <div class="form-group">    
<table class="table table-hover table-sm table-bordered col-md-7">

<tr><th align='left'>Your Name</th><td><input type='text' class="form-control" name='author'></td></tr>
<tr><th align='left'>Subject</th><td><input type='text' class="form-control" name='topic'></td><tr>
<tr><th align='left'>Content</th><td><textarea class="form-control" name='content'></textarea></td></tr>
    <c:forEach items="${entries2}" var="entry"> 
<tr><th align='left'></th><td><input type='hidden' name='subid' value='${entry.id}'/></td><tr></tr></c:forEach>
<tr><td colspan='2'><input type='submit' class="form-control" name='Post' value='Post' ></td></tr>
</table>
  </div>
</form>
</c:forEach>
</body>
</html>