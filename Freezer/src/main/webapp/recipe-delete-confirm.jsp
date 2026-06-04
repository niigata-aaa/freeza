<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者削除確認画面</title>
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
	<%
request.setCharacterEncoding("UTF-8");
%>
	レシピ情報を削除します。よろしいですか？
	<br>
	<form action="recipe-delete-servlet" method="POST">
		<input type="hidden" name="RecipeId"
			value="<%=request.getParameter("RecipeId")%>"> <input
			type="submit" value="削除する">
	</form>
	<a href="">戻る</a>
</body>
</html>













<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%
request.setCharacterEncoding("UTF-8");
String RecipeId = (String) session.getAttribute("RecipeId");%>n
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者削除確認画面</title>
</head>
<body>
<%--<%
request.setCharacterEncoding("UTF-8");

レシピ情報を削除します。よろしいですか？<br>
<form action="recipe-delete-servlet" method="POST">
   <input type="hidden" name="RecipeId" value"<%= RecipeId %>">
   <input type="submit" value="削除する">
</form>
   <a href="search.jsp">戻る</a>
</body>
</html> --%>



