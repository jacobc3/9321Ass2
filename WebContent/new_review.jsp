<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.bean.*"%>
    <%@ page import="model.handler.*"%>
    <%@ page import="model.handlerInterface.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% Movie movie = (Movie) request.getAttribute("movie");
if(movie == null){
 movie = new MovieHandler().getMovie(1);
}
 %>
<title>Add Review of <%=movie.getTitle() %></title>
</head>
<body><%@ include file="header.jsp" %>
<div class="body" id="body">
<h1>Add Review of Movie <%=movie.getTitle() %></h1>
<form action="save_review" method=POST>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row" width=20%><label>Review Title</label></th>
        <td>
          <input type="text" name="title">
          <input type="hidden" name="movie_id" value="<%=movie.getId()%>">
          <input type="hidden" name="user_id" value="2"></td>
      </tr>
      <tr>
        <th scope="row"><label>Content</label></th>
        <td>
          <textarea name="content" cols="45" rows="5"></textarea></td>
      </tr>
      <tr>
        <th scope="row">Rating</th>
        <td>
          <label>
            <input type="radio" name="rating" value="1">
            1</label>
          <label>
            <input type="radio" name="rating" value="2">
            2</label>
          <label>
            <input type="radio" name="rating" value="3">
            3</label>
          <label>
            <input type="radio" name="rating" value="4" >
            4</label>
          <label>
            <input type="radio" name="rating" value="5">
            5</label>
          </td>
      </tr>
      <tr>
        <th scope="row">&nbsp;</th>
        <td><input type="submit" value="Submit"> <input type="reset" value="Reset">
        </td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<%@ include file="footer.jsp" %>