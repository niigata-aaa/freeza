<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ投稿確認画面</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
レシピ情報を投稿します。よろしいですか？<br>
<form action="recipe-all-register-servlet" method="POST">
<%--    <input type="hidden" name="recipeid" value="<%= request.getAttribute("recipeid") %>">  --%>
   <input type="hidden" name="recipename" value="<%= request.getAttribute("recipename") %>">
   <input type="hidden" name="recipeingredients" value="<%= request.getAttribute("recipeingredients") %>">
   <input type="hidden" name="recipehowto" value="<%= request.getAttribute("recipehowto") %>">
   <input type="hidden" name="recipeservings" value="<%= request.getAttribute("recipeservings") %>">
   <input type="hidden" name="posting" value="<%= request.getAttribute("posting") %>">
<%--    <input type="hidden" name="update" value="<%= request.getAttribute("update") %>">  --%>
   <input type="submit" value="投稿する">
</form>
<form action="recipe-all-list-servlet" method="POST">
   <input type="submit" value="戻る">
</body>
</body>
</html>





<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ投稿確認画面</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
レシピ情報を投稿します。よろしいですか？<br>
<form action="recipe-all-register-servlet" method="POST">
   <input type="submit" value="投稿する">
</form>
   <a href="search.jsp">戻る</a>
</body>
</html>

--%>