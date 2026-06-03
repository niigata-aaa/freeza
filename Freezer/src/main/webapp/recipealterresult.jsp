<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<div class="container">
        <div class="card">
<%
Integer processingNumber = (Integer) request.getAttribute("processingNumber");

if (processingNumber == null) {
    processingNumber = 0;
}
%>

<% if (processingNumber > 0) { %>
    更新成功
<% } else { %>
    更新失敗
<% } %>

<jsp:useBean id="employee" scope="session" class="model.entity.RecipeBean" />
<jsp:setProperty name="employee" property="recipeName" param="name"/>

<a href="recipeMypage.jsp"  class="btn">マイページに戻る</a>
</div>
</div>
</body>
</html>