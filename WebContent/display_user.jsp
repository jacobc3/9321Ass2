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
<div class="head" id="head">Content for  class "head" id "head" Goes Here</div>
<div class="body" id="body">
<h1>Your Profile</h1>
  <table width="80%" border="0">
    <tbody>
    <%
    	User user=(User) request.getAttribute("user");
		List<Review> reviews=(List<Review>) request.getAttribute("reviews");
		List<Booking> bookings=(List<Booking>) request.getAttribute("bookings");
		String username=(user.getUsername()!=null)?user.getUsername():"";
		String email=(user.getEmail()!=null)?user.getEmail():"" ;
		String password="****";
		String firstname=(user.getFirstname()!=null)?user.getFirstname():"";
		String lastname=(user.getLastname()!=null)?user.getLastname():"";
		String nickname=(user.getNickname()!=null)?user.getNickname():"";
    %>
    <tr>
        <th width="30%" height="40" scope="row">Username</th>
        <td width="70%"><%=username %></td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td><%=email %></td>
      </tr>
      
      <tr>
        <th scope="row">Password</th>
         <td><%=password %></td>
        <td><label for="textfield2"></label></td>
      </tr>
      <tr>
        <th scope="row">First name</th>
        <td><%=firstname %></td>
      </tr>
      <tr>
        <th scope="row">Last Name</th>
        <td><%=lastname %></td>
      </tr>
      
      <tr>
        <th scope="row">Nickname</th>
        <td><%=nickname %></td>
        <td><p><br>
        </p></td>
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
      	 Iterator<Review> iter=reviews.iterator();
      	while(iter.hasNext()){
      		Review review=iter.next();
      		String title=(review.getTitle()!=null)?review.getTitle():"";
      		String movieTitle=(review.getMovie().getTitle()!=null)?review.getMovie().getTitle():"";
      		int rate=review.getRating();
      %>
      <tr>
        <td><%=title %></td>
        <td><%=movieTitle %></td>
        <td><%=rate %></td>
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
  <table width="80%" border="0">
    <tbody>
      <tr>
        <th scope="col">Bookings of Movie</th>
        <th scope="col">of Cinema</th>
        <th scope="col">of Session</th>
      </tr>
      <%
      	Iterator<Booking> iter2=bookings.iterator();
      	while(iter2.hasNext()){
      		Booking booking=iter2.next();
  		%>
  		 <tr>
        <td><%=booking.getSession().getMovie().getTitle() %></td>
        <td><%=booking.getSession().getCinema().getName() %></td>
        <td><%=booking.getSession().getShowDate() %></td>
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
</div>
<div class="foot" id="foot">Content for  class "foot" id "foot" Goes Here</div>
</body>
</html>