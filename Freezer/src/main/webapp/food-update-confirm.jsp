<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.FoodBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材消費確認</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">

<style>
	.card {
    background-color: #ffffff; /* 白い枠 */
    border-radius: 15px;       /* 角丸 */
    padding: 30px;             /* 内側の余白 */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 軽い影 */
}

/* ボタンを横並びにするための入れ物（コンテナ） */
.btn-container {
    display: flex;                 /* 横並びにする */
    justify-content: space-between; /* キャンセルを左端、たべた！を右端に */
    align-items: center;            /* ボタンの上下の真ん中を揃える */
    width: 100%;                    /* 枠の横幅いっぱいに広げる */
    margin-top: 30px;               /* 上の文字との間の隙間 */
}


</style>
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

<div class="btn-container">
<!-- 左下：キャンセル -->
<!--<div style="position: absolute; bottom: 20px; left: 20px;">-->
    <form action="food-update.jsp" method="get">
        <button type="submit" class="btn">
            キャンセル
        </button>
    </form>
<!--</div>-->

<!-- 右下：変更確定 -->
<!--<div style="position: absolute; bottom: 20px; right: 20px;">-->
    <form action="food-update-servlet" method="post">

        <input type="hidden" name="foodId" value="<%=food.getFoodId()%>">
        <input type="hidden" name="foodQuantity" value="<%=food.getFoodQuantity()%>">

        <button type="submit" class="btn">
           たべた！ 
        </button>

    </form>
<!--</div>-->
</div>
</div>
</div>
</body>
</html>