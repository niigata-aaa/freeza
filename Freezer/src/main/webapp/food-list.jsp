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
:root{
    --footer-height: 70px;   /* 固定フッターの高さに合わせる */
}

html, body{
    height: 100%;
    margin: 0;
    overflow: hidden;        /* 画面全体はスクロールさせない */
}

/* containerの幅は今のまま */
.container{
    height: calc(90vh - var(--footer-height));
    box-sizing: border-box;
    padding-bottom: 10px;    /* フッターにピッタリくっつきすぎない用 */
}

/* cardを縦レイアウトに */
.card{
    height: 100%;
    display: flex;
    flex-direction: column;
    overflow: hidden;
    box-sizing: border-box;
}

/* 見出し・検索・ボタンは固定 */
.card h2,
.search-form,
.button-area{
    flex-shrink: 0;
}

.btn:hover {
    opacity: 0.8;
}

.add { background: #3498db; }
.update { background: #f39c12; }
.delete { background: #e74c3c; }
.search { background: #2ecc71; }

.search-form{
    display:flex;
    align-items:center;
    gap:10px;
}

.search-form label{
    white-space:nowrap;
}

.search-form input[type="text"]{
    flex:1;
    margin-top:0;
}
.search-form input[type="submit"]{
    margin-top:0;
}

.button-area{
    display:flex;
    justify-content:center;
    gap:30px;
    margin:20px 0;
    height: 48px;
}



/* 2. テーブルの下が隠れてしまう問題を解決する設定 */
.table_title {
    flex: 1;             /* cardの中の残りの高さをいっぱいに使う */
    min-height: 0;       /* flex子要素の高さバグを防ぐ */
    display: flex;       /* 中の .example を正しく広げる */
    flex-direction: column;
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
<%
List<FoodBean> foodList = (List<FoodBean>) request.getAttribute("foodList");
%>
<div class="container">

    <div class="card">
<h2>食材一覧</h2>
    
	<form action="food-search-servlet" method="post"  class="search-form">
    <label for="foodName">食材名：</label>
    <input required type="text" maxlength="50" name="foodName" >
    <input type="submit" value="検索" class="btn">
	</form>
	
<div class="button-area">
    <a class="btn" href="food-add.jsp">追加</a>

    <a class="btn" href="food-update.jsp">変更</a>

    <a class="btn" href="food-delete.jsp">削除</a>
</div>


 
 <div class="example">
<table class= "table2">

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
        <img src="data:image/jpeg;base64,<%= food.getBase64Image() %>"width="200" height="200" style="object-fit: cover;">
             
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
</div>


</div>
</div>
</body>

<!--	フッター-->

	<%@ include file="footer.jsp" %>
	
</html>