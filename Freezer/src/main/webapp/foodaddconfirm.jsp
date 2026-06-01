HTML
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材追加確認画面</title>
</head>
<body>
	<h2>食材追加確認</h2>
	
	<p>以下の食材を追加します。<br>
		よろしいですか？</p>
	
	<table border="1">
		<tr>
			<th>食材名</th>
			<td>${foodName}</td>
		</tr>
		<tr>
			<th>数量</th>
			<td>${number} ${unit}</td>
		</tr>
		<tr>
			<th>消費期限</th>
			<td>${date}</td>
		</tr>
	</table>
	
	<br>
	
	<form action="food-add-servlet" method="POST">
    
    <input type="hidden" name="foodName" value="${foodName}">
    <input type="hidden" name="number" value="${number}">
    <input type="hidden" name="単位" value="${unit}">
    <input type="hidden" name="data" value="${date}">
    
    <input type="button" value="キャンセル" onclick="history.back()">
    
    <input type="submit" value="追加">

</form>

</body>
</html>