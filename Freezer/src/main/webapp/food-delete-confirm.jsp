<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材削除確認</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>
    body {
        font-family: sans-serif;
        margin: 40px;
    }
    .container {
        border: 1px solid #333;
        width: 450px;
        padding: 20px;
        box-sizing: border-box;
        background:#FFFAFA;
    }
    h2 {
        margin-top: 0;
        border-bottom: 1px solid #333;
        padding-bottom: 10px;
    }
    
    .message-box {
        border: 1px solid #333;
        margin: 30px 0;
        padding: 30px 20px;
        text-align: center;
        font-size: 18px;
        line-height: 1.6;
    }
    .highlight {
        font-weight: bold;
        color: #d9534f;
    }
    .button-group {
        display: flex;
        justify-content: space-between;
        padding: 0 20px;
    }
    input[type="button"], input[type="submit"] {
        padding: 8px 30px;
        font-size: 16px;
        cursor: pointer;

        border: 1px solid #333;
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
<h2>削除確認</h2>

    <form action="food-delete-servlet" method="post">
        <input type="hidden" name="foodId" value="<%= request.getAttribute("foodId") != null ? request.getAttribute("foodId") : "" %>">

        <div class="message-box">
            <%
                String foodName = (String) request.getAttribute("foodName");
                String foodLostDay = (String) request.getAttribute("foodLostDay");
                
                if (foodName != null && !foodName.isEmpty()) {
            %>
                <span class="highlight"><%= foodName %> <%= foodLostDay != null ? foodLostDay : "" %></span> を削除します。<br>
                よろしいですか？
            <%
                } else {
            %>
                選択された食材を削除します。<br>よろしいですか？
            <%
                }
            %>
        </div>

        <div class="button-group">
            <input type="button" name="cancel" value="キャンセル" onclick="history.back()" class="btn">
            <input type="submit" value="削除" class="btn">
        </div>
        
    </form>
</div>

</body>
</html>