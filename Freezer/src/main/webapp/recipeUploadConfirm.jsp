<%@ page contentType="text/html;charset=UTF-8" %>
<%
String name = (String) session.getAttribute("Recipename");
String ingredients = (String) session.getAttribute("Recipeingredients");
String howto = (String) session.getAttribute("RecipeHowto");
String servings = (String) session.getAttribute("Recipeservings");
byte[] imgBytes = (byte[]) session.getAttribute("recipeImageBytes");

String base64 = "";
if (imgBytes != null) {
    base64 = java.util.Base64.getEncoder().encodeToString(imgBytes);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>

<body>
<div class="manaita MANA1"></div>
<div class="totte TOTE1"></div>
<div class="bg-bubble b1"></div>
<div class="bg-bubble2 b2"></div>
<div class="bg-bubble3 b3"></div>
<div class="container">
        <div class="card">
        <div class="color">
<h2>この内容で登録しますか？</h2>

<table border="1">

<tr>
<td>画像</td>
<td>
<% if (base64 != null && !base64.isEmpty()) { %>
    <img src="data:image/jpeg;base64,<%= base64 %>" width="150">
<% } else { %>
    No Image
<% } %>
</td>
</tr>

<tr><td>名前</td><td><%= name %></td></tr>
<tr><td>材料</td><td><%= ingredients %></td></tr>
<tr><td>作り方</td><td><%= howto %></td></tr>
<tr><td>人数</td><td><%= servings %></td></tr>

</table>

<br>

<!-- ★POSTで確定 -->
<div style="display:flex; gap:15px; justify-content:center; align-items:center;">

    <form action="recipe-upload-confirm-servlet" method="post" style="margin:0;">
        <input type="submit" value="登録する"
               style="width:140px; height:50px; border-radius:25px;
                      border:none; background:#6aa84f; color:white;
                      font-size:16px; cursor:pointer;">
    </form>

    <a href="javascript:history.back()"
       style="display:flex; width:140px; height:50px;
              border-radius:25px; background:#6aa84f;
              color:white; text-decoration:none;
              align-items:center; justify-content:center;
              font-size:16px;">
        戻る
    </a>

</div>
</div>
</div>
</div>
</body>
</html>