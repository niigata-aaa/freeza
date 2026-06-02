<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員マイページ(1)</title>
</head>
<body>
<%--会員 ページ--%>
<h2>ユーザーID<%--なんちゃら.getUserName() --%></h2>
<p>登録食材数<%--なんちゃら.getCountFood() --%></p>
<p>投稿レシピ<%--なんちゃら.getCountRecipe() --%></p>
<form action="recipe-list-servletX" method="post">
<input type="submit" value="投稿したレシピを見る">
</form>
<a href="logout.jsp">ログアウトはこちら</a>
</body>
</html>