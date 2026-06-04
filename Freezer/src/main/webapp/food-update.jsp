<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.FoodBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材消費画面</title>
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
<div class="container">

<div class="card">

<%
List<FoodBean> foodList = (List<FoodBean>) session.getAttribute("foodList");
%>
<a href="food-list-servlet" class="btn">
    食材一覧に戻る
</a>
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

    <p>数量（個・本・g）</p>
    <input type="number" name="foodQuantity" min="1" required>

    <br><br>

    <button type="submit" class="btn">
       たべた！
    </button>

</form>

<br>


</div>

</div>
</body>

<!--	フッター-->

	<%@ include file="footer.jsp" %>
	
</html>