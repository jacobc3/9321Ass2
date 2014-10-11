<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seach Result of by</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
</head>
<body>
<div id="header"></div>
	<div id="body">
	Results:
<table width="80%" border="0">
		<tbody>
			<tr>
				<th width="33%" scope="col">Title</th>
				<th width="33%" scope="col">Genre</th>
                <th width="33%" scope="col">Poster</th>
                <th width="33%" scope="col">Rating</th>
                 <th width="33%" scope="col">Actors</th>
			</tr>
			 <%
              	ArrayList<Movie> movies=(ArrayList<Movie>)request.getAttribute("movies");
              %>
			<tr><td><a href=""></a></td>
				<td></td>
                <td></td>
                <td></td>
                 <td></td>
			</tr>
			<% 
				if(movies!=null){
					Iterator<Movie> iter=movies.iterator();
					while(iter.hasNext()){
						Movie m=iter.next();
			%>
			<tr><td><a href="movie_detail?id=<%=m.getId() %>"><%=m.getTitle() %></a></td>
				<% 
					Set<Genre> g=m.getGenres();
					Iterator<Genre> iter1=g.iterator();
					String s="";
					while(iter1.hasNext()){
						Genre k=iter1.next();
						s=s+k.getName()+" ";
					}	
				%>
				<td><%=s %></td>
				
                <td><img src="<%=m.getPosterURL() %>" alt="<%=m.getTitle() %>"/></td>
                <td></td>
                <td><%=m.getActors() %></td>
			</tr>
			
	
			<%		}
				}
			%>

		</tbody>
	</table>
	</div>
<div id="footer"></div>