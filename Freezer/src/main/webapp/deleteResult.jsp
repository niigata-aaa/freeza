<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除結果</title>
</head>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
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
Integer result = (Integer)request.getAttribute("result");
String error = (String)request.getAttribute("error");

if(error != null){
%>
    <h3>エラー</h3>
    <p><%= error %></p>
<%
}else{
    if(result != null && result > 0){
%>
        <h3>削除成功</h3>
<%
    }else{
%>
        <h3>対象データが存在しません</h3>
<%
    }
}
%>
	<%-- <button type="button" class="btn btn-cancel" onclick="history.back();">
                前の画面に戻る
            </button>
</div>--%>
</div>
<form action="recipeMypage.jsp" method="POST">

    <input type="submit" value="マイページ" class="btn">
</form>
 		
</body>
</html>