<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材追加</title>
</head>
<body>
食材追加<br>
	
	<form action="food-add-confirmation-servlet" method="POST" enctype="multipart/form-data">
	
		<div class="container">
    	<div class="photo-upload-container">
        	<input type="file" id="foodPhoto" name="foodPhoto" accept="image/*" class="file-input">
			<span class="upload-label-text">+写真を追加</span>
    	</div>
    	</div>
    	
		食材名：<input type="text" name="foodName">
				<input type="number" name="number">
				<select name ="単位">
					<option value="個">個</option>
					<option value="本">本</option>
					<option value="g">g</option>
				</select><br>
		消費期限：<input type="date" name="data"><br>
		
		<a href="javascript:history.back();">戻る</a>
		<input type="submit" value="追加">
	</form>
</body>
</html>