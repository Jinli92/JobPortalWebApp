<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script> 
<script type="text/javascript">
  function ajaxFunction(cityName)   //functionName could be anything
{
	//1. Create XmlHttpRequest Object
	//This could be written into an external .js file that could be used within other pages as well.
	var xmlHttp;
   
	try     // Firefox, Opera 8.0+, Safari
	{
		xmlHttp=new XMLHttpRequest();
	}
	catch (e)
	{
		try  // Internet Explorer
		{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e)
		{
			try
			{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e)
			{
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}
	
	//2. Call the server-side script
	//cityName is the function parameter passed when the JS function is called
	xmlHttp.open("GET", "KindsofJobs.htm?q=" + cityName, true);   //q is the name of the parameter to be used in JSP
	xmlHttp.send();   //leave blank, or pass null. Not used with GET requests
	
	
	//3. Check the server-data is ready
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4)
		{
			//4. Manipulate the DOM
			var jobDiv = document.getElementById("jobDiv");
			var serverData = xmlHttp.responseText;
			
			jobDiv.innerHTML = serverData;
			
		}
	}
	
}
	</script>
</head>
<body>




<div class="jumbotron" style="margin-top:40px;">

<div style="padding-left:30px;">
<h2>Add a New Category</h2>
<form:form action="addcategory.htm" commandName="category" method="post">

<table>
<tr>
    <td>Category Title:</td>
    <td><form:input path="title" size="30" onKeyUp="ajaxFunction(this.value)"/> <font color="red"><form:errors path="title"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit"  class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;" value="Create Category" /></td>
</tr>
</table>

</form:form>
<br>
<h3>
Do you want to add the following jobs?</h3><br>
<div id="jobDiv"></div>

</div>
</body>
</html>