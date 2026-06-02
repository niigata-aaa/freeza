<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.entity.FoodBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材検索結果</title>

<style>
table, tr, td, th {
    border: black solid 1px;
}
</style>

</head>
<body>

<%
List<FoodBean> foodList =
        (List<FoodBean>) request.getAttribute("foodList");

if (foodList != null) {

    if (foodList.isEmpty()) {
%>

<p>該当する食材はありません。</p>

<%
    } else {
%>

<h2>食材検索結果</h2>

<table>

<tr>
    <th>画像</th>
    <th>食材名</th>
    <th>消費期限</th>
    <th>数量</th>
</tr>

<%
for (FoodBean food : foodList) {
%>

<tr>

    <td>
        <%-- 画像データが存在するかチェック --%>
        <% if (food.getBase64Image() != null && !food.getBase64Image().isEmpty()) { %>
        <img src="data:image/jpeg;base64,<%= food.getBase64Image() %>"/>
             
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %>
    </td>

    <td><%=food.getFoodName()%></td>

    <td><%=food.getFoodLostDay()%></td>

    <td><%=food.getFoodQuantity()%></td>

</tr>

<%
}
%>

</table>

<%
    }
}
%>

</body>
</html>