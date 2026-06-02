<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ詳細情報</title>
</head>
<body>
<jsp:useBean id="recipe" scope="session" class="model.entity.RecipeBean"/>
レシピID：<jsp:getProperty name="recipe" property="recipeId"/><br>
レシピ名：<jsp:getProperty name="recipe" property="recipeName"/><br>
レシピ画像：<jsp:getProperty name="recipe" property="recipeImg"/><br>
レシピ材料：<jsp:getProperty name="recipe" property="recipeIngredients"/><br>
レシピ作り方：<jsp:getProperty name="recipe" property="recipeHowto"/><br>
レシピ何人前：<jsp:getProperty name="recipe" property="recipeServings"/><br>
掲載日時：<jsp:getProperty name="recipe" property="postingDatetime"/><br>
更新日時：<jsp:getProperty name="recipe" property="updateDatetime"/><br>
<form action="recipe-all-list-servlet" method="POST">
   <input type="submit" value="一覧表示">
</body>
</html>

