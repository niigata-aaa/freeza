<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List" import="model.entity.FoodLostBean" import="model.entity.FoodBean" import="model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

<div >
</div>
<!--	消費期限が近い食材-->
	<% List<FoodBean> foodlostdayList = (List<FoodBean>) request.getAttribute("foodlostdayList");%>

	<!--	リストがないまたはリストの中身が0のとき-->
	<% if(foodlostdayList == null || foodlostdayList.isEmpty()) {%>
		<p>消費期限が近い食材ははありません。</p>
	<% } else { %>
		<% for(FoodBean foodlostday : foodlostdayList) { %>
			<%= foodlostday.getFoodImage() %>
			<p><%= foodlostday.getFoodName() %></p>
		<% } %>
	<% } %>
	
	<!--	レシピ提案-->
	<% List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");%>
	
<!--    	リストがないまたはリストの中身が0のとき-->
	<% if(recipeList == null || recipeList.isEmpty()) {%>
		<p>該当レシピはありません。</p>
	<% } else { %>
		<% for(RecipeBean recipe: recipeList) { %>
			<img src="./<%= recipe.getRecipeImg() %>">
			<p><%= recipe.getRecipeName() %></p>
		<% } %>
	<% } %>
	
	
	
<!--	廃棄食材-->
	<% List<FoodLostBean> foodlostList = (List<FoodLostBean>) request.getAttribute("foodlostList");%>
	<!--	リストがないまたはリストの中身が0のとき-->
	<% if(foodlostList == null || foodlostList.isEmpty()) {%>
		<p>廃棄食材はありません。</p>
	<% } else { %>
		<% for(FoodLostBean foodlost : foodlostList) { %>
			<img src="./<%= foodlost.getFoodLostImage() %>">
			<p><%= foodlost.getFoodLostName() %></p>
		<% } %>
	<% } %>

	
	
</body>
<!--	フッター-->

	<%@ include file="footer.jsp" %>

</html>