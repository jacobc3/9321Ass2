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
    	Owner owner=(Owner) request.getAttribute("owner");
		
    %>
      <tr>
        <th width="30%" height="40" scope="row">id</th>
        <td width="70%">&nbsp;</td>
      </tr>
    <tr>
        <th width="30%" height="40" scope="row">Username</th>
        <td width="70%">&nbsp;</td>
      </tr>
      
      <tr>
        <th scope="row">Password</th>
        <td><label for="textfield2"></label></td>
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
      
        <th scope="col">Action</th>
            

        <th scope="col">Bookings of Movie</th>
        <th scope="col">User(username)</th>
        <th scope="col">of Cinema</th>
        <th scope="col">of Session</th>
      </tr>
      <tr>
        <td><table width="80%" border="0">
                  <tbody>
                    <tr><form method="GET">
                    <input type="hidden" name="booking_id" value="1">
                      <td><input type="submit" id="submit" formaction="approve" value="Approve"></td>
                      <td><input type="submit" id="submit" formaction="decline" value="Decline"></td></form>
                    </tr>
                  </tbody>
        </table></td>
        <td>&nbsp;</td>
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