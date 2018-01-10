<%@page import="com.jinli.myapp.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		var form1 = document.getElementById("cateform");
		form1.style.display = "block";
		var form2 = document.getElementById("titleform");
		form2.style.display = "none";

	}
	function displayform2() {
		var form1 = document.getElementById("cateform");
		form1.style.display = "none";
		var form2 = document.getElementById("titleform");
		form2.style.display = "block";

	}
</script>



</head>
<body>
<%
//get the category list
        CategoryDAO categorydao= new CategoryDAO();
        java.util.List categoryList = categorydao.list();
        pageContext.setAttribute("categories", categoryList);
%>
<div class="jumbotron" style="margin-top:40px;">
<div style="padding-left:200px;">
	<h3>Choose a way to search job :</h3>
	<input type ="radio" onclick ="displayform1();" name="ways"
		value ="cate" checked />By its category
	<input type="radio" onclick="displayform2();" name="ways"
		value="title" />By its title
		
		<br><br>
		
		<form id ="cateform" action="searchJob.htm"  method="post">
		<select name="cateName">
		 <c:forEach var="categ" items="${categories}">
                                <option value="${categ.title}"><c:out value=" ${categ.title}" /> </option>
                            </c:forEach>
		</select>
		<input type="hidden" name="way" value="cate" >
		<input type="submit"  class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;">
		</form>
		
		<form id ="titleform" action="searchJob.htm"  method="post" style = "display:none">
		<input type="text" name="jobtitle">
		<input type="hidden" name="way" value="title" >
		<input type="submit"  class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;">
		
		</form>
		</div>
		</div>
</body>
</html>