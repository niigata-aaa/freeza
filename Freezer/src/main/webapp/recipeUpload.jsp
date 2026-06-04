<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新しいレシピの投稿</title>
    <link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
</head>
<body>
<form action="recipe-list-servletX" method="post">
        <input type="submit" value="レシピ一覧に戻る" class="btn"/>
    </form>
    <br/>
    
    <button type="button" onclick="history.back();">
     前の画面に戻る
    </button>
    
<div class="manaita MANA1"></div>
<div class="totte TOTE1"></div>
<div class="bg-bubble b1"></div>
<div class="bg-bubbleaA bb1"></div>
<div class="bg-bubble2 b2"></div>
<div class="bg-bubble3 b3"></div>
    <h2>新しいお気に入りレシピを追加する</h2>
    <form action="recipe-upload-servlet" method="post" enctype="multipart/form-data">
        レシピ名: <input type="text" name="recipeName" required /><br/><br/>
        材料: <input type="text" name="recipeIngredients" required /><br/><br/>
        作り方: <br/><textarea name="recipeHowto" rows="5" cols="40" required></textarea><br/><br/>
        何人前: <input type="number" name="recipeServings" required /><br/><br/>
        料理画像: <input type="file" name="recipeImage" accept="image/*" required /><br/><br/>
        
        <input type="submit" value="アップロードして一覧へ" class="btn"/>
    </form>
    
            <div class="btn-group">

    
    <br/>
    
</body>
</html>