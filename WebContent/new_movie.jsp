<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.handler.*"%>
    <%@ page import="model.handlerInterface.*"%>
    <%@ page import="model.bean.*"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%@ include file="header.jsp" %>
<div class="body" id="body">
<h1>Add Movie</h1>
<form action="save_movie" method=POST>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row"><labeo for="title">Title</label></th>
        <td><input type="text" name="title"></td>
      </tr>
      <tr>
        <th scope="row"><label for="posterURL">Poster</label></th>
        <td><input type="text" name="posterURL"></td>
      </tr>
      <tr>
        <th scope="row"><label for="actors">Actors</label></th>
        <td><input type="text" name="actors">          
          </td>
      </tr>
      <tr>
        <th scope="row"><label for="textfield">Synopsis</label></th>
        <td><textarea name="synopsis" cols="45" rows="5" maxlength="400"></textarea>          
          </td>
      </tr>
      <tr>
        <th scope="row"><label for="textfield">Genres</label></th>
        <td><p>
        <% MovieHandlerInterface mh = new MovieHandler();
        List<Genre> gs = mh.getAllGenres();
        for(Genre g: gs){
        %>
          <label>
            <input type="checkbox" name="genre" value="<%=g.getId() %>" id="CheckboxGroup1_0">
           <%=g.getName() %></label>
          <br>
          <%
          } %>
        </p>
        </td>
      </tr>
      <tr>
        <th scope="row"><input type="submit"  value="Submit"></th>
        <td><p>
          <input type="reset" value="Reset">
          <br>
        </p></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<%@ include file="footer.jsp" %>