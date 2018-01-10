<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron" style="margin-top:40px;">
<div style="padding-left:180px;">
<form action="sendmessage.htm" method="post">
<h4>You want to send message to :</h4><br>
	<input type ="radio"  name="identity"
		value ="employer" checked />Employer
	<input type="radio" name="identity"
		value="jobseeker" />Job Seeker
	<input type="radio" name="identity"
		value="admin" />Admin
		
<br><br>
To(input user name):<input type="text" name="receiver" /><br><br>
Content:<input type="text" name="content"/><br><br>
<input type="submit" value="send" class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;">
</form>

</div>
</div>
</body>
</html>