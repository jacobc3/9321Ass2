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
	<div class="head"></div>
	<div class="body">
	  <div class="login">
	    <p><a href="login">Login</a></p>
	    <p>&nbsp;</p>
	  </div>
<div class="search">
	    
	  <table width="80%" border="0">
	    <tbody>
	      <tr>
	        <td>Search</td>
	        <td><input type="text" name="textfield" id="textfield"></td>
          </tr>
	      <tr>
	        <td>By</td>
	        <td><p>
	          <label>
	            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_0">
	            Title</label>
	          <label>
	            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_1">
              Genre</label>
	          <br>
            </p></td>
          </tr>
	      <tr>
	        <td colspan="2"><input type="submit" name="submit" id="submit" value="Submit"></td>
          </tr>
        </tbody>
    </table>
</div>
      <div class="Showing_movies">
        <p>&nbsp;</p>
        <table width="80%" border="0">
          <tbody>
            <tr>
              <th colspan="5" scope="col">Now Showing</th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col">Title</th>
              <th scope="col">Rating</th>
              <th scope="col">&nbsp;</th>
              <th scope="col">&nbsp;</th>
            </tr>
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
      <div class="incoming_movies"><table width="80%" border="0">
          <tbody>
            <tr>
              <th colspan="2" scope="col">Coming Soon</th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col">Title</th>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </tbody>
        </table></div>
    </div>
	<div class="foot"></div>
	<p>&nbsp;</p>
</body>
</html>