<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ登録画面</title>
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
<div class="container">
        <div class="card">
<h2>レシピ登録画面</h2>
   <form action="recipe-all-regist-confirm-servlet" method="POST" enctype="multipart/form-data">
       <table>
<%--           <tr>
               <td>レシピID：</td>
               <td><input type="text" name="recipeid" size="30"></td>
           </tr>   --%> 
           <tr>
               <td>レシピ名：</td>
               <td><input required type="text" name="recipename" size="10" maxlength="50"></td>
           </tr>
             <tr>
               <td>レシピ画像：</td>
               <td><input required type="file" id="recipePhoto" name="recipePhoto" accept="image/*" class="file-input"></td>
           </tr>  
           <tr>
               <td>レシピ材料：</td>
               <td><textarea required name="recipeingredients" cols="50" rows="4" maxlength="200"></textarea></td>
           </tr>
           <tr>
               <td>レシピ作り方：</td>
               <td><textarea required name="recipehowto" cols="50" rows="20" maxlength="1000" class="space"></textarea></td>
           </tr>
           <tr>
               <td>レシピ何人前：</td>
               <td><input required type="number"  name="recipeservings" min="1" step="1"></td>
           </tr>
           <tr>
<%--                <td>レシピ掲載日時：</td>
               <td><input type="date" name="posting"></td>
           </tr>
<%--           <tr>
               <td>レシピ更新日時：</td>
               <td><input type="date" name="update"></textarea></td>
           </tr>  --%> 
           <tr>
               <td><input type="submit" value="登録" class="btn"></td>
           </tr>
           
           
       </table>
   </form>
   </div>
   </div>
   <tr><form action="recipe-all-list-servlet" method="post">

			    <td><input type="submit" value="食材一覧へ戻る" class="btn">
			
			</tr></form>
</body>

<%@ include file="footer.jsp" %>

</html>
