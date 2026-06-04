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
<div class="manaita MANA1"></div>
<div class="totte TOTE1"></div>
<div class="bg-bubble b1"></div>
<div class="bg-bubbleaA bb1"></div>
<div class="bg-bubble2 b2"></div>
<div class="bg-bubble3 b3"></div>
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

</table>

<div style="clear: both; padding-top: 40px; width: 100%;">

    <a href="javascript:history.back();" class="btn" style="display: inline-block; min-width: 220px; color: white; text-decoration: none; font-weight: bold; text-align: center; line-height: normal;">戻る</a>

    <form action="recipe-all-register-servlet" method="POST" style="display: inline-block; float: right;">
       <input type="submit" value="投稿する" class="btn" style="min-width: 220px;">
    </form>

</div>

<div style="clear: both; height: 40px;"></div>
</div>
</div>

</body>
</html>
