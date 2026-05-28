<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ情報一覧</title>
</head>
<body>
	<%
         List<RecipeBean> recipeList
             = (Recipe<RecipeBean>) request.getAttribute("recipeList");
    %>
	<table>
		<tr>
			<th>料理名</th>
			<th>画像</th>
			<th>材料</th>
			<th></th>
		</tr>
		<%
			for (RecipeBean recipe : recipeList) {
		%>
		<tr>
			<td><%=recipe.getCode()%></td>
			<td><%=recipe.getName()%></td>
			<td>
				<form action="recipe-detail-servlet" method="POST">
					<input type="hidden" name="recipeid"
						value="<%=recipe.getRecipeid()%>"> <input type="submit"
						value="詳細表示">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>