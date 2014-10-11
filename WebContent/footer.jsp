<link rel="stylesheet" href="style.css" type="text/css" />

<footer id="footer">
  <p class="fl_left"><b>Made by</b>Shuwen Zhou &amp; Zeyang Yu For COMP9321 Assignment 2 @ <a href="http://www.unsw.edu.au">UNSW</a></p> <p class="fl_right">
    <a href="http://thisisinfamous.com/infa-missed-week-infamous-46-412/">Logo resource</a>
  </p>
<%! 
 int pageCount = 0;
 void addCount() {
   pageCount++;
 }%>
 <% 
 addCount(); %>
<div class="clear"> Poster Resource
<a href="http://a.tgcdn.net/images/products/zoom/ef05_zombie_brains_poster.jpg">1</a> | 
<a href="http://www.designscarborough.co.uk/wordpress/wp-content/uploads/2012/07/bc_poster11.jpg">2</a> | 
<a href="http://s3-ap-southeast-2.amazonaws.com/cdn.adelaidefringe.com.au/wp-content/uploads/2013/10/a3-poster-fin.jpg">3</a> | 
<a href="http://compostingcouncil.org/admin/wp-content/uploads/2013/02/ICAW_Poster.jpg">4</a> | 
<a href="http://www.naidoc.org.au/sites/default/files/poster-1988.jpg">5</a> | 
<a href="http://www.twist-creative.com/client/CIFF/downloads/36th/CFS_36th_Poster.jpg">6</a> | 
<a href="http://www.astronomy2009.org/static/archives/posters/large/poster_100hours.jpg">7</a>
<br>This site has been visited <%= pageCount %> times.</br></div>
</footer>
</body>
</html>