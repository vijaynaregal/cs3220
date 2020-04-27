<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<p class="font-weight-bold"><a href="jforum">C3220 Web Programming</a>>Create Forum</p>

<form action='jcreateforum' method='post'>
  <div class="form-group">
<table class="table table-hover table-sm table-bordered col-md-7">
<tr><th align='left'>Forum</th><td><input type='text' class="form-control" name='forum'></td></tr>
<tr><th align='left'></th><td><input type='hidden' class="form-control" name='topics'></td><tr>
<tr><td colspan='2'><input type='submit' class="form-control" name='Post' value='Create Forum' ></td></tr>
</table>
  </div>
</form>
</body>
</html>