<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.FoodBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材情報報一覧</title>

<style>
body{
    background-color: #FFF8F0;
    padding-bottom: 100px;
    margin: 0;
}

.btn {
    display: inline-block;
    width: 120px;
    padding: 12px 24px;
    margin: 5px;
    text-align: center;
    background: #4CAF50;
    color: white;
    text-decoration: none;
    font-size: 18px;
    border-radius: 8px;
}

.btn:hover {
    opacity: 0.8;
}

.add { background: #3498db; }
.update { background: #f39c12; }
.delete { background: #e74c3c; }

.search {
    background: #F5DEB3;
    color: black;
}

.fixed-menu{
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;

    display: flex;
    justify-content: space-evenly;

    background: white;
    border-top: 1px solid #ccc;
    padding: 15px 0;
}

.title-area{
    width: 80%;
    margin: 20px auto;
    position: relative;
}

.title-area h2{
    display: inline-block;

    margin: 0;

    background: #FDF5E6;
    padding: 10px 30px;

    border-radius: 10px;

    position: relative;
    left: 50%;
    transform: translateX(-50%);

    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

.search-btn{
    position: absolute;
    right: 0;
    top: 50%;
    transform: translateY(-50%);
}

.table-area{
    width: 85%;
    margin: 30px auto;

    background: #FDF5E6;
    padding: 20px;

    border-radius: 15px;

    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

table{
    width: 100%;
    margin: 0;
    border-collapse: collapse;
    background: #FFFDF8;
    border-radius: 10px;
    overflow: hidden;
}

th, td{
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
}

th{
    background: #F5DEB3;
    color: black;
}

tr:nth-child(even){
    background: #f9f9f9;
}

.logo{
    position: absolute;
    top: 20px;
    left: 20px;
}

.logo img{
    width: 70px;
    height: auto;
}

</style>

</head>
<body>

<div class="logo">
    <img src="image/yasai.jpg" alt="ロゴ">
</div>

<%
List<FoodBean> foodList = (List<FoodBean>) request.getAttribute("foodList");
%>

<div class="title-area">
    <h2>食材一覧</h2>

    <a class="btn search search-btn"
       href="food-search.jsp">
       検索
    </a>
</div>

<div class="table-area">

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
        <img src="./<%= food.getFoodImage() %>" width="100">
    </td>

    <td><%= food.getFoodName() %></td>
    <td><%= food.getFoodLostDay() %></td>
    <td><%= food.getFoodQuantity() %></td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="4"
        style="text-align:center;padding:20px;color:#666;">
        表示する食材情報報がありません
    </td>
</tr>

<%
}
%>

</table>

</div>

<br>

<div class="fixed-menu">

<a class="btn add" href="food-add.jsp">
    追加
</a>

<a class="btn update" href="food-update.jsp"> 
    変更
</a>

<a class="btn delete" href="food-delete.jsp"> 
    削除
</a>

</div>

</body>
	
	
</html>