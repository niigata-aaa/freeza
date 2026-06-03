<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人レシピ一覧(2)</title>
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
<a href="recipeMypage.jsp" class="btn">マイページに戻る</a>
        </div>
        <a href="recipeUpload.jsp" class="btn">新しいレシピを投稿する</a><br>
            <%-- <form action="recipe-list-servletX" method="post">
                <input type="submit" value="先頭に戻る">
            </form>--%>
<div class="bg-bubble b1"></div>
<div class="bg-bubble b2"></div>
<div class="bg-bubble b3"></div>

    <%-- 個人レシピ一覧テーブルエリア --%>
	<%
	List<RecipeBean> RecipeParsonalList = (List<RecipeBean>) request.getAttribute("RecipeParsonalList");
	%>
	<div class="container">
        <div class="card">
        <div class="color">
	        <div class="table_title">レシピリスト</div>
	        
	        <div class="example">
	            <table>
		            <tr>
                        <th>レシピ名</th>
                        <th>画像</th>
                        <th>材料</th>
                        <th>人数</th>
                        <th>更新日</th>
                        <th>操作</th>
                    </tr>
                   
                    <% if (RecipeParsonalList != null && !RecipeParsonalList.isEmpty()) { %>
                        <% for (RecipeBean employee : RecipeParsonalList){ %>
                        <tr>
                     
                            <td><%= employee.getRecipeName() %></td>
                            <td style="text-align: center;">
                                <%-- 参考データの手法で、DBから読んできたBLOB（Base64文字列）を綺麗に描写 --%>
                                <% if (employee.getBase64Image() != null && !employee.getBase64Image().isEmpty()) { %>
                                    <img src="data:image/jpeg;base64,<%= employee.getBase64Image() %>" width="100" height="100" style="object-fit: cover;">
                                <% } else { %>
                                    No Image
                                <% } %>
                            </td>
                            <td><%= employee.getRecipeIngredients() %></td>
                            <td><%= employee.getRecipeServings() %></td>
                            <td><%= employee.getUpdateDatetime() %></td>
                            <td>
                                <form action="recipe-datail-servlet" method="POST">
                                    <input type="hidden" name="code" value="<%= employee.getRecipeId() %>">
                                    <input type="submit" value="編集" class="btn">
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    <% } else { %>
                        <tr>
                            <td colspan="6" style="text-align:center;">レシピが1件も登録されていません。</td>
                        </tr>
                    <% } %>
	            </table>
	            </div>
            </div>
            </div>
            <br>
            

</body>
</html>