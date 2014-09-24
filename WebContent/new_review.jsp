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
<h1>Add Review of Movie &lt;title&gt;</h1>
<form>
  <table width="80%" border="0">
    <tbody>
    <tr>
        <th scope="row">Title</th>
        <td><label for="textfield">Text Field:</label>
          <input type="text" name="textfield" id="textfield"></td>
      </tr>
      <tr>
        <th scope="row">Content</th>
        <td><label for="textarea">Text Area:</label>
          <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea></td>
      </tr>
      <tr>
        <th scope="row">Rating</th>
        <td><p>
          <label>
            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_0">
            1</label>
          <label>
            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_1">
            2</label>
          <label>
            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_2">
            3</label>
          <label>
            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_3">
            4</label>
          <label>
            <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_4">
            5</label>
          <br>
          </p>          <label for="textfield3"></label></td>
      </tr>
      <tr>
        <th scope="row">&nbsp;</th>
        <td><p><br>
        </p></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>
<div class="foot" id="foot">Content for  class "foot" id "foot" Goes Here</div>
</body>
</html>