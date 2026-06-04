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
<form action="recipe-alter-confirm-servlet" method="POST">

    <%-- レシピID：
    <%= employee.getRecipeId() %> --%>
    <br>
<%--ユーザーIDは文字を固定するため emplyee.getRecipeId()をつかう--%>
    <input type="hidden"
           name="id"
           value="<%= employee.getRecipeId() %>">

    レシピ名：
    <input required type="text"
           name="name"
           value="<%= employee.getRecipeName() %>">
    <br>

	材料
	<input required type="text"
       name="ingredients"
       value="<%= employee.getRecipeIngredients()%>">

	<br>

	手順
	<textarea required name="howto" cols="50" rows="10"><%= employee.getRecipeHowto()%></textarea>

	<br>

	人数
	<input required type="number"
       name="servings"
       value="<%= employee.getRecipeServings()%>">
    <input type="submit" value="確認" class="btn">
    <br>
    <button type="button" class="btn btn-cancel" onclick="history.back();">
     キャンセル
    </button>
    

</form>
</div>
</div>
</body>
</html>