<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<p>&nbsp;</p>
	<div class="body">
	<form name="form1" method="get" action="search">
	<table width="80%" border="0">
	  <tbody>
	    <tr>
	      <th colspan="2" scope="col">Search</th>
        </tr>
	    <tr>
	      <td width="38%"><input type="text" name="textfield" id="textfield"></td>
	      <td width="46%"><p>
	        <label>
	          Search by 
	          <input name="search_by" type="radio" id="title" value="title" checked="checked">
	          Title</label>
	        <label>
	          <input name="search_by" type="radio" id="genre" value="genre">
	          Genre</label>
	        <br>
          </p></td>
        </tr>
	    <tr>
	      <td colspan="2"><input type="submit"  value="Submit"></td>
        </tr>
      </tbody>
</table></form>
	<p>&nbsp;</p>
<table width="80%" border="0">
		<tbody>
        <tr>
        <td> Now Showing
        </td>
        </tr>
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
<%@ include file="footer.jsp" %>