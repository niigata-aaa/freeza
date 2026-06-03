<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.entity.RecipeBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ検索結果</title>
<link rel="stylesheet" href="css/common.css">

<style>
table, tr, td, th {
    border: black solid 1px;
}
</style>

</head>
<body>
<div class="container">
        <div class="card">
<%
List<RecipeBean> recipeList =
        (List<RecipeBean>) request.getAttribute("recipeList");

if (recipeList != null) {

    if (recipeList.isEmpty()) {
%>

<p>該当するレシピはありません。</p>

<%
    } else {
%>

<h2>レシピ検索結果</h2>

<table>

<th>レシピ名</th><th>レシピ写真</th><th>材料</th><th>手順</th><th>何人前</th>
<%
if (recipeList != null && !recipeList.isEmpty()) {
   for(RecipeBean recipe : recipeList){
%>
<tr>
<!--<td><%=recipe.getRecipeId()%></td>-->
   <td><%=recipe.getRecipeName()%></td>
   
   <td><%-- 画像データが存在するかチェック --%>
        <% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
        <img src="data:image/png;base64,<%= recipe.getBase64Image() %>"width="100px" height="100px" />
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %></td>
    	
   <td><%=recipe.getRecipeIngredients()%></td>
   <td><%=recipe.getRecipeHowto()%></td>
   <td><%=recipe.getRecipeServings()%></td>
   
<td>
<form action="recipe-all-detail-servlet" method="POST">
   <input type="hidden" name="RecipeId2" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="詳細表示" class="btn">
</form>
</td>
</tr>

<%
}
}
%>

</table>

<%
    }
}
%>
</div>
</div>
</body>
</html>