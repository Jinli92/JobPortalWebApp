
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hhhh</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<style>
.jumbotron{
padding-left：100px;
}
</style>
</head>


<body>
<div class="jumbotron" style="margin-top:14%;">
<h1 style="padding-left:18%;">Welcome to Our Job Portal!</h1>
<p style="padding-left:24%;">Finding your dream job or qualified employee here!</p>
<form  action="jump.htm" method="post">
<input type="hidden" name="a" value="login">
<input style="margin-left:40%;" class="btn btn-primary btn-lg" id="a" type="submit" value="I have account">
</form>
 
<br>
<br> 
 
 
<form  action="jump.htm" method="post">
<input type="hidden" name="a" value="signup">
<input style="margin-left:40%;" class="btn btn-primary btn-lg" type="submit" id="a" value="I want to sign up">
</form>
</div> 
</body>
</html>