<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ-詳細</title>
</head>
<body>
	<jsp:useBean id="recipe" scope="session"
		class="model.entity.RecipeBean" />

	料理名：<jsp:getProperty name="employee" property="code" /><br> 画像：<jsp:getProperty
		name="employee" property="name" /><br> 材料：<jsp:getProperty
		name="employee" property="age" /><br> 手順：<jsp:getProperty
		name="employee" property="section" /><br> 何人前：<jsp:getProperty
		name="employee" property="section" /><br> 掲載日時：<jsp:getProperty
		name="employee" property="section" /><br> 更新日時：<jsp:getProperty
		name="employee" property="section" /><br>

	<form action="employee-register-form-servlet" method="POST">
		<input type="submit" value="削除する">
	</form>

	<form action="employee-list-servlet" method="POST">
		<input type="submit" value="戻る">
	</form>
</body>
</html>