<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>&nbsp;</p>
	<form name="form1" method="post" action="">
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
	          <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_0">
	          Title</label>
	        <label>
	          <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_1">
	          Genre</label>
	        <br>
          </p></td>
        </tr>
	    <tr>
	      <td colspan="2"><input type="submit" name="submit" id="submit" value="Submit"></td>
        </tr>
      </tbody>
</table></form>
	<p>&nbsp;</p>
	<%
		List<Movie> movies = (List<Movie>) request.getAttribute("movies");
		Iterator<Movie> movie_iterator = movies.iterator();
	%>
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
				while (movie_iterator.hasNext()) {
					Movie movie = (Movie) movie_iterator.next();
					String movieTitle = movie.getTitle();
					int movieID = movie.getId();
					
					Set<Genre> genres = movie.getGenres();
					String genresString = "";
					for(Genre a : genres){
						genresString += a.getName();
					}
			%>
			<tr><td><a href="movie_detail?id=<%=movieID%>"><%=movieTitle%></a></td>
				<td><%=genresString%></td>
                <td></td>
                <td></td>
                 <td></td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
<p><a href="index">Back to index</a></p>
</body>
</html>