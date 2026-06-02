<%@ page contentType="text/html;charset=UTF-8" %>

<%
String recipeId = request.getParameter("recipe_id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<div class="container">
        <div class="card">
<h2>削除確認</h2>

<p>ID：<%= recipeId %> を本当に削除しますか？</p>

<form action="delete-servlet" method="post">

    <input type="hidden" name="recipe_id" value="<%= recipeId %>">
    <input type="submit" value="削除する">
</form>

<form action="recipeMypage.jsp" method="get">
    <input type="submit" value="キャンセル">
</form>
</div>
</div>
</body>
</html>