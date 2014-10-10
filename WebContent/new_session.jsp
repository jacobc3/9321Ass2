<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%@ include file="header.jsp" %>
<div class="body" id="body">
<h1>Add Session</h1>
<form action="add_session" method="get">
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row">Movie</th>
        <td><label for="textfield2">id &amp; title</label></td>
      </tr>
      <tr>
        <th scope="row">Cinema</th>
        <td><label for="textfield2">id &amp; title</label></td>
      </tr>
      
      <tr>
        <th scope="row">Date</th>
        <td><input type="date" name="date" id="date">          
          <label for="textfield2"></label></td>
      </tr>
      <tr>
        <th scope="row">Time</th>
        <td><input type="time" name="time" id="time">          
          <label for="textfield"></label></td>
      </tr>
      <tr>
        <th scope="row"><input type="submit"  value="Submit"></th>
        <td><label for="textfield3">
          <input type="reset" name="reset" id="reset" value="Reset">
        </label></td>
      </tr>
      <tr>
        <th scope="row">&nbsp;</th>
        <td><p><br>
        </p></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<%@ include file="footer.jsp" %>