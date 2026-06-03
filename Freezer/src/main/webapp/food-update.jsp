<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.FoodBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材更新画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<div class="container">

<div class="card">

<%
List<FoodBean> foodList = (List<FoodBean>) session.getAttribute("foodList");
%>

<h2>使用した食材</h2>

<form action="food-update-confirm-servlet" method="post">

<p>食材名</p>
    <select name="foodId" required>
        <option value="">選択してください</option>

        <%
        if (foodList != null && !foodList.isEmpty()) {
            for (FoodBean food : foodList){
        %>
            <option value="<%=food.getFoodId()%>">
                <%=food.getFoodName()%> （期限：<%=food.getFoodLostDay()%>）
            </option>
        <%
            }
        } else {
        %>
            <option value="" disabled>選択できる食材がありません</option>
        <%
        }
        %>

    </select>

    <br><br>

    <p>数量（個・g）</p>
    <input type="number" name="foodQuantity" min="1" required>

    <br><br>

    <button type="submit">
        変更
    </button>

</form>

<br>

<a href="food-list-servlet">
    食材一覧に戻る
</a>
</div>

</div>
</body>

<!--	フッター-->

	<%@ include file="footer.jsp" %>
	
</html>