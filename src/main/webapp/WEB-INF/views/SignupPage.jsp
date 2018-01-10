<%@ page language="java"  contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	function displayform1() {
		var form1 = document.getElementById("employerform");
		form1.style.display = "block";
		var form2 = document.getElementById("jobseekerform");
		form2.style.display = "none";

	}
	function displayform2() {
		var form1 = document.getElementById("employerform");
		form1.style.display = "none";
		var form2 = document.getElementById("jobseekerform");
		form2.style.display = "block";

	}
</script>


</head>
<body>

<div class="jumbotron" style="margin-top:9%;">
<div style="padding-left:40%;">

<h4 >Start wonderful experience by Signing up!</h4><br>




	You are :
	<input type ="radio" onclick ="displayform1();" name="identity"
		value ="employer" checked />Employer
	<input type="radio" onclick="displayform2();" name="identity"
		value="jobseeker" />Job Seeker
<br>
	
	<form:form id ="employerform" action="signup.htm" commandName="employer" method="post">
		
		User Name: <form:input path="username" /><font color="red"><form:errors path="username"/></font>
		<br/><br/> 
		First Name :<form:input path="firstname" /><font color="red"><form:errors path="firstname"/></font> 
		<br /><br /> 
		Last Name : <form:input path="lastname" /><font color="red"><form:errors path="lastname"/></font> 
		<br /><br /> 
		Password : <form:input path="password" /><font color="red"><form:errors path="password"/></font> 
		<br /><br /> 
		Company Name : <form:input path="companyName" /><font color="red"><form:errors path="companyName"/></font> 
		<br /><br /> 
		Position : <form:input path="position" /><font color="red"><form:errors path="position"/></font> 
		<br /><br /> 
		<input  class="btn btn-primary btn-lg" style="margin-left:30px;" type="submit" value="Sign Up">

</form:form> 

	<form:form id="jobseekerform" action="signup1.htm" commandName="jobseeker" method="post" style = "display:none">
	
		User Name: <form:input path="username" size="30" />
		<br /><br /> 
		First Name :<form:input path="firstname" size="30" /> 
		<br /><br /> 
		Last Name : <form:input path="lastname" /> 
		<br /><br /> 
		Password : <form:input path="password" /> 
		<br /><br /> 
		School: <form:input path="school" /> 
		<br/><br/>
		Major:<form:input path="major" /> 
		<br/><br/>
		<input type="submit" class="btn btn-primary btn-lg" style="margin-left:30px;" value="Sign Up">

	</form:form>

</div></div>

</body>
</html>