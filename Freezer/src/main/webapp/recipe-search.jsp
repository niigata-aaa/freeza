<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ検索画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>html, body{
    height: 100%;
    margin: 0;
    overflow: hidden;        /* 画面全体はスクロールさせない */
}</style>
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
<h2>管理者レシピ検索画面</h2>
<form action="recipe-search-servlet" method="post" style="white-space: nowrap;">レシピ名または食材名: <input required type="text" maxlength="50" name="recipeName" style="width: 240px;"> <input type="submit" value="検索" class="btn"></form>
<form action="recipe-list-servlet" method="post">
   <input type="submit" value="レシピ一覧へ戻る" class="btn">
</form>
<hr>
<div>
   <%@ include file="recipe-search-result.jsp" %>
</div>
<br>
</div>
</div>
</body>
</html>

