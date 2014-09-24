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
<h1>Add Movie</h1>
<form>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row">Title</th>
        <td><input type="text" name="textfield2" id="textfield2"></td>
      </tr>
      <tr>
        <th scope="row">Poster</th>
        <td><input type="text" name="textfield" id="textfield"></td>
      </tr>
      <tr>
        <th scope="row">Director</th>
        <td><input type="date" name="date" id="date">          
          <label for="textfield2">&lt;&lt;not available in DB</label></td>
      </tr>
      <tr>
        <th scope="row">Actors</th>
        <td><input type="date" name="date" id="date">          
          <label for="textfield2"></label></td>
      </tr>
      <tr>
        <th scope="row">Synopsis</th>
        <td><textarea name="textarea" cols="45" rows="5" maxlength="400" id="textarea"></textarea>          
          <label for="textfield"></label></td>
      </tr>
      <tr>
        <th scope="row">Genres</th>
        <td><p>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="checkbox" id="CheckboxGroup1_0">
            Checkbox</label>
          <br>
          <label>
            <input type="checkbox" name="CheckboxGroup1" value="checkbox" id="CheckboxGroup1_1">
            Checkbox</label>
          <br>
        </p>          <label for="textfield3"></label></td>
      </tr>
      <tr>
        <th scope="row"><input type="submit" name="submit" id="submit" value="Submit"></th>
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