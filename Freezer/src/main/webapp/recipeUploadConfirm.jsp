<%@ page contentType="text/html;charset=UTF-8" %>
<%
String name = (String) session.getAttribute("Recipename");
String ingredients = (String) session.getAttribute("Recipeingredients");
String howto = (String) session.getAttribute("RecipeHowto");
String servings = (String) session.getAttribute("Recipeservings");
byte[] imgBytes = (byte[]) session.getAttribute("recipeImageBytes");

String base64 = "";
if (imgBytes != null) {
    base64 = java.util.Base64.getEncoder().encodeToString(imgBytes);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet" href="css/common.css">
</head>

<body>

<h2>この内容で登録しますか？</h2>

<table border="1">

<tr>
<td>画像</td>
<td>
<% if (base64 != null && !base64.isEmpty()) { %>
    <img src="data:image/jpeg;base64,<%= base64 %>" width="150">
<% } else { %>
    No Image
<% } %>
</td>
</tr>

<tr><td>名前</td><td><%= name %></td></tr>
<tr><td>材料</td><td><%= ingredients %></td></tr>
<tr><td>作り方</td><td><%= howto %></td></tr>
<tr><td>人数</td><td><%= servings %></td></tr>

</table>

<br>

<!-- ★POSTで確定 -->
<form action="recipe-upload-confirm-servlet" method="post">
    <input type="submit" value="登録する">
</form>

<br>

<a href="javascript:history.back()">戻る</a>

</body>
</html>