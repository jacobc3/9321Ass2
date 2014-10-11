<link rel="stylesheet" href="style.css" type="text/css" />

<div id="logo">
	<a href="${pageContext.request.contextPath}/index"> <img width=55
		height=55 src="images/movie-reel.gif" /></a> Movie Review &amp; Booking
</div>
<%
	String username = (String) request.getSession()
			.getAttribute("user");
	String ownername = (String) request.getSession().getAttribute(
			"owner");
	if (username == null && ownername == null) {
%>


<div id="login">
	<a href="login.jsp">Login</a> / <a href="new_user.jsp">Register</a>
	<p>&nbsp;</p>
</div>

<%
	} else if (username != null) {
%>
<div id="welcome">
	Welcome back: <a href="display_user?username=<%=username%>"><%=username%></a>        <a href="logout">logout</a> 
</div>
<%
	} else if (ownername != null) {
%>
<div id="welcome">
	Welcome back: <a href="display_owner?ownername=<%=ownername%>"><%=ownername%></a><a href="logout">logout</a>
</div>

<%
	}
%>


<%
	if (username != null) {
%>
<div id="search">
	<form method="get" action="search">
		<table width="80%" border="0">
			<tbody>
				<tr>
					<td>Search</td>
					<td><input type="text" name="search"></td>
				</tr>
				<tr>
					<td>By</td>
					<td><p>
							<select>
								<option value="radio1" selected="selected">Title</option>
								<option value="radio2">Genre</option>
							</select> <input type="submit" value="Submit"> <br>
						</p></td>
				</tr>

			</tbody>
		</table>
	</form>
</div>
<%
	}
%>