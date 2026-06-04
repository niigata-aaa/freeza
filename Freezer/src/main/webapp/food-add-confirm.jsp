<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加内容確認</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">

<style>
/* この画面専用の確認ボタン */
.btn-confirm-local {
    background: #7A9D54 !important;
    color: white !important;
    padding: 12px 0 !important;
    border: none !important;
    border-radius: 30px !important;
    text-decoration: none !important;
    cursor: pointer !important;
    display: inline-block !important;
    min-width: 220px !important;         
    box-sizing: border-box !important;   
    text-align: center !important;       
}

.btn-confirm-local:hover {
    background: #648046 !important;
}

/* この画面専用の両端揃えエリア */
.confirm-button-area-local {
    display: flex !important;
    margin-top: 25px !important;
    justify-content: space-between !important; /* 左端と右端に引き離す */
}
</style>

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

<form action="food-add-servlet" method="POST" enctype="multipart/form-data" style="width: 100%;">
    <div class="confirm-button-area-local">
        <a href="javascript:history.back();" class="btn-confirm-local">戻る</a>
        <input type="submit" value="この内容で登録する" class="btn-confirm-local">
    </div>
</form>
</div>

</div>

</body>
</html>