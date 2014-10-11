<head><link rel="stylesheet" href="style.css" type="text/css" />
	<header id="header" class="clear">
    

<div id="hgroup"><a href="${pageContext.request.contextPath}/index"><img width=55
		height=55 src="images/movie-reel.gif" /></a><h1>Movie Review &amp; Booking</h1>
</div>
<%
	String username = (String) request.getSession()
			.getAttribute("user");
	String ownername = (String) request.getSession().getAttribute(
			"owner");
	if (username == null && ownername == null) {
%>


<nav>
	<a href="login.jsp">Login</a> / <a href="new_user.jsp">Register</a>
	<p>&nbsp;</p>
    </nav>
<%
	} else if (username != null) {
%>
<nav>
	Welcome back: <a href="display_user?username=<%=username%>"><%=username%></a>
	| <a href="logout">logout</a></nav>
<%
	} else if (ownername != null) {
%>
<nav>
	Welcome back: <a href="display_owner?ownername=<%=ownername%>"><%=ownername%></a>
	| <a href="logout">logout</a></nav>


<%
	}
%>


<%
	if (username != null) {
%>
<nav>
	<form method="get" action="search">
		<table width="80%" border="0">
			<tbody>
				<tr>
					<td>Search</td>
					<td><input type="text" name="search"></td>
				</tr>
				<tr>
					<td><label for="select">By</label></td>
					<td><select name="search_by">
							<option value="title">Title</option>
							<option value="genre">Genre</option>
					</select> <input type="submit" value="Submit"> <br>
						</td>
				</tr>

			</tbody>
		</table>
	</form>
</nav>
<%
	}
%>

</header>	