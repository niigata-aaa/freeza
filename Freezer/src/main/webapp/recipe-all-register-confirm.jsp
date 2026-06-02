<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ投稿確認画面</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
レシピ情報を投稿します。よろしいですか？<br>
<form action="recipe-all-register-servlet" method="POST">
   <input type="submit" value="投稿する">
</form>
   <a href="search.jsp">戻る</a>
</body>
</html>

