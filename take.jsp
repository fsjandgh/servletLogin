<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    </meta>
  </head>
  <body>
    <h1>Do you come in?</h1>
    <form action="Welcome" method="post">
    <input type="text" name="username" placeholder="try to input something...">
      <center>
        <input type="submit">
      </center>
    </form>
    <form action="test_login" method="post">
    <input type="text" name="account">
    <input type="password" name="password">
      <center>
        <input type="submit">
      </center>
    </form>
  </body>
</html>
