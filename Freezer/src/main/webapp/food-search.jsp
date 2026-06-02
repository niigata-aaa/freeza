<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材検索画面</title>
</head>
<style>


</style>

<body>

<h2>食材検索画面</h2>

<form action="food-search-servlet" method="post">

    食材名：
    <input type="text" maxlength="50" name="foodName">

    <br><br>

    <input type="submit" value="検索">
    
    

</form>

<form action="food-list-servlet" method="post">

    <input type="submit" value="食材一覧へ戻る">

</form>

<hr>

<div >
    <%@ include file="food-search-result.jsp" %>
</div>

<br>



</body>

<!--	フッター-->

	<%@ include file="footer.jsp" %>
	
</html>