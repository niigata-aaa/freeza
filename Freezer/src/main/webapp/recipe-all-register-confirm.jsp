<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ投稿確認画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>

<div class="container">
<div class="card">

<h2>以下の内容でレシピ情報を投稿します。よろしいですか？</h2>

<%
// セッションからデータを取り出す（食材の確認画面と同じ仕組み）
String recipename = (String) session.getAttribute("recipename");
String recipeingredients = (String) session.getAttribute("recipeingredients");
String recipehowto = (String) session.getAttribute("recipehowto");
String recipeservings = (String) session.getAttribute("recipeservings");
String recipeBase64 = (String) session.getAttribute("recipeBase64");
%>

<table border="1">
    <tr>
        <th>レシピ写真</th>
        <td>
            <% if (recipeBase64 != null && !recipeBase64.isEmpty()) { %>
                <img src="data:image/jpeg;base64,<%= recipeBase64 %>" width="150">
            <% } else { %>
                <div>No Image</div>
            <% } %>
        </td>
    </tr>
    <tr>
        <th>レシピ名</th>
        <td><%= recipename %></td>
    </tr>
    <tr>
        <th>材料</th>
        <td><%= recipeingredients %></td>
    </tr>
    <tr>
        <th>作り方</th>
        <td><%= recipehowto %></td>
    </tr>
    <tr>
        <th>何人前</th>
        <td><%= recipeservings %> 人前</td>
    </tr>
</table>

<br>

<%-- 登録サーブレットを呼び出すボタン（データはセッションにあるので、hiddenは不要です） --%>
<form action="recipe-all-register-servlet" method="POST">
   <input type="submit" value="投稿する" class="btn">
</form>

<br>
<%-- 前の入力画面に戻るボタン --%>
<a href="javascript:history.back();" class="btn">戻る</a>

</div>
</div>

</body>
</html>
