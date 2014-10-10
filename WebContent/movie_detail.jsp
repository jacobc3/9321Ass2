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
<div class="body" id="body"><h1>Movie</h1>
  <table width="80%" border="0">
    <tbody>
    <%
    	Movie m=(Movie)request.getAttribute("mdetail");
		List<Session> ses=(List<Session>)request.getAttribute("session");
		List<Review> rev=(List<Review>)request.getAttribute("reviews");
		
    %>
      <tr>
        <th width="22%" scope="row">id</th>
        <td width="78%"></td>
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
            
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </tbody>
        </table></td>
      </tr>
    </tbody>
  </table>
  <table width="80%" border="0">
    <tbody>
      <tr>
        <th scope="col">Reviews title</th>
        <th scope="col">by User</th>
        <th scope="col">On date</th>
        <th scope="col">Rating</th>
      </tr>
      
  <!--      <%
       	if(rev!=null){
            	Iterator<Review> iter3=rev.iterator();
            	while(iter3.hasNext()){
            		Review reviews=iter3.next();
            		
            %>	
      <tr>
        <td><%=reviews.getTitle() %></td>
        <td><%=reviews.getUser() %></td>
        <td><%=reviews.getPostDate() %></td>
        <td><%=reviews.getRating() %></td>
      </tr>
      
      <%	}}
            %>
            --> 
    </tbody>
  </table>
  
  <form action="review" method="post">
  <p><b>Title:</b><input type="text" name="review_title" maxlength="120"/></p>
  <p><b>nickname:</b><input type="text" name="review_nickname" maxlength="40"/></p>
  <p><textarea rows="4" cols="50" name="review_content">
	Write your review here!
	</textarea></p>
  <p><input type="submit" name="submit" title="submit"/></p>
  </form>
  
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
<div class="foot" id="foot">Content for  class "foot" id "foot" Goes Here</div>
</body>
</html>