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
	        <td>Search</td>
	        <td><input type="text" name="search"></td>
          </tr>
	      <tr>
	        <td>By</td>
	        <td><p>
	           <select>
				  <option value ="radio1" selected="selected">Title</option>
				  <option value ="radio2">Genre</option>
				</select>
				<input type="submit"  value="Submit">
              
           
	          <br>
            </p></td>
          </tr>
	     
        </tbody>
    </table>
    </form>
</div>
<%} %>
      <div class="Showing_movies">
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
        <%
        	List<Movie> commingMovies=(List<Movie>)request.getAttribute("commingmovies");
        	
        %>
          <tbody>
            <tr>
              <th colspan="2" scope="col">Coming Soon</th>
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
	<div class="foot"></div>
	<p>&nbsp;</p>
</body>
</html>