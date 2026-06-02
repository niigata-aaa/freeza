<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一つのレシピの詳細(3)</title>
</head>
<body>

<jsp:useBean id="employee" scope="request"
    class="model.entity.RecipeBean"/>

<%--レシピID：<jsp:getProperty name="employee" property="recipeId"/><br> --%>
レシピ名：<jsp:getProperty name="employee" property="recipeName"/><br>
材料：
<jsp:getProperty name="employee"
property="recipeIngredients"/>
<br>
画像
<jsp:getProperty name="employee"
property="recipeImg"/>
<br>

手順：
<jsp:getProperty name="employee"
property="recipeHowto"/>
<br>

何人前：
<jsp:getProperty name="employee"
property="recipeServings"/>
<br>

掲載日：
<jsp:getProperty name="employee"
property="postingDatetime"/>
<br>

更新日：
<jsp:getProperty name="employee"
property="updateDatetime"/>
<br>
<form action="recipe-alter-form-servlet" method="POST">
<%--IDは表示せず隠しフィールドでサーブレットに受け渡す --%>
    <input type="hidden" name="id"
        value="<%= employee.getRecipeId() %>">
    <input type="submit" value="変更">
</form>

<form action="delete.jsp" method="POST">
<input type="hidden"
		name="recipe_id"
		value="<%= employee.getRecipeId() %>">
	<input type="submit" value="削除">
		</form>
<a href="recipeMypage.jsp">マイページ</a>

</body>
</html>