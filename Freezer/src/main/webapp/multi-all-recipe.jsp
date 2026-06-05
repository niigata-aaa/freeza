<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピホーム</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>:root{
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

/* 2. テーブルの下が隠れてしまう問題を解決する設定 */
.table_title {
    flex: 1;             /* cardの中の残りの高さをいっぱいに使う */
    min-height: 0;       /* flex子要素の高さバグを防ぐ */
    display: flex;       /* 中の .example を正しく広げる */
    flex-direction: column;
}



}</style>
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
<h2>レシピ一覧</h2>        
<form action="recipe-all-search2-servlet" method="post" style="white-space: nowrap;">レシピ名または食材名: <input required type="text" maxlength="50" name="recipeName" style="width: 240px;"> <input type="submit" value=" 検索 " class="btn"></form>
<a href="recipe-all-regist-form.jsp" class="btn">レシピ投稿</a>
<div class="table_title"></div>

<%
List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");
%>
<div class="example">
<table>
<tr>
<!--<th>レシピID</th>-->
<tr><th>レシピ名</th><th>レシピ写真</th><th>材料</th><th>詳細表示</th> </tr>
<%
if (recipeList != null && !recipeList.isEmpty()) {
   for(RecipeBean recipe : recipeList){
%>
<tr>
<%--<td><%=recipe.getRecipeId()%></td>--%>
   <td><%=recipe.getRecipeName()%></td>
   
   <td><%-- 画像データが存在するかチェック --%>
        <% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
        <img src="data:image/png;base64,<%= recipe.getBase64Image() %>"width="125px" height="125px"/>
    	<% } else { %>
        	<div style="width:100px">No Image</div>
    	<% } %></td> 
    	
   <td><%=recipe.getRecipeIngredients()%></td>
<%--   <td><%=recipe.getRecipeHowto()%></td>
   <td><%=recipe.getRecipeServings()%></td>
   <td><%=recipe.getPostingDatetime()%></td>
   <td><%=recipe.getUpdateDatetime()%></td>--%>
<td>
<form action="recipe-all-detail-servlet" method="POST">
   <input type="hidden" name="RecipeId2" value="<%=recipe.getRecipeId()%>">
   <input type="submit" value="詳細表示" class="btn">
</form>
</td>
</tr>
<%
}
} else { // listがnullか空だった場合
%>
 <tr>
        <td colspan="8" style="text-align: center; padding: 20px;">
            表示するレシピ情報がありません。
        </td>
    </tr>
<%
} // ifの閉じ
%>
</table>
</div>
<%-- <form action="recipe-all-search2-servlet" method="post">

    レシピ名または食材名:
    <input type="text" maxlength="50" name="recipeName">

    <br><br>

    <input type="submit" value="検索">

</form>  --%>

<%-- <a href="recipe-all-regist-form.jsp">レシピ投稿</a>  --%>

</div>
</div>
</body>

<%@ include file="footer.jsp" %>

</html>

