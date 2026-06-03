<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者レシピ一覧</title>
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
<%
List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");
%>
<table>
<tr>
<!--<th>レシピID</th>-->
<th>レシピ名</th><th>レシピ写真</th><th>材料</th><th>手順</th><th>何人前</th><th>掲載日時</th><th>更新日時</th>
<%
   for(RecipeBean recipe : recipeList){
%>
<tr>
<!--<td><%=recipe.getRecipeId()%></td>-->
   <td><%=recipe.getRecipeName()%></td>
<%-- 画像データが存在するかチェック --%>
        <td><% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
        <img src="data:image/png;base64,<%= recipe.getBase64Image() %>" width="100px" />
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %></td>
   <td><%=recipe.getRecipeIngredients()%></td>
   <td><%=recipe.getRecipeHowto()%></td>
   <td><%=recipe.getRecipeServings()%></td>
   <td><%=recipe.getPostingDatetime()%></td>
   <td><%=recipe.getUpdateDatetime()%></td>
<td>
<form action="recipe-detail-servlet" method="POST">
   <input type="hidden" name="RecipeId2" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="詳細表示">
</form>
</td>
</tr>
<%
}
%>
</table>

<form action="recipe-search-servlet" method="post">

    レシピ名または食材名:
    <input type="text" maxlength="50" name="recipeName">

    <br><br>

    <input type="submit" value="検索">

</form>

</body>
</html>

