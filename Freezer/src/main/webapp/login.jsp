<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

ログイン画面

<form action="login-servlet" method="post">
	<p>
	ID<input type="text" name="userid">
	<br>
	パスワード<input type="password" name="password" minlength="8" required />
	</p>
	<a href="registration.jsp">会員登録画面へ</a>
	<input type="submit" value="ログイン">
	
</form>

</body>
</html>