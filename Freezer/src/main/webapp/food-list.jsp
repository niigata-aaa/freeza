<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.FoodBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材情報一覧</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>
.btn {
    display: inline-block;
    padding: 6px 12px;
    margin: 2px;
    background: #4CAF50;
    color: white;
    text-decoration: none;
    border-radius: 4px;
}

.btn:hover {
    opacity: 0.8;
}

.add { background: #3498db; }
.update { background: #f39c12; }
.delete { background: #e74c3c; }
.search { background: #2ecc71; }
</style>

</head>
<body>
<div class="manaita MANA1"></div>
<div class="totte TOTE1"></div>
<div class="bg-bubble b1"></div>
<div class="bg-bubbleaA bb1"></div>
<div class="bg-bubble2 b2"></div>
<div class="bg-bubble3 b3"></div>
<%
List<FoodBean> foodList = (List<FoodBean>) request.getAttribute("foodList");
%>

<h2>
    食材一覧
<!--    <span style="float:right;">-->
<!--        <a class="btn search" href="food-search-servlet">-->
            
<!--        </a>-->
<!--    </span>-->
    
	<form action="food-search-servlet" method="post">

    食材名:
    <input required type="text" maxlength="50" name="foodName" >

    <br><br>

    <input type="submit" value="検索" class="btn">

	</form>

</h2>
<a class="btn add" href="food-add.jsp">
    追加
</a>
<a class="btn update" href="food-update.jsp"> 
    変更
</a>

<a class="btn delete" href="food-delete.jsp"> 
    削除
</a>

<table border="1">
<tr>
    <th>画像</th>
    <th>名前</th>
    <th>消費期限</th>
    <th>数量</th>
</tr>

<%
if (foodList != null && !foodList.isEmpty()) {
    for (FoodBean food : foodList){
%>
<tr>
    <td>
        <%-- 画像データが存在するかチェック --%>
        <% if (food.getBase64Image() != null && !food.getBase64Image().isEmpty()) { %>
        <img src="data:image/jpeg;base64,<%= food.getBase64Image() %>"width="100" height="100" style="object-fit: cover;">
             
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %>
    </td>

    <td>
        <%=food.getFoodName()%>
    </td>

    <td>
        <%=food.getFoodLostDay()%>
    </td>

    <td>
        <%=food.getFoodQuantity()%>
    </td>
</tr>
<%
    }
} else {

%>
    <tr>
        <td colspan="4" style="text-align: center; padding: 20px; color: #666;">
            表示する食材情報がありません。
        </td>
    </tr>
<%
}
%>
</table>




</body>

<!--	フッター-->

	<%@ include file="footer.jsp" %>
	
</html>