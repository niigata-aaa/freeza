<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.FoodBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材消費確認</title>
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
FoodBean food = (FoodBean) request.getAttribute("updateFood");
%>

<h2>食材消費</h2>

<p>
    <%=food.getFoodName()%> を<br>
    <%=food.getFoodQuantity()%> （個・本・ｇ）をたべましたか？<br><br>
</p>

<div style="clear: both; padding-top: 40px; width: 100%; text-align: justify; text-justify: inter-ideograph;">

    <form action="food-update.jsp" method="get" style="display: inline-block; margin-left: 25px;">
        <button type="submit" class="btn" style="min-width: 220px;">
            キャンセル
        </button>
    </form>

    <form action="food-update-servlet" method="post" style="display: inline-block; float: right; margin-right: 25px;">
        <input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
        <input type="hidden" name="foodQuantity" value="<%=food.getFoodQuantity()%>">
        <button type="submit" class="btn" style="min-width: 220px;">
           たべた！ 
        </button>
    </form>

</div>

<div style="clear: both; height: 40px;"></div>
</div>

</div>
</body>
</html>