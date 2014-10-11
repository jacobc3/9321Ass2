<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<title>New booking</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$(".footer").load("footer.jsp");
	});
</script>
</head>
<body>
<div id="header"></div>
<div id="container">
<h1>Add Booking</h1>
<% String username = (String) request.getSession()
			.getAttribute("user");
			if(username!=null){
 %>
<form action="save_booking" method=GET>
  <table width="80%" border="0">
    <tbody>
    <%
    	Session s=(Session)request.getAttribute("session");
    %>
    <tr>
        <th scope="row">Movie</th>
        <td><label for="textfield2"><%=s.getMovie().getId() %> &amp;<%=s.getMovie().getTitle() %></label>
        <input type="hidden" name="session_id" value="<%=s.getId() %>">
        <input type="hidden" name="username" value="<%=request.getSession().getAttribute("user") %>"></td>
      </tr>
      <tr>
        <th scope="row">Cinema</th>
        <td><label for="textfield2"><%=s.getCinema().getId() %> &amp; <%=s.getCinema().getName() %></label></td>
      </tr>
      
      <tr>
        <th scope="row">Date&amp;Time</th>
        <td><label for="textfield2"><%=s.getShowDate() %></label></td>
      </tr>
      <tr>
        <th scope="row">Card Number</th>
        <td><input type="text" name="card_number"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'></td>
      </tr>
      <tr>
        <th scope="row">count</th>
        <td><input type="text" name="count"  onkeypress='return event.charCode >= 48 && event.charCode <= 57'></td>
      </tr>
      <tr>
        <th scope="row">Cinema Owner</th>
        <td><label for="textfield3">owner</label></td>
      </tr>
      <tr>
        <th scope="row"><input type="submit" value="Booking"></th>
        <td><p><br>
        </p></td>
      </tr>
    </tbody>
  </table>
  </form>
  <%} else {
  out.println("Please <a href=\"index\">log in</a> first");} %>
</div>
<div class="footer"></div>
