<%@page import="com.jinli.myapp.pojo.Job"%>
<%@page import="com.jinli.myapp.pojo.Category"%>
<%@page import="com.jinli.myapp.dao.CategoryDAO"%>
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

<table class="table table-striped">
            <tr>
                <td><b>Job Title</b></td>
                <td><b>Description</b></td>
                <td><b>Posted By</b></td>
                <td><b>Delete</b></td>
            </tr>
            <%
	
	CategoryDAO categorydao1= new CategoryDAO();
	java.util.List<Category> categoryList1 = categorydao1.list();
	System.out.println("------");
	for(Category c:categoryList1){
		
		java.util.Set<Job> jobs = c.getJobs();
		
		for(Job j:jobs){
		
			%>
		
                <tr>
                    <td><%=j.getTitle() %></td>
                    <td><%=j.getDescription() %></a></td> 
                    <td><a href="contactEmployer.htm?name=<%=j.getEmployer().getUsername() %>" ><%=j.getEmployer().getUsername() %></a></td>
                	<td><a href="viewJobs.htm?jobname=<%=j.getTitle() %>">Delete</a></td>
                </tr>
         
         <%
		}
	}
         %>
          
</table>

</body>
</html>