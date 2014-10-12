<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="model.bean.*"%>
<%@ page import="model.handler.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />

<title>Index PC-version</title>
<script src="js/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
<script type='text/javascript'>
(function()
{
  if( window.localStorage )
  {
    if( !localStorage.getItem( 'firstLoad' ) )
    {
      localStorage[ 'firstLoad' ] = true;
      window.location.reload();
    }  
    else
      localStorage.removeItem( 'firstLoad' );
  }
})();

</script>
<%DateFormat df = new SimpleDateFormat("yyyy-MM-dd");%>
</head>
<body>
<div id ="header"></div>
<div id="container">
       <div class="movie_list">
        <table border="0">
        <%
        	List<Movie> showingMovies=(List<Movie>)request.getAttribute("showingmovies");
        	Iterator<Movie> iter=null;
        %>
          <tbody>
            <tr>
              <th colspan="5" scope="col"><h1>Now Showing</h1></th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col" width="200px">Title</th>
              <th scope="col">Actors</th>
              <th scope="col">Synopsis</th>
              <th scope="col" width="20px">Rating</th>
            </tr>
            
            <%
            	if(showingMovies!=null){
            		MovieHandler mi=new MovieHandler();
            	iter=showingMovies.iterator();
            	while(iter.hasNext()){
            		Movie movie=iter.next();
            		
            		double ra=mi.getAveRatingByMovie(movie.getId());
            		
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
              		syn=synopsis.substring(0, 20)+"...";
              	}else{
              		syn=synopsis;
              	}}
              %>
              <td>
              <%if(posterURL != null && posterURL.compareTo("")!=0){ %>
              <a href="movie_detail?id=<%=movie.getId() %>"><img src="<%=posterURL %>" width="140" alt="<%=movie.getTitle() %>"/></a>
              <%} %>
              </td>
               <td><a href="movie_detail?id=<%=movie.getId() %>"><%=movie.getTitle() %></a></td>
              <td><%=actors %></td>
              <td><%=syn+"" %></td>
              <td><%=new Double(ra).intValue() %></td>
            </tr>
            
            
            
            
            <%	
            	}}
            
            %>
          </tbody></table>
      </div><hr>
      <div class="movie_list"><table border="0">
        <%
        	List<Movie> commingMovies=(List<Movie>)request.getAttribute("commingmovies");
        	
        %>
          <tbody>
             <tr>
              <th colspan="5" scope="col"><h1>Comming soon</h1></th>
            </tr>
            <tr>
              <th scope="col">PosterURL</th>
              <th scope="col" width = "200px">Title</th>
              <th scope="col">Actors</th>
              <th scope="col">Synopsis</th>
              <th scope="col" width="200px">Coming date</th>
            </tr>
            
            <%
            if(commingMovies!=null){
            	MovieHandler mi=new MovieHandler();
            	iter=commingMovies.iterator();
            	while(iter.hasNext()){
            		Movie movie=iter.next();
            		double ra=mi.getAveRatingByMovie(movie.getId());
            		
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
              		syn=synopsis.substring(0, 20)+"...";
              	}else{
              		syn=synopsis;
              	}}
              %>
              <td><%if(posterURL != null && posterURL.compareTo("")!=0){ %>
              <a href="movie_detail?id=<%=movie.getId() %>"><img src="<%=posterURL %>" width="140" alt="<%=movie.getTitle() %>"/></a>
              <%} %></td>
               <td><a href="movie_detail?id=<%=movie.getId() %>"><%=movie.getTitle() %></a></td>
              <td><%=actors %></td>
              <td><%=syn+"" %></td>
              <td><%=df.format(movie.getRelease_date()) %></td>
            </tr>
            
            
            
            
            <%	
            	}}
            
            %>
          </tbody>
        </table>
        </div>
    </div>
    <div id="footer"></div>
