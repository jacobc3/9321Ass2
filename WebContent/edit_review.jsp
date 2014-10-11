<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<%@ page import="model.handler.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Review</title>
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
		<%
			String sid = request.getParameter("id");
			ReviewHandler ri = new ReviewHandler();
			Review review = ri.getReviewsById(Integer.parseInt(sid));
			request.setAttribute("id", sid);
		%>
		<form action="edit_review">
			<table width="80%" border="0">
				<tbody>
					<tr>
						<th scope="row" width=20%><label>Review Title</label></th>
						<td><input type="text" name="title"
							value="<%=review.getTitle()%>"> <input type="hidden"
							name="review_id" value="<%=review.getId()%>">
					</tr>
					<tr>
						<th scope="row"><label>Content</label></th>
						<td><textarea name="content" cols="45" rows="5"
								value="<%=review.getContent()%> "><%=review.getContent()%></textarea></td>
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
	</div>
</body>
</html>