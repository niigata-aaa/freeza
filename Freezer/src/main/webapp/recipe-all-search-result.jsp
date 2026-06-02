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

<tr>
    <th>レシピ名</th>

</tr>

<%
for (RecipeBean recipe : recipeList) {
%>

<tr>

    <td><%=recipe.getRecipeId()%></td>

    <td><%=recipe.getRecipeName()%></td>
<td>
<form action="recipe-all-detail-servlet" method="POST">
   <input type="hidden" name="RecipeId2" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="詳細表示" class="btn">
</form>
</td>
</tr>

<%
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