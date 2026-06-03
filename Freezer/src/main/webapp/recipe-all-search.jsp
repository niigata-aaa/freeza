<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ検索画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<div class="container">
        <div class="card">
<h2>レシピ検索画面</h2>

<form action="recipe-all-search2-servlet" method="post">

    レシピ名：
    <input type="text" maxlength="50" name="recipeName">

    <br><br>

    <input type="submit" value="検索">

</form>

<hr>

<div>
    <%@ include file="recipe-all-search-result.jsp" %>
</div>

<br>

<form action="recipe-all-list-servlet" method="post">

    <input type="submit" value="食材一覧へ戻る">

</form>
</div>
</div>

</body>
</html>

