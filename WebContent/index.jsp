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
	
      <div class="movie_list">
	<%
		String username=(String) request.getSession().getAttribute("user");
		String ownername=(String) request.getSession().getAttribute("owner");
		if(username==null && ownername==null){
		
	%>
	
	
	  <div class="login">
	    <a href="login.jsp">Login</a> / <a href="new_user.jsp">Register</a>
	    <p>&nbsp;</p>
	  </div>
	  
	  <%}else if(username!=null){ %>
	  <div class="welcome">
	    Welcome back: <a href="display_user?username=<%=username %>"><%=username %></a>
	    <p>&nbsp;</p>
	  </div>
	  <%}else if(ownername!=null){%>
		  <div class="welcome">
		    Welcome back: <a href="display_owner?ownername=<%=ownername %>"><%=ownername %></a>
		    <p>&nbsp;</p>
		  </div>
		  
	 <%  } 
	  
	  %>
	  
	  
	  <%
	  	if(username!=null){
	  %>
<div class="search">
	    <form method="get" action="search">
	  <table width="80%" border="0">
	    <tbody>
	      <tr>
	        <td></td>
	        <td><input type="text" name="search"></td>
          </tr>
	      <tr>
	        <td></td>
	        <td><p>
	           <select name="search_by">
				  <option value ="radio1" selected="selected">Title</option>
				  <option value ="radio2">Genre</option>
				</select>
				<input type="submit"  value="Search">
              
           
	          <br>
            </p></td>
          </tr>
	     
        </tbody>
    </table>
    </form>
</div>
<%} %>
       <div class="movie_list"><table width="80%" border="0">
        <p>&nbsp;</p>
        <table width="80%" border="0">
        <%
        	List<Movie> showingMovies=(List<Movie>)request.getAttribute("showingmovies");
        	Iterator<Movie> iter=null;
        %>
          <tbody>
            <tr>
              <th colspan="5" scope="col">Now Showing</th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col">Title</th>
              <th scope="col">Actors</th>
              <th scope="col">Synopsis</th>
              <th scope="col">&nbsp;</th>
            </tr>
            
            <%
            	if(showingMovies!=null){
            	iter=showingMovies.iterator();
            	while(iter.hasNext()){
            		Movie movie=iter.next();
            		
            %>		
            	<tr>
            	 <%
              	String posterURL=movie.getPosterURL();
            	 if(posterURL==null) posterURL="";
            	 String actors=movie.getActors();
            	 if(actors==null) actors="";
              	String synopsis=movie.getSynopsis();
              	String syn="";
              	if(synopsis!=null){
              	if(synopsis.length()>20){
              		syn=synopsis.substring(0, 20);
              	}else{
              		syn=synopsis;
              	}}
              %>
              <td><img src="<%=posterURL %>" alt="<%=movie.getTitle() %>"/></td>
               <td><a href="movie_detail?id=<%=movie.getId() %>"><%=movie.getTitle() %></a></td>
              <td><%=actors %></td>
              <td><%=syn %></td>
              <td>&nbsp;</td>
            </tr>
            
            
            
            
            <%	
            	}}
            
            %>
            
                    
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
          </tbody>
        </table>
        <p>&nbsp;</p>
        
        <p>&nbsp;</p>
      </div>
      <div class="movie_list"><table width="80%" border="0">
        <%
        	List<Movie> commingMovies=(List<Movie>)request.getAttribute("commingmovies");
        	
        %>
          <tbody>
             <tr>
              <th colspan="5" scope="col">Comming soon</th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col">Title</th>
              <th scope="col">Actors</th>
              <th scope="col">Synopsis</th>
              <th scope="col">&nbsp;</th>
            </tr>
            
            <%
            if(commingMovies!=null){
            	iter=commingMovies.iterator();
            	while(iter.hasNext()){
            		Movie movie=iter.next();
            		
            %>		
            	<tr>
            	 <%
              	String posterURL=movie.getPosterURL();
            	 if(posterURL==null) posterURL="";
            	 String actors=movie.getActors();
            	 if(actors==null) actors="";
              	String synopsis=movie.getSynopsis();
              	String syn="";
              	if(synopsis!=null){
              	if(synopsis.length()>20){
              		syn=synopsis.substring(0, 20);
              	}else{
              		syn=synopsis;
              	}}
              %>
              <td><img src="<%=posterURL %>" alt="<%=movie.getTitle() %>"/></td>
               <td><a href="movie_detail?id=<%=movie.getId() %>"><%=movie.getTitle() %></a></td>
              <td><%=actors %></td>
              <td><%=syn %></td>
              <td>&nbsp;</td>
            </tr>
            
            
            
            
            <%	
            	}}
            
            %>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </tbody>
        </table></div>
    </div>
    <div id="footer"></div>
<!-- <%@ include file="footer.jsp" %> -->
