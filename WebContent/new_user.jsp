<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="head" id="head">Content for  class "head" id "head" Goes Here</div>
<div class="body" id="body">
<h1>Add User</h1>
<form action="new_user" method="post">
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row">Username</th>
        <td>
          <input type="text" name="username" id="textfield"></td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td>
          <input type="text" name="email" id="textfield2"></td>
      </tr>
      
      <tr>
        <th scope="row">Password</th>
        <td>
          <input type="text" name="password" id="textfield3">          <label for="textfield2"></label></td>
      </tr>
      <tr>
        <th scope="row"><input type="submit" value="Submit"></th>
        <td><p>
          <input type="reset" name="reset" id="reset" value="Reset">
          <br>
          </p></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<div class="foot" id="foot">Content for  class "foot" id "foot" Goes Here</div>
</body>
</html>