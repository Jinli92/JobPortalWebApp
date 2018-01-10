<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String [] jobs = new String[10];
	
	jobs[0] = "Athlets";
	jobs[1] = "SoftwareEngineer";
	jobs[2] = "ElectronicEngineer";
	jobs[3] = "IT Counsultant";
	jobs[4] = "Art Counsultant";
	jobs[5] = "TeachingAsistant";
	jobs[6] = "Data Analytics";
	jobs[7] = "UI Designer";
	jobs[8] = "Designer";
	jobs[9] = "Personal Source";

	
	String job = request.getParameter("q");	
		//I am using UL/LI to return the data to xmlHttp object. Could be anything.
	String result = "<UL>";
	for (String currentJob : jobs)   //new for loop
	{
		if (currentJob.contains(job))
		{
			result += "<LI>" + currentJob + "</LI></BR>";
		}
	}
	result += "</UL>";
	
	out.println(result);   //send this to xmlHttp object
%>
</body>
</html>