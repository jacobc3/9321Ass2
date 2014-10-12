<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<%@ page import="model.handler.*"%>
<%@ page import="model.handlerInterface.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<%
		String sid=request.getParameter("id");
		MovieHandler mi=new MovieHandler();
		Movie movie=mi.getMovie(Integer.parseInt(sid));
		request.setAttribute("id", sid);
		
	%>
		<h1>Edit Movie</h1>
		<form action="edit_movie">
			<table width="80%" border="0">
				<tbody>
					<tr>
						<th width="22%" scope="row">id</th>
						<td width="78%"><input type="hidden" name="movie_id"
							id="hiddenField" value="<%=sid %>"><label><%=sid %></label></td>
					</tr>
					<tr>
						<th scope="row">title</th>
						<td><label for="textfield2"></label> <input type="text"
							name="movieTitle" id="textfield2" value="<%=movie.getTitle() %>"></td>
					</tr>
					<tr>
						<th scope="row">actors</th>
						<td><label for="textfield"></label> <input type="text"
							name="movieActor" id="textfield" value="<%=movie.getActors()  %>"></td>
					</tr>
					<tr>
						<th scope="row">poster</th>
						<td><label for="textfield3"></label> <input type="text"
							name="moviePoster" id="textfield3" value="<%=movie.getPosterURL()%>"></td>
					</tr>
					<tr>
						<th scope="row">release date</th>
						<td><label for="date"></label> <input type="date" name="date"
							id="date" value="<%= movie.getRelease_date().toString()  %>"></td>
					</tr>
					<tr>
						<th scope="row">synopsis</th>
						<td><label for="textfield4"></label><textarea name="movieSyn" cols="45" rows="5"
								id="textfield4"><%= movie.getSynopsis()%></textarea></td>
					</tr>
					<tr>
						<th scope="row">genres</th>
						
							
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
        <th scope="row"></th>
        <td><input type="submit"  value="Submit">
          <input type="reset" value="Reset">
        </td>
        </tr>
					
				</tbody>
			</table>
		</form>
	</div>
	<%@ include file="footer.jsp"%>