<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者削除確認画面</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div class="container">

<div class="card">
	<%
request.setCharacterEncoding("UTF-8");
%>
	レシピ情報を削除します。よろしいですか？
	<br>
	<form action="recipe-delete-servlet" method="POST">
		<input type="hidden" name="RecipeId"
			value="<%=request.getParameter("RecipeId")%>"> <input
			type="submit" value="削除する" class="btn">
	</form>
	<a href="search.jsp" class="btn">戻る</a>
	</div>
	</div>
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



