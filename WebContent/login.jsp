<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script> 
$(function(){
  $("#header").load("header.jsp"); 
  $("#footer").load("footer.jsp"); 
});
</script>
</head>
<body>
<div id="header"></div>
<div id="container">
	<p>Login</p>	
	<%
	String msg=(String) request.getAttribute("msg");
	if(msg!=null){
%>
<font color="red"> <%=msg %></font>
<%} %>
	<form name="form1" method="post" action="login">
	  <table width="80%" border="0">
	    <tbody>
	      <tr>
        <th scope="row">Username</th>
        <td>
          <input type="text" name="username" id="textfield"></td>
      </tr>
      <tr>
        <th scope="row">Password</th>
        <td>
          <input type="password" name="password" id="textfield2"></td>
      </tr>
	      <tr>
	        <th scope="row">Login As</th>
	        <td><p>
	          <label>
	            <input type="radio" name="RadioGroup1" value="radio1" id="RadioGroup1_0" checked="checked">
	            User</label>
	          <br>
	          <label>
	            <input type="radio" name="RadioGroup1" value="radio2" id="RadioGroup1_1">
	            Owner</label>
	          <br>
            </p></td>
          </tr>
	      <tr>
	        <th scope="row"><input type="submit" name="submit" id="submit" value="Submit"></th>
	        <td>&nbsp;</td>
          </tr>
        </tbody>
      </table>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	</form>
	<p>&nbsp;</p>
<p>&nbsp;</p></div>
<div id="footer"></div>