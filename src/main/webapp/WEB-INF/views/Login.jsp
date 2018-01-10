<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginPage</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

</head>
<body>
<div class="jumbotron" style="margin-top:18%;">
<div style="padding-left:40%;">
<h4 style="margin-left:60px;">Login</h4><br>

<%
if(session.getAttribute("fail").equals("true")){
%>
<font color="red">User doesn't exist or username and password are not match</font>
<%} %>
  <form id="login" action='login.htm' method='post'>
               User Name : <input type ='text' name ='username' >
                           <br /><br />
               Password : <input type ='password' name ='password' >
               <br /><br />
               Choose your Role:
				<input type="radio"  name="identity"
				value="employer" checked />Employer
				<input type="radio"  name="identity"
				value="jobseeker" />Job Seeker
				<input type="radio"  name="identity"
				value="admin" />Admin
		
				<br /><br />
               <input type='checkbox' name='rememberMe' value="rememberMe"> Remember Me 
               <br /><br />
                    
               <input class="btn btn-primary btn-lg" type="submit" value="Sign up"> 
               <input type="hidden" name="action" value="login" />
               </form>  
               </div>
</div>
</body>
</html>