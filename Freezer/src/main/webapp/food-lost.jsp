<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="model.entity.FoodLostBean"%>
<!DOCTYPE html>
<html>
<body>

	<% List<FoodLostBean> foodlostList = (List<FoodLostBean>) request.getAttribute("foodlostList");%>
	
<!--	リストがないまたはリストの中身が0のとき-->
	<% if(foodlostList == null || foodlostList.isEmpty()) {%>
		<p>廃棄食材はありません。</p>
	<% } else { %>
		<% for(FoodLostBean foodlost : foodlostList) { %>
			<img src="img/<%= foodlost.getFoodLostImage() %>">
			<p><%= foodlost.getFoodLostName() %></p>
		<% } %>
	<% } %>
</body>
</html>