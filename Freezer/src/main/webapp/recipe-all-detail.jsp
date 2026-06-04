<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ詳細情報</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div class="container">
        <div class="card">
<jsp:useBean id="recipe" scope="session" class="model.entity.RecipeBean"/>
<!--レシピID：<jsp:getProperty name="recipe" property="recipeId"/><br>-->
レシピ名：<jsp:getProperty name="recipe" property="recipeName"/><br>
レシピ画像：<br>
<% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
    <img src="data:image/jpeg;base64,<%= recipe.getBase64Image() %>" width="200px" height="200px">
<% } else { %>
    <div style="width:100px; border:1px solid #ccc; padding:10px;">No Image</div>
<% } %><br>
レシピ材料：<jsp:getProperty name="recipe" property="recipeIngredients"/><br>
レシピ作り方：<jsp:getProperty name="recipe" property="recipeHowto"/><br>
レシピ何人前：<jsp:getProperty name="recipe" property="recipeServings"/><br>
掲載日時：<jsp:getProperty name="recipe" property="postingDatetime"/><br>
更新日時：<jsp:getProperty name="recipe" property="updateDatetime"/><br>

<form action="recipe-all-list-servlet" method="POST">

   <input type="submit" value="レシピ一覧へ戻る" class="btn">

   </form>
   <br>
    <button type="button" onclick="history.back();" class="btn">
    前の画面に戻る
   	</button>
   
   </div>
   </div>
  
</body>
</html>

