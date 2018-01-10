<%@page import="com.jinli.myapp.pojo.Jobseeker"%>
<%@page import="com.jinli.myapp.pojo.User"%>
<%@page import="com.jinli.myapp.dao.MessageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
function enable(){
	
}
</script>



</head>
<body>

<div class="jumbotron" style="padding-left:15px; margin-top:30px;">
<div style="padding-left:30px;">
<form method="post" action="reviseInfo.htm" class="form-inline">

School:<input type="text" value="${user.school}"  name="school" /><br><br>
Major:<input type="text" value="${user.major}"  name="major" /><br><br>
Introduction:<input type="text" value="${user.introduction}" name="introduction" /><br><br>

<input type="submit" class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;">
</form>
</div>
</div>


</body>
</html>