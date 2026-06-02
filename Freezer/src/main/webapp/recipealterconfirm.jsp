<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="employee" scope="request"
    class="model.entity.RecipeBean"/>

<jsp:setProperty name="employee" property="recipeId" param="id"/>
<jsp:setProperty name="employee" property="recipeName" param="name"/>

<jsp:setProperty name="employee" property="recipeIngredients" param="ingredients"/>
<jsp:setProperty name="employee" property="recipeHowto" param="howto"/>
<jsp:setProperty name="employee" property="recipeServings" param="servings"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更確認</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div class="container">
        <div class="card">
<%--<jsp:getProperty name='employee' property='recipeId'/> --%>

レシピ情報を以下の内容に変更します。<br>
よろしいでしょうか？<br>



<br>

レシピ名：<jsp:getProperty name="employee" property="recipeName"/><br>

材料：<jsp:getProperty name="employee" property="recipeIngredients"/><br>
手順：<jsp:getProperty name="employee" property="recipeHowto"/><br>
人数：<jsp:getProperty name="employee" property="recipeServings"/><br>
<br><br>

<form action="recipe-alter-servlet" method="POST">

<input type="hidden" name="id"
value="<jsp:getProperty name='employee' property='recipeId'/>">

<input type="hidden" name="name"
value="<jsp:getProperty name='employee' property='recipeName'/>">


<input type="hidden" name="ingredients"
value="<jsp:getProperty name='employee' property='recipeIngredients'/>">

<input type="hidden" name="howto"
value="<jsp:getProperty name='employee' property='recipeHowto'/>">

<input type="hidden" name="servings"
value="<jsp:getProperty name='employee' property='recipeServings'/>">

<input type="submit" value="  変更します  " class="btn">

</form>
<br>

<a href="recipeMypage.jsp"  class="btn">キャンセル</a>
</div>
</div>
</body>
</html>