<%@ page language="java"  contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Employer</title>
</head>
<body>
<div class="jumbotron" style="margin-top:40px;">

<div style="padding-left:30px;">
Send Message to ${empName}:
	<form:form action="contactEmployer.htm" commandName="message" method="post"> 
	<form:input type="textarea" rows="10" cols="20" path="context"/>
	
	<input type="submit" value="send Message"  class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;">
	</form:form>
	
	
	</div>
</div>	
</body>
</html>