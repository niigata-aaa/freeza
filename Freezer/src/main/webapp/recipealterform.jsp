<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.entity.RecipeBean" %>

<%
RecipeBean employee =
    (RecipeBean)request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>

<div class="container">
        <div class="card">
<form action="recipe-alter-confirm-servlet" method="POST">

    <%-- レシピID：
    <%= employee.getRecipeId() %> --%>
    <br>
<%--ユーザーIDは文字を固定するため emplyee.getRecipeId()をつかう--%>
    <input type="hidden"
           name="id"
           value="<%= employee.getRecipeId() %>">

    レシピ名：
    <input type="text"
           name="name"
           value="<%= employee.getRecipeName() %>">
    <br>

	材料
	<input type="text"
       name="ingredients"
       value="<%= employee.getRecipeIngredients()%>">

	<br>

	手順
	<textarea name="howto" cols="50" rows="10"><%= employee.getRecipeHowto()%></textarea>

	<br>

	人数
	<input type="number"
       name="servings"
       value="<%= employee.getRecipeServings()%>">
    <input type="submit" value="確認" class="btn">

</form>
</div>
</div>
</body>
</html>