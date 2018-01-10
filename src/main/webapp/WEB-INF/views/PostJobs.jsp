<%@page import="com.jinli.myapp.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//get the category list
        CategoryDAO categorydao= new CategoryDAO();
        java.util.List categoryList = categorydao.list();
        pageContext.setAttribute("categories", categoryList);
%>

<div class="jumbotron" style="margin-top:30px;">

<div style="padding-left:30px;">
 <form:form action="postJobs.htm" commandName="job" method="post">

            <table>

                <tr>
                  <td>Category:</td>
                    <td>
                        <form:select path="category_name">
                            <c:forEach var="categ" items="${categories}">
                                <form:option value="${categ.title}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td>Job Title:</td>
                    <td><form:input path="title" size="30" /> </td>
                </tr>

                <tr>
                    <td>Description:</td>
                    <td><form:input path="description" size="30" /></td>
                </tr>
<!--  
                <tr>
                    <td>Job Posted By:</td>
                    <td><form:input path="postedBy" size="30" /> <font color="red"><form:errors path="postedBy"/></font></td>
                </tr>
-->
                <tr>
                    <td colspan="2"><input type="submit" class="btn btn-primary btn-lg" style="margin-top:10px; margin-left:30px;" value="Post Advert" /></td>
                </tr>
            </table>

        </form:form>
        </div>
</div>
</body>
</html>