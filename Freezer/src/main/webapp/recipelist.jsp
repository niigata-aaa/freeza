<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.RecipeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>個人レシピ一覧(2)</title>
<link rel="stylesheet" href="css/common.css">
</head>
<body>
    <%-- 会員マイページエリア --%>
    <div class="container">
        <div class="card">
            <h2>ユーザーID</h2>
            <p>登録食材数</p>
            <p>投稿レシピ</p>
            
            <a href="logout.jsp">ログアウトはこちら</a>
        </div>
    </div>

    <hr>

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
            <br>
            <a href="recipeMypage.jsp" class="btn">マイページに戻る</a>
        </div>
        <a href="recipeUpload.jsp" class="btn" style="display:inline-block; margin-bottom:10px; padding:5px 10px; background:#4CAF50; color:#fff; text-decoration:none; border-radius:3px;">新しいレシピを投稿する</a><br>
            <form action="recipe-list-servletX" method="post">
                <input type="submit" value="先頭に戻る">
            </form>
    </div>
</body>
</html>