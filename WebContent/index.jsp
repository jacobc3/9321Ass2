<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />

<title>Index</title>
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
		<div class="movie_list">
				<table width="80%" border="0">
					<%
						List<Movie> showingMovies = (List<Movie>) request
								.getAttribute("showingmovies");
						Iterator<Movie> iter = null;
					%>
					<tbody>
						<tr>
							<th colspan="5" scope="col">Now Showing</th>
						</tr>
						<tr>
							<th scope="col">PosterURL</th>
							<th scope="col">Title</th>
							<th scope="col">Actors</th>
							<th scope="col">Synopsis</th>
							<th scope="col">&nbsp;</th>
						</tr>

						<%
							if (showingMovies != null) {
								iter = showingMovies.iterator();
								while (iter.hasNext()) {
									Movie movie = iter.next();
						%>
						<tr>
							<%
								String posterURL = movie.getPosterURL();
										if (posterURL == null)
											posterURL = "";
										String actors = movie.getActors();
										if (actors == null)
											actors = "";
										String synopsis = movie.getSynopsis();
										String syn = "";
										if (synopsis != null) {
											if (synopsis.length() > 20) {
												syn = synopsis.substring(0, 20);
											} else {
												syn = synopsis;
											}
										}
							%>
							<td><img src="<%=posterURL%>" alt="<%=movie.getTitle()%>" /></td>
							<td><a href="movie_detail?id=<%=movie.getId()%>"><%=movie.getTitle()%></a></td>
							<td><%=actors%></td>
							<td><%=syn%></td>
							<td>&nbsp;</td>
						</tr>




						<%
							}
							}
						%>


						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</tbody>
				</table>
				<p>&nbsp;</p>
				<table width="80%" border="0">
					<tbody>
						<tr>
							<th scope="col">Title</th>
							<th scope="col">Genre</th>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</tbody>
				</table>
				<p>&nbsp;</p>

				<p>&nbsp;</p>
				</div>
				<div class="movie_list">
					<table width="80%" border="0">
						<%
							List<Movie> commingMovies = (List<Movie>) request
									.getAttribute("commingmovies");
						%>
						<tbody>
							<tr>
								<th colspan="2" scope="col">Coming Soon</th>
							</tr>
							<tr>
								<th scope="col">PosterURL</th>
								<th scope="col">Title</th>
								<th scope="col">Actors</th>
								<th scope="col">Synopsis</th>
								<th scope="col">&nbsp;</th>
							</tr>

							<%
								if (commingMovies != null) {
									iter = commingMovies.iterator();
									while (iter.hasNext()) {
										Movie movie = iter.next();
							%>
							<tr>
								<%
									String posterURL = movie.getPosterURL();
											if (posterURL == null)
												posterURL = "";
											String actors = movie.getActors();
											if (actors == null)
												actors = "";
											String synopsis = movie.getSynopsis();
											String syn = "";
											if (synopsis != null) {
												if (synopsis.length() > 20) {
													syn = synopsis.substring(0, 20);
												} else {
													syn = synopsis;
												}
											}
								%>
								<td><img src="<%=posterURL%>" alt="<%=movie.getTitle()%>" /></td>
								<td><a href="movie_detail?id=<%=movie.getId()%>"><%=movie.getTitle()%></a></td>
								<td><%=actors%></td>
								<td><%=syn%></td>
								<td>&nbsp;</td>
							</tr>




							<%
								}
								}
							%>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
		</div>
		<div id="footer"></div>
		<!-- <%@ include file="footer.jsp" %> -->