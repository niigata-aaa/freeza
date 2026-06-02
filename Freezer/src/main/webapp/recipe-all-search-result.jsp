<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.entity.RecipeBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ検索結果</title>

<style>
table, tr, td, th {
    border: black solid 1px;
}
</style>

</head>
<body>

<%
List<RecipeBean> recipeList =
        (List<RecipeBean>) request.getAttribute("recipeList");

if (foodList != null) {

    if (foodList.isEmpty()) {
%>

<p>該当するレシピはありません。</p>

<%
    } else {
%>

<h2>レシピ検索結果</h2>

<table>

<tr>
    <th>画像</th>
    <th>レシピ名</th>

</tr>

<%
for (recipeBean recipe : List) {
%>

<tr>

    <td>
        <img src="<%=recipe.getRecipeImage()%>" width="100">
    </td>

    <td><%=food.getRecipeName()%></td>



</tr>

<%
}
%>

</table>

<%
    }
}
%>

</body>
</html>