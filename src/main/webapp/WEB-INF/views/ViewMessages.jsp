<%@page import="com.jinli.myapp.pojo.User"%>
<%@page import="java.util.Set"%>
<%@page import="com.jinli.myapp.pojo.Message"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.jinli.myapp.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
function deleteItem(a){
    a.parentNode.parentNode.style.display="none";
    
}
</script>

</head>
<body>
<table class="table table-striped">
<tr>
<td>Sender</td>
<td>Content</td>
<td>Time</td>
<td>Hide</td>

</tr>
<%
Set<com.jinli.myapp.pojo.Message> messageList = (Set)session.getAttribute("messageList");
for(Message m:messageList){
	
	UserDAO userDAO = new UserDAO();
	User sender = (User)userDAO.getbyId(m.getSender());
	String senderName = sender.getUsername();
	
%>
<tr>
<td><a href="viewInfo.htm?name=<%=senderName %>"><%=senderName %></a></td>
<td><%=m.getContext() %></td>
<td><%=m.getTime() %></td>
<td><input id="Hide" type="button" value="Delete" onclick="deleteItem(this)"/></td>
</tr>
<%
}
%>
</table>



</body>
</html>