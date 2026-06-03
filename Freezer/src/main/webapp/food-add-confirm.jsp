<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加内容確認</title>
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
<h2>以下の内容で食材を追加しますか？</h2>

<%
// セッションからデータを取り出す
String foodName = (String) session.getAttribute("foodName");
String number = (String) session.getAttribute("number");
String unit = (String) session.getAttribute("unit");
String date = (String) session.getAttribute("date");
String foodImageBase64 = (String) session.getAttribute("foodImageBase64");
%>

<table border="1">
    <tr>
        <th>画像</th>
        <td>
            <% if (foodImageBase64 != null && !foodImageBase64.isEmpty()) { %>
                <img src="data:image/jpeg;base64,<%= foodImageBase64 %>" width="150">
            <% } else { %>
                <div>No Image</div>
            <% } %>
        </td>
    </tr>
    <tr>
        <th>食材名</th>
        <td><%= foodName %></td>
    </tr>
    <tr>
        <th>数量</th>
        <td><%= number %> <%= unit %></td>
    </tr>
    <tr>
        <th>消費期限</th>
        <td><%= date %></td>
    </tr>
</table>

<br>
<a href="javascript:history.back();" class="btn">戻る</a>

<form action="food-add-servlet" method="POST" enctype="multipart/form-data" >
    <input type="submit" value="この内容で登録する" class="btn">
</form>
</div>

</div>

</body>
</html>
