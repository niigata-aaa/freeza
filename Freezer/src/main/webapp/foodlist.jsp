<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.FoodBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材情報一覧</title>
</head>
<body>
<%
		List<FoodBean> foodList
			= (List<FoodBean>) request.getAttribute("foodList");
	%>
	<table>
	<tr>
	<th>食材名</th>
	<th>消費期限</th>
	</tr>
	<%
	  for (FoodBean food : foodList){
	%>
	<tr>
	<td><%=food.getFoodName()%></td>
	</tr>
	<%
		}
	%>
	</table>	
		
</body>
</html>