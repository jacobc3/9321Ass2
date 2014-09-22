<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href="/add_movie">Add Movie</a>
</p>
<p><a href="/add_cinema">Add Cinema</a></p>
<table width="80%" border="0">
  <tbody>
    <tr>
      <th scope="col">Movie id</th>
      <th scope="col">title</th>
      <th scope="col">Genre</th>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>

 <%
			List<Cinema> cinemas = (List<Cinema>) request.getAttribute("cinemas");
 			Iterator<Cinema> iterator = cinemas.iterator();
		%>
<table width="80%" border="0">
  <tbody>
    <tr>
      <th scope="col">Cinema id</th>
      <th scope="col">title</th>
      <th scope="col">amenities</th>
    </tr>
    <%
    	while(iterator.hasNext()){
			Cinema cinema = (Cinema) iterator.next();
			String cinemaName = cinema.getName();
			int cinemaID = cinema.getId();
			/*
			Set<Amenity> amenities = cinema.getAmenities();
			String amenitiesString = "";
			for(Amenity a : amenities){
				amenitiesString += a.getName();
			}*/			
			%>
			<tr>
      <td><%=cinemaID %></td>
      <td><%=cinemaName %></td>
      <td>Amenities</td>
    </tr>
			
			<%
			//out.println("name:"+cinema.getName()+"&nbsp;id:"+cinema.getId()+"<br>");
		} 
    
    
		%>
    
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>
<p>&nbsp;</p>
</body>
</html>