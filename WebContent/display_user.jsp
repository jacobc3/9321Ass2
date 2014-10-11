<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Detail</title>
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
		<%
			User user = (User) request.getAttribute("user");

			if (user != null) {
				List<Review> reviews = (List<Review>) request
						.getAttribute("reviews");
				List<Booking> bookings = (List<Booking>) request
						.getAttribute("bookings");
				String username1 = (user.getUsername() != null) ? user
						.getUsername() : "";
				String email = (user.getEmail() != null) ? user.getEmail() : "";
				String password = "****";
				String firstname = (user.getFirstname() != null) ? user
						.getFirstname() : "";
				String lastname = (user.getLastname() != null) ? user
						.getLastname() : "";
				String nickname = (user.getNickname() != null) ? user
						.getNickname() : "";
		%>
		<h1>Your Profile</h1>
		<a href="edit_user.jsp?id=<%=user.getId()%>">Edit</a>
		<table width="80%" border="0">
			<tbody>

				<tr>
					<th width="30%" scope="row">Username</th>
					<td width="70%"><%=username1%></td>
				</tr>
				<tr>
					<th scope="row">Email</th>
					<td><%=email%></td>
				</tr>

				<tr>
					<th scope="row">Password</th>
					<td><%=password%></td>
					<td><label for="textfield2"></label></td>
				</tr>
				<tr>
					<th scope="row">First name</th>
					<td><%=firstname%></td>
				</tr>
				<tr>
					<th scope="row">Last Name</th>
					<td><%=lastname%></td>
				</tr>

				<tr>
					<th scope="row">Nickname</th>
					<td><%=nickname%></td>
				</tr>
				
				<tr>
					<th scope="row">Registry Date</th>
					<td><%=user.getregistryDate() %></td>
				</tr>
			</tbody>
		</table>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<table width="80%" border="0">
			<tbody>
				<tr>
					<th scope="col">Reviews(title)</th>
					<th scope="col">of Movie</th>
					<th scope="col">Rating</th>
				</tr>

				<%
					Iterator<Review> iter = reviews.iterator();
						while (iter.hasNext()) {
							Review review = iter.next();
							String title = (review.getTitle() != null) ? review
									.getTitle() : "";
							String movieTitle = (review.getMovie().getTitle() != null) ? review
									.getMovie().getTitle() : "";
							String movieid = review.getMovie().getId() + "";
							int rate = review.getRating();
							String rating = "";
							if (rate == 0) {
								rating = "N/A";
							} else {
								rating = rate + "";
							}
				%>
				<tr>
					<td><%=title%></td>
					<td><a href="movie_detail?id=<%=movieid%>"><%=movieTitle%>~~</a></td>
					<td><%=rating%></td>
					<td><a href="edit_review.jsp?id=<%=review.getId() %>" %>Edit</td>
				</tr>

				<%
					}
				%>



			</tbody>
		</table>
		<p>&nbsp;</p>
		<table width="80%" border="0">
			<tbody>
				<tr><th scope="col">Bookings id</th>
					<th scope="col">Bookings of Movie</th>
					<th scope="col">of Cinema</th>
					<th scope="col">of Session</th>
					<th scope="col">Order Status</th>
					<th scope="col">Count</th>
					<th scope="col">Card number</th>
				</tr>
				<%
					Iterator<Booking> iter2 = bookings.iterator();
						while (iter2.hasNext()) {
							Booking booking = iter2.next();
				%>
				<tr><td><%=booking.getId()%></td>
					<td><%=booking.getSession().getMovie().getTitle()%></td>
					<td><%=booking.getSession().getCinema().getName()%></td>
					<td><%=booking.getSession().getShowDate()%></td>
					<td><%=booking.getStatus()%></td>
					<td><%=booking.getCount()%></td>
					<td><%=booking.getCardNumber()%></td>
				</tr>


				<%
					}
				%>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<%
			} else {
		%>User does not exist!<%
			}
		%>

	</div>
	<div id="footer"></div>