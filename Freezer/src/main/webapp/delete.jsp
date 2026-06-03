<%@ page contentType="text/html;charset=UTF-8" %>
<%--Encodingで日本語対応そしてgetParameterでrecipe_idを受け取る。 --%>
<%
request.setCharacterEncoding("UTF-8");
String recipeId = request.getParameter("recipe_id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認(4)</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<div class="container">
        <div class="card">
<h2>削除確認</h2>

<%-- レシピID：<%= recipeId %><br>--%>

本当に削除しますか？<br><br>

<form action="delete-servlet" method="post">
    <input type="hidden"
           name="recipe_id"
           value="<%= recipeId %>">

    <input type="submit" value="削除する">
</form>

<a href="recipeMypage.jsp">キャンセル</a>
</div>
</div>
</body>
</html>