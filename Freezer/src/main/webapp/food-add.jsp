<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材追加</title>
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
<h2>食材追加</h2>
<br>
	
	<form action="food-add-confirm-servlet" method="POST" enctype="multipart/form-data">
	
		<div class="container">
    	<div class="photo-upload-container">
        	写真を追加：<input required type="file" id="foodPhoto" name="foodPhoto" accept="image/*" class="file-input">
			<span class="upload-label-text"></span>
    	</div>
    	</div>
    	
		食材名：<input required type="text" name="foodName">
				<input required type="number" name="number" min="1" step="1">
				<select name ="単位">
					<option value="個">個</option>
					<option value="本">本</option>
					<option value="g">g</option>
				</select><br>
		消費期限：<input required type="date" name="data"><br>
		
		<button type="button" onclick="history.back();" class="btn">戻る</button>
		<input type="submit" value="追加" class="btn">
	</form>
	
</div>

</div>
</body>

<%@ include file="footer.jsp" %>

</html>