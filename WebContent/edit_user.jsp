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
<h1>Edit User</h1>
<form>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row">Username</th>
        <td><label id="username" value="uu">Username</label>&nbsp;
          <input type="hidden" name="id" id="hiddenField" value="hiddenID"></td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td><input type="text" name="textfield2" id="textfield2"></td>
      </tr>
      
      <tr>
        <th scope="row">Password</th>
        <td><input type="text" name="textfield3" id="textfield3">          <label for="textfield2"></label></td>
      </tr>
      <tr>
        <th scope="row">First name</th>
        <td><label for="textfield">
          <input type="text" name="textfield4" id="textfield4">
        </label></td>
      </tr>
      <tr>
        <th scope="row">Last Name</th>
        <td><label for="textfield3">
          <input type="text" name="textfield5" id="textfield5">
        </label></td>
      </tr>
      
      <tr>
        <th scope="row"><input type="submit"  value="Submit"></th>
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