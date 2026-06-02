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
<%--           <tr>
               <td>レシピID：</td>
               <td><input type="text" name="recipeid" size="30"></td>
           </tr>   --%> 
           <tr>
               <td>レシピ名：</td>
               <td><input type="text" name="recipename" size="10"></td>
           </tr>
             <tr>
               <td>レシピ画像：</td>
               <td><input type="image" name="recipeimg"></td>
           </tr>  
           <tr>
               <td>レシピ材料：</td>
               <td><textarea name="recipeingredients" cols="30" ></textarea></td>
           </tr>
           <tr>
               <td>レシピ作り方：</td>
               <td><textarea name="recipehowto" cols="30" ></textarea></td>
           </tr>
           <tr>
               <td>レシピ何人前：</td>
               <td><input type="number"  name="recipeservings"></td>
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
               <td><input type="submit" value="登録"></td>
           </tr>
       </table>
   </form>
</body>
</html>
