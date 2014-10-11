<link rel="stylesheet" href="style.css" type="text/css" />

<div id="footer">
<ul>
  <li><a href="${pageContext.request.contextPath}/index">HOME</a>
  <!--  <li><a href="${pageContext.request.contextPath}/header.jsp">Search</a> -->  </ul>
    
  <b>Made by</b>    	 Shuwen Zhou &amp;
      Zeyang Yu
       
    For COMP9321 Assignment 2 @ <a href="http://www.unsw.edu.au">UNSW</a><br>
    <a href="http://thisisinfamous.com/infa-missed-week-infamous-46-412/">Logo resource</a>
  </ul>
<%! 
 int pageCount = 0;
 void addCount() {
   pageCount++;
 }%>
 <% 
 addCount(); %>
<p>This site has been visited <%= pageCount %> times.
<a href="http://a.tgcdn.net/images/products/zoom/ef05_zombie_brains_poster.jpg">1</a> | 
<a href="http://www.designscarborough.co.uk/wordpress/wp-content/uploads/2012/07/bc_poster11.jpg">2</a> | 
<a href="http://s3-ap-southeast-2.amazonaws.com/cdn.adelaidefringe.com.au/wp-content/uploads/2013/10/a3-poster-fin.jpg">3</a> | 
<a href="http://compostingcouncil.org/admin/wp-content/uploads/2013/02/ICAW_Poster.jpg">4</a> | 
<a href="http://www.naidoc.org.au/sites/default/files/poster-1988.jpg">5</a> | 
<a href="http://www.twist-creative.com/client/CIFF/downloads/36th/CFS_36th_Poster.jpg">6</a> | 
<a href="http://www.astronomy2009.org/static/archives/posters/large/poster_100hours.jpg">7</a>
</div>

</body>
</html>