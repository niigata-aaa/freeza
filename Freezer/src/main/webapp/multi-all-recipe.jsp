<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピホーム</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div class="container">
        <div class="card">
利用者のレシピ一覧
<%
List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");
%>
<table>
<tr><th>レシピID</th><th>レシピ名</th><th>レシピ写真</th><th>材料</th><th>手順</th><th>何人前</th><th>掲載日時</th><th>更新日時</th>
<%
   for(RecipeBean recipe : recipeList){
%>
<tr><td><%=recipe.getRecipeId()%></td>
   <td><%=recipe.getRecipeName()%></td>
   <td><%=recipe.getRecipeImg()%></td>
   <td><%=recipe.getRecipeIngredients()%></td>
   <td><%=recipe.getRecipeHowto()%></td>
   <td><%=recipe.getRecipeServings()%></td>
   <td><%=recipe.getPostingDatetime()%></td>
   <td><%=recipe.getUpdateDatetime()%></td>
<td>
<form action="recipe-all-detail-servlet" method="POST">
   <input type="hidden" name="RecipeId2" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="詳細表示">
</form>
</td>
</tr>
<%
}
%>
</table>
<form action="recipe-all-search2-servlet" method="post">

    レシピ名：
    <input type="text" maxlength="50" name="recipeName">

    <br><br>

    <input type="submit" value="検索">

</form>

<a href="recipe-all-regist-form.jsp">レシピ投稿</a>


<%--     <span style="float:right;">
        <a class="btn search" href="recipe-all-search.jsp">
            検索
        </a>
    </span> --%> 
</h2>
<!--<h2>レシピ検索</h2>-->
<!--   <form action="recipe-all-search2-servlet" method="POST">-->
<!--   レシピ名：<input type="text" maxlength="60" name="RecipeName"><br>-->
<!--   材料名：<input type="text" maxlength="50" name="RecipeIngredients"><br>-->
<!--   <input type="submit" value="検索" name="ACTION">-->
<!--   </form>-->
</div>
</div>
</body>
</html>

