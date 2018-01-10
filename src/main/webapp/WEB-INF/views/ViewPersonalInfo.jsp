<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron" style="margin-top:40px;">

<div style="padding-left:60px;">
<h2>Personal Information</h2>
<h4>username:<c:out value="${viewjs.username }" /></h4><br>
<h4>Name:<c:out value="${viewjs.firstname }" /></h4><br>
<h4>School:<c:out value="${viewjs.school }" /></h4><br>
<h4>Major:<c:out value="${viewjs.major }" /></h4><br>
<h4>introduction:<c:out value="${viewjs.introduction }" /></h4>
</div>
</div>

</body>
</html>