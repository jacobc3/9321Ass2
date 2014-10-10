<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
<%@ page import="model.bean.*"%>
<%@ page import="model.handler.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css" />
    <%
    	Movie m=(Movie)request.getAttribute("mdetail");
		List<Session> ses=(List<Session>)request.getAttribute("session");
		List<Review> rev=(List<Review>)request.getAttribute("reviews");
		
    %>
<title>Movie detail of <%=m.getTitle() %></title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$(function() {
		$("#header").load("header.jsp");
		$("#footer").load("footer.jsp");
	});
</script>
</head>
<body><div id="header"></div>
<div class="body" id="body"><h1>Movie</h1>
  <table width="80%" border="0">
    <tbody>

      <tr>
        <th width="22%" scope="row">id</th>
        <td width="78%"><%=m.getId() %></td>
      </tr>
      <tr>
        <th scope="row">title</th>
        <td><%=m.getTitle() %></td>
      </tr>
      <tr>
        <th scope="row">actors</th>
        <td><%=m.getActors() %></td>
      </tr>
      <tr>
        <th scope="row">poster</th>
        <td><img src="<%=m.getPosterURL() %>" alt="<%=m.getTitle() %>"/></td>
      </tr>
      <tr>
        <th scope="row">release date</th>
        <td><%=m.getRelease_date() %></td>
      </tr>
      <tr>
        <th scope="row">synopsis</th>
        <td><%=m.getSynopsis() %></td>
      </tr>
      <tr>
        <th scope="row">genres</th>
        <% 
					Set<Genre> g=m.getGenres();
					Iterator<Genre> iter1=g.iterator();
					String s="";
					while(iter1.hasNext()){
						Genre k=iter1.next();
						s=s+k.getName()+" ";
					}	
				%>
        <td><%=s %></td>
      </tr>
      <tr>
        <th scope="row">Now showing on</th>
        <td><table width="80%" border="0">
          <tbody>
            <tr>
              <th scope="col">Cinema</th>
              <th scope="col">Date&amp;Time</th>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&lt;link to book&gt;</td>
            </tr>
            <%
            	
            	Iterator<Session> iter2=ses.iterator();
            	while(iter2.hasNext()){
            		Session sessions=iter2.next();
            %>		
            
            <tr>
              <td><a href="new_booking?id=<%=sessions.getId() %>"><%=sessions.getCinema().getName() %></a></td>
              <td><%=sessions.getShowDate() %></td>
            </tr>
           
            <%	}
            %>
          </tbody>
        </table></td>
      </tr>
    </tbody>
  </table>
  <table width="80%" border="0">
    <tbody>
      <tr>
        <th scope="col" width = "10%">Reviews title</th>
        <th scope="col">Content</th>
        <th scope="col" width = "10%">by User</th>
        <th scope="col" width = "10%">On date</th>
        <th scope="col" width = "5%">Rating</th>
      </tr>
      
        <%
       	if(rev!=null){
            	Iterator<Review> iter3=rev.iterator();
            	while(iter3.hasNext()){
            		Review reviews=iter3.next();
            		String display_name= reviews.getUser().getNickname();
            		if(display_name ==null || display_name == ""){
            			display_name=reviews.getUser().getFirstname()+" "+reviews.getUser().getLastname();
            		}
            		String rating = "N/A";
            		if(reviews.getRating() != 0){
            			rating = reviews.getRating()+"";
            		}
            		
            %>	
      <tr>
        <td><%=reviews.getTitle() %></td>
        <td><%=reviews.getContent() %></td>
        <td><%=display_name %></td>
        <td><%=reviews.getPostDate() %></td>
        <td><%=rating %></td>
      </tr>
      
      <%	}}
            %>
            
            
    </tbody>
  </table>
  
  <form action="save_review" method=POST>
  <%
	String username = (String) request.getSession()
			.getAttribute("user");
  	int user_id = new UserHandler().getUserByUsername(username).getId();
  %>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row" width=20%><label>Review Title</label></th>
        <td>
          <input type="text" name="title">
          <input type="hidden" name="movie_id" value="<%=m.getId()%>">
          <input type="hidden" name="user_id" value="<%=user_id %>"></td>
      </tr>
      <tr>
        <th scope="row"><label>Content</label></th>
        <td>
          <textarea name="content" cols="45" rows="5"></textarea></td>
      </tr>
      <tr>
        <th scope="row">Rating</th>
        <td>
          <label>
            <input type="radio" name="rating" value="1">
            1</label>
          <label>
            <input type="radio" name="rating" value="2">
            2</label>
          <label>
            <input type="radio" name="rating" value="3">
            3</label>
          <label>
            <input type="radio" name="rating" value="4" >
            4</label>
          <label>
            <input type="radio" name="rating" value="5">
            5</label>
          </td>
      </tr>
      <tr>
        <th scope="row">&nbsp;</th>
        <td><input type="submit" value="Submit"> <input type="reset" value="Reset">
        </td>
      </tr>
    </tbody>
  </table>
  </form>
  
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
<div id="footer"></div>