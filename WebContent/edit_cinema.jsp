<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		<h1>Edit Cinema</h1>
		<form>
			<table width="80%" border="0">
				<tbody>
					<tr>
						<th scope="row">id</th>
						<td><label for="textfield2">afqwf <input
								name="hiddenField" type="hidden" id="hiddenField"
								value="hiddenId">
						</label></td>
					</tr>

					<tr>
						<th scope="row">Name</th>
						<td><label for="textfield2"></label> <input type="text"
							name="textfield2" id="textfield2"></td>
					</tr>
					<tr>
						<th scope="row">Location</th>
						<td><label for="textfield"></label> <input type="text"
							name="textfield" id="textfield"></td>
					</tr>
					<tr>
						<th scope="row">Seating Capacity</th>
						<td><label for="textfield3"></label> <input type="text"
							name="textfield3" id="textfield3"></td>
					</tr>
					<tr>
						<th scope="row">Amenities</th>
						<td><p>
								<label> <input type="checkbox" name="CheckboxGroup1"
									value="checkbox" id="CheckboxGroup1_0"> Checkbox
								</label> <br> <label> <input type="checkbox"
									name="CheckboxGroup1" value="checkbox" id="CheckboxGroup1_1">
									Checkbox
								</label> <br>
							</p></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<%@ include file="footer.jsp"%>