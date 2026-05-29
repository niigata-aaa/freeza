<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="model.entity.FoodBean"%>
<!DOCTYPE html>
<html>
<body>
	
	<% List<FoodBean> foodlostdayList = (List<FoodBean>) request.getAttribute("foodlostdayList");%>
	
<!--	リストがないまたはリストの中身が0のとき-->
	<% if(foodlostdayList == null || foodlostdayList.isEmpty()) {%>
		<p>消費期限が近い食材ははありません。</p>
	<% } else { %>
		<% for(FoodBean foodlostday : foodlostdayList) { %>
			<img src="img/<%= foodlostday.getFoodImage() %>">
			<p><%= foodlostday.getFoodName() %></p>
		<% } %>
	<% } %>
</body>
</html>