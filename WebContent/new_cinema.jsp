<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="model.handler.*"%>
    <%@ page import="model.handlerInterface.*"%>
    <%@ page import="model.bean.*"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Cinema</title>
<script src="js/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
</head>
<body>
<div id="header"></div>
<div id="container">
<%String ownername = (String) request.getSession().getAttribute(
				"owner");
		if(ownername!=null && ownername.compareTo("")!=0){ %>
<h1>Add Cinema</h1>
<form action="new_cinema" method="POST">
  <table width="80%" border="0">
    <tbody>
      
      <tr>
        <th scope="row">Name</th>
        <td><label for="name"></label>
          <input type="text" name="name"></td>
      </tr>
      <tr>
        <th scope="row">Location</th>
        <td><label for="location"></label>
          <input type="text" name="location"></td>
      </tr>
      <tr>
        <th scope="row">Seating Capacity</th>
        <td><label for="capacity"></label>
          <input type="text" name="capacity" onkeypress='return event.charCode >= 48 && event.charCode <= 57'></input></td>
      </tr>
      <tr>
      <% CinemaHandlerInterface ch = new CinemaHandler();
      	List<Amenity> as = ch.getAllAmenities();
       %>
        <th scope="row">Amenities</th>
        <td>
        <%for(Amenity a : as){ %>
          <label>
            <input type="checkbox" name="amenities" value="<%=a.getId() %>" >
            <%=a.getName() %></label></br>
        <%} %>
            </td>
      </tr>
       <tr>
        <th scope="row"></th>
        <td><input type="submit"  value="Submit">
          <input type="reset" value="Reset">
        </td>
        </tr>
    </tbody>
  </table>
  </form><%} else {
	out.println("Your are not authorized to add cinema");	}%>
</div>
<div id="footer"></div>