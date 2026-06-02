<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ登録画面</title>
</head>
<body>
<h2>レシピ登録画面</h2>
   <form action="recipe-all-regist-confirm-servlet" method="POST">
       <table>
           <tr>
               <td>レシピ名：</td>
               <td><input required type="text" name="recipename" size="10"></td>
           </tr>
<%--             <tr>
               <td>レシピ画像：</td>
               <td><input type="image" name="recipeimg"></td>
           </tr>  --%>
           <tr>
               <td>レシピ材料：</td>
               <td><textarea required name="recipeingredients" cols="30" ></textarea></td>
           </tr>
           <tr>
               <td>レシピ作り方：</td>
               <td><textarea required name="recipehowto" cols="30" ></textarea></td>
           </tr>
           <tr>
               <td>レシピ何人前：</td>
               <td><input required type="number"  name="recipeservings" min="1" step="1"></td>
           </tr>
           <tr>

           <tr>
               <td><input type="submit" value="登録"></td>
           </tr>
       </table>
   </form>
</body>
</html>
