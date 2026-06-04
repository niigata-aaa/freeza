<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一つのレシピの詳細(3)</title>
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
<jsp:useBean id="employee" scope="request" class="model.entity.RecipeBean"/>
<div class="container">
<div class="card">

<div style="display: flex; justify-content: center; gap: 15px; width: 100%; margin-top: 30px;">

    <form action="recipe-alter-form-servlet" method="POST" style="margin: 0;">
        <input type="hidden" name="id" value="<%= employee.getRecipeId() %>">
        <input type="submit" value="変更" class="btn">
    </form>

    <form action="delete.jsp" method="POST" style="margin: 0;">
        <input type="hidden" name="recipe_id" value="<%= employee.getRecipeId() %>">
        <input type="submit" value="削除" class="btn">
    </form>

    <input type="button" name="cancel" value="キャンセル" onclick="history.back()" class="btn">

</div>

<h2>レシピ詳細</h2>
レシピ名：<jsp:getProperty name="employee" property="recipeName"/><br>
材料：<jsp:getProperty name="employee" property="recipeIngredients"/><br>

画像：<br>
<% if (employee.getBase64Image() != null && !employee.getBase64Image().isEmpty()) { %>
    <img src="data:image/jpeg;base64,<%= employee.getBase64Image() %>" width="300px" style="max-height:300px;">
<% } else { %>
    No Image
<% } %>
<br><br>

手順：<jsp:getProperty name="employee" property="recipeHowto"/><br>
何人前：<jsp:getProperty name="employee" property="recipeServings"/><br>
掲載日：<jsp:getProperty name="employee" property="postingDatetime"/><br>
更新日：<jsp:getProperty name="employee" property="updateDatetime"/><br>

<hr>


</div>
</div>
</body>
</html>