<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材検索画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<div class="manaita MANA1"></div>
<div class="totte TOTE1"></div>
<div class="bg-bubble b1"></div>
<div class="bg-bubbleaA bb1"></div>
<div class="bg-bubble2 b2"></div>
<div class="bg-bubble3 b3"></div>
<div class="container">

<div class="card">

<h2>食材検索画面</h2>

<form action="food-search-servlet" method="post">

    食材名：
    <input required type="text" maxlength="50" name="foodName">

    <br><br>

    <input type="submit" value="検索" class="btn">

</form>

<hr>

<div>
    <%@ include file="food-search-result.jsp" %>
</div>

<br>

<form action="food-list-servlet" method="post">

    <input type="submit" value="食材一覧へ戻る" class="btn">

</form>

</div>

</div>
</body>
</html>