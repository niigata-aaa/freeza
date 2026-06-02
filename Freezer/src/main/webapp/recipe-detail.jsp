<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者レシピ詳細画面</title>
</head>
<link rel="stylesheet" href="css/common.css">
<body>
<div class="container">

<div class="card">
不要？　始まり
<jsp:useBean id="recipe" scope="session" class="model.entity.RecipeBean"/>
レシピID：<jsp:getProperty name="recipe" property="recipeId"/><br>
レシピ名：<jsp:getProperty name="recipe" property="recipeName"/><br>
<%--レシピ画像：<jsp:getProperty name="recipe" property="recipeImg"/><br>--%>
レシピ材料：<jsp:getProperty name="recipe" property="recipeIngredients"/><br>
レシピ作り方：<jsp:getProperty name="recipe" property="recipeHowto"/><br>
レシピ何人前：<jsp:getProperty name="recipe" property="recipeServings"/><br>
掲載日時：<jsp:getProperty name="recipe" property="postingDatetime"/><br>
更新日時：<jsp:getProperty name="recipe" property="updateDatetime"/><br>
<form action="recipe-delete-confirm.jsp" method="POST">
   <input type="hidden" name="RecipeId" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="削除" class="btn">
</form>
<br>
<form action="recipe-list-servlet" method="POST">
   <input type="submit" value="戻る" class="btn">
</form>
不要？終わり

<%--
<%
List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");
%>
<table>
<tr><th>レシピID</th><th>レシピ名</th><th>材料</th><th>手順</th><th>何人前</th><th>掲載日時</th><th>更新日時</th>
<%
   for(RecipeBean recipe : recipeList){
%>
<tr><td><%=recipe.getRecipeId()%></td>
   <td><%=recipe.getRecipeName()%></td>
<%-- --   <td><%=recipe.getRecipeImg()%></td>-->
   <td><%=recipe.getRecipeIngredients()%></td>
   <td><%=recipe.getRecipeHowto()%></td>
   <td><%=recipe.getRecipeServings()%></td>
   <td><%=recipe.getPostingDatetime()%></td>
   <td><%=recipe.getUpdateDatetime()%></td>
<td>
<form action="recipe-delete-form-servlet" method="POST">
   <input type="hidden" name="RecipeId" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="削除">
</form>
</td>
<td>
<form action="recipe-list-servlet" method="POST">
   <input type="submit" value="戻る">
</form>
</td>
</tr>
<%
}
%>
</table> --%>
</div>
</div>
</body>
</html>

