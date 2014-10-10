<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />

<title>Index</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script> 
$(function(){
  $("#header").load("header.jsp"); 
  $("#footer").load("footer.jsp"); 
});
</script>
</head>
<body>
<div id="header"></div>
	<div id="body">
	  <div id="login">
	    <p><a href="login">Login</a></p>
	  </div>
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
                      <label>
                        <input name="search_by" type="radio" value="radio" checked="checked">
                        Title</label>
                      <label>
                        <input type="radio" name="search_by" value="radio">
                      Genre</label>
                      <br>
                    </p></td>
                  </tr>
                  <tr>
                    <td colspan="2"><input type="submit"  value="Submit"></td>
                  </tr>
                </tbody>
            </table>
          </form>
      </div>
      <div class="movie_list">
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
      <div class="movie_list"><table width="80%" border="0">
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
    <div id="footer"></div>
<!-- <%@ include file="footer.jsp" %> -->