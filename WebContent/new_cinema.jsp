<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="body" id="body">
<h1>Add Cinema</h1>
<form action="new_cinema">
  <table width="80%" border="0">
    <tbody>
      
      <tr>
        <th scope="row">Name</th>
        <td><label for="textfield2"></label>
          <input type="text" name="textfield2" id="textfield2"></td>
      </tr>
      <tr>
        <th scope="row">Location</th>
        <td><label for="textfield"></label>
          <input type="text" name="textfield" id="textfield"></td>
      </tr>
      <tr>
        <th scope="row">Seating Capacity</th>
        <td><label for="textfield3"></label>
          <input type="text" name="textfield3" id="textfield3"></td>
      </tr>
      <tr>
        <th scope="row">Amenities</th>
        <td><p>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="ATMs" id="CheckboxGroup1_0">
            ATMs</label>
          <br>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="widescreen" id="CheckboxGroup1_1">
            widescreen</label>
          <br>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="snack bar" id="CheckboxGroup1_1">
            snack bar</label>
          <br>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="restaurant" id="CheckboxGroup1_1">
            restaurant</label>
          <br>
        </p></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<%@ include file="footer.jsp" %>