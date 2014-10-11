<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<%@ page import="model.handler.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<%
	Movie m=(Movie)request.getAttribute("mdetail");
		List<Session> ses=(List<Session>)request.getAttribute("session");
		List<Review> rev=(List<Review>)request.getAttribute("reviews");
%>
<%DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");%>
<title>Movie detail of <%=m.getTitle()%></title>
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
	<div id="container">
		<h1>Movie</h1>
		<div class="movie">
		<table width="83%" border="0">
			<tbody>
				<tr>
					<td><%if(m.getPosterURL() != null && m.getPosterURL()!=""){ %><img src="<%=m.getPosterURL()%>" width="400"
						alt="<%=m.getTitle()%>" /><%} %></td>
					<td width="100%"><table width="100%" border="0">
							<tbody>
								<tr>
									<th width="22%" scope="row">id</th>
									<td width="78%"><%=m.getId()%></td>
								</tr>
								<tr>
									<th scope="row">title</th>
									<td><%=m.getTitle()%></td>
								</tr>
								<tr>
									<th scope="row">actors</th>
									<td><%=m.getActors()%></td>
								</tr>
								<tr>
									<th scope="row">poster</th>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<th scope="row">release date</th>
									<td><%DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");%><%=df2.format(m.getRelease_date()) %></td>
								</tr>
								<tr>
									<th scope="row">synopsis</th>
									<td><%=m.getSynopsis()%></td>
								</tr>
								<tr>
									<th scope="row">genres</th>
									<td>
										<%
											List<Genre> gs = new MovieHandler().getGenresByMovie(m.getId());
											Iterator<Genre> iter1 = gs.iterator();
											while (iter1.hasNext()) {
												Genre k = iter1.next();
												out.println(k.getName() + "</br>");
											}
										%>
									</td>
								</tr>
								<tr>

								</tr>
							</tbody>
						</table></td>
				</tr>
			</tbody>
		</table>
		</div>
		<hr><br>
<div class="session">
		<%
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 30);
			Date d = calendar.getTime();
			System.out.println(" within day range of " + d);
			if (m.getRelease_date().before(d)) {
		%>
		<table width="80%" border="0">
			<tbody>
				<tr>
					<th scope="col">Now showing on</th>
					<th scope="col">
                    <table width="80%" border="0">
							<tbody>
								<tr>
									<th scope="col">Cinema</th>
									<th scope="col">Date&amp;Time</th>
									<th scope="col">Fullness</th>
								</tr>
								<%
									Iterator<Session> iter2 = ses.iterator();
										while (iter2.hasNext()) {
											Session sessions = iter2.next();
								%>
								<tr>
									<td><%=sessions.getCinema().getName()%></td>
									<td><%
									String reportDate = df.format(sessions.getShowDate());%><a href="new_booking?id=<%=sessions.getId()%>"><%=reportDate%></a></td>
									<td><%=new SessionHandler().getBookedSeatsCount(sessions
							.getId())%>/<%=sessions.getCinema().getCapacity()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table> <%
 	String ownername = (String) request.getSession().getAttribute(
 				"owner");
 		if (ownername != null && ownername != "") {
 %>
						<hr> Add new Session<br>
						<table width="80%" border="0">
							<tr>
								<th scope="col">At Cinema</th>
								<th scope="col">At Date &amp;Time<br> yyyy-MM-dd
									HH:mm:ss
								</th>
								<th scope="col">submit</th>
							</tr>
							<tr>
								<form method="GET" action="save_session">
									<td>
										<%
											List<Cinema> cinemas = new CinemaHandler().getAllCinemas();
										%>
										<select name="cinema">
											<%
												for (Cinema c : cinemas) {
											%>
											<option value="<%=c.getId()%>"><%=c.getName()%></option>
											<%
												}
											%>
									</select>
									</td>
									<td><input type="datetime-local" name="datetime"></td>
									<td><input type="hidden" name="movie_id"
										value="<%=m.getId()%>"> <input type="submit"
										value="Submit"></td>
								</form>
							</tr>
						</table>
                        <%
			} // END OF IF OWNER
		%>
                        </th>
				</tr>
			</tbody>
		</table>
		</div>
		<hr><div class="reviews">
		<table width="80%" border="0">
			<tbody>
				<tr>
					<th scope="col" width="10%">Reviews title</th>
					<th scope="col">Content</th>
					<th scope="col" width="10%">by User</th>
					<th scope="col" width="10%">On date</th>
					<th scope="col" width="5%">Rating</th>
				</tr>

				<%
					if (rev != null) {
							Iterator<Review> iter3 = rev.iterator();
							while (iter3.hasNext()) {
								Review reviews = iter3.next();
								String display_name = reviews.getUser().getNickname();
								if (display_name == null || display_name == "") {
									display_name = reviews.getUser().getFirstname()
											+ " " + reviews.getUser().getLastname();
								}
								String rating = "N/A";
								if (reviews.getRating() != 0) {
									rating = reviews.getRating() + "";
								}
				%>
				<tr>
					<td><%=reviews.getTitle()%></td>
					<td><%=reviews.getContent()%></td>
					<td><%=display_name%></td>
					<td><%=df.format(reviews.getPostDate())%></td>
					<td><%=rating%></td>
				</tr>

				<%
					}
						}
				%>


			</tbody>
		</table>
        </div>
		<hr>

		<%
			String username = (String) request.getSession().getAttribute(
						"user");

				if (username != null && username != "") {

					if (m.getRelease_date() != null
							&& m.getRelease_date().before(new Date())) {
						int user_id = new UserHandler().getUserByUsername(
								username).getId();
		%>
        <div class="review_form">
		<form action="save_review" method=POST>
			<table width="80%" border="0">
				<tbody>
					<tr>
						<th scope="row" width=20%><label>Review Title</label></th>
						<td><input type="text" name="title"> <input
							type="hidden" name="movie_id" value="<%=m.getId()%>"> <input
							type="hidden" name="user_id" value="<%=user_id%>"></td>
					</tr>
					<tr>
						<th scope="row"><label>Content</label></th>
						<td><textarea name="content" cols="45" rows="5"></textarea></td>
					</tr>
					<tr>
						<th scope="row">Rating</th>
						<td><label> <input type="radio" name="rating"
								value="1"> 1
						</label> <label> <input type="radio" name="rating" value="2">
								2
						</label> <label> <input type="radio" name="rating" value="3">
								3
						</label> <label> <input type="radio" name="rating" value="4">
								4
						</label> <label> <input type="radio" name="rating" value="5">
								5
						</label></td>
					</tr>
					<tr>
						<th scope="row">&nbsp;</th>
						<td><input type="submit" value="Submit"> <input
							type="reset" value="Reset"></td>
					</tr>
				</tbody>
			</table>
		</form>
		<%
			} else {
						out.println("not playing yet. Come back when movie is showing");
					}

				} else {
		%>Please <a href="login.jsp">Log in</a> to review
		<%
			}//END OF LOG IN
			%>
			</div>
			<%
			}//END OF IF SHOWING
		%>

		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>
	<div id="footer"></div>