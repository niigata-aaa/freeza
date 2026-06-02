<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人レシピ一覧(2)</title>
<link rel="stylesheet" href="localrecipeTable.css">
</head>
<body>
	<%
	List<RecipeBean> RecipeParsonalList =  (List<RecipeBean>) request.getAttribute("RecipeParsonalList");
	%>
	<div id="table_title">レシピリスト</div>
	<div class="example">
	<table>
		<tr>
    <%--<th>ID</th> --%>
<th>レシピ名</th></div>
<th>画像</th></div>
<th>材料</th></div>

<th>人数</th></div>
<th>更新日</th></div>
<th>操作</th></div>
</tr>
<% for (RecipeBean employee : RecipeParsonalList){ %>

<tr>
<%--<td><%= employee.getRecipeId() %></td> 　レシピIDは表示しない--%>
<td><%= employee.getRecipeName() %></td>
<td>
        <img src="./<%= employee.getRecipeImg() %>" width="100">
    </td>
<td><%= employee.getRecipeIngredients() %></td>
<td><%= employee.getRecipeServings() %></td>
<td><%= employee.getUpdateDatetime() %></td>

<td>
<form action="recipe-datail-servlet" method="POST">
<input type="hidden" name="code"
       value="<%= employee.getRecipeId() %>">
<input type="submit" value="編集">
</form>
</td>

</tr>

<% } %>
		
	</table>
</div>
</form>
<a href="recipeMypage.jsp"  class="btn">キャンセル</a>

</body>
</html>
