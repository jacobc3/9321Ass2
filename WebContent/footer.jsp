<link rel="stylesheet" href="style.css" type="text/css" />

<div id="footer">
<ul>
  <li><a href="http://localhost/9321Ass2/indx">HOME</a>
  <li>Search   </ul>
    
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
<p>This site has been visited <%= pageCount %> times.</div>

</body>
</html>