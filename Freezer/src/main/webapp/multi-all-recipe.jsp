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
<tr>
<!--<th>レシピID</th>-->
<th>レシピ名</th><th>レシピ写真</th><th>材料</th><th>手順</th><th>何人前</th><th>掲載日時</th><th>更新日時</th>
<%
if (recipeList != null && !recipeList.isEmpty()) {
   for(RecipeBean recipe : recipeList){
%>
<tr>
<!--<td><%=recipe.getRecipeId()%></td>-->
   <td><%=recipe.getRecipeName()%></td>
   
   <td><%-- 画像データが存在するかチェック --%>
        <% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
        <img src="data:image/png;base64,<%= recipe.getBase64Image() %>"width="100px" />
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %></td>
    	
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
} else { // listがnullか空だった場合
%>
 <tr>
        <td colspan="8" style="text-align: center; padding: 20px;">
            表示するレシピ情報がありません。
        </td>
    </tr>
<%
} // ifの閉じ
%>
</table>
<form action="recipe-all-search2-servlet" method="post">

    レシピ名または食材名:
    <input type="text" maxlength="50" name="recipeName">

    <br><br>

    <input type="submit" value="検索">

</form>

<a href="recipe-all-regist-form.jsp">レシピ投稿</a>

</div>
</div>
</body>
</html>

