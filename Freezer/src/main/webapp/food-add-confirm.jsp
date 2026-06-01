<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加内容確認</title>
</head>
<body>
<h2>以下の内容で食材を追加しますか？</h2>

<%
// セッションからデータを取り出す
String foodName = (String) session.getAttribute("foodName");
String number = (String) session.getAttribute("number");
String unit = (String) session.getAttribute("unit");
String date = (String) session.getAttribute("date");
String foodImage = (String) session.getAttribute("foodImage");
%>

<table border="1">
    <tr>
        <th>画像</th>
        <td>
            <img src="<%= request.getContextPath() %>/<%= foodImage %>" width="150">
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
<a href="javascript:history.back();">戻る</a>

<form action="food-add-servlet" method="POST" style="display:inline;">
    <input type="submit" value="この内容で登録する">
</form>

</body>
</html>