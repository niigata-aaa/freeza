<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材追加</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">

<style>
.photo-upload-wrapper {
    display: flex;
    align-items: center;
    gap: 15px;
    margin-bottom: 25px;
    cursor: pointer;
}

.file-input-hidden {
    display: none;
}

.photo-circle-btn {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    border: 2px solid #555;
    background-color: #EFEFEF;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 32px;
    color: #555;
    font-weight: normal;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.upload-label-text-local {
    font-size: 24px;
    font-weight: bold;
    color: #333;
}


.btn-confirm-local {
    background: #7A9D54;
    color: white;
    padding: 12px 0;
    border: none;
    border-radius: 30px;
    text-decoration: none;
    cursor: pointer;
    display: inline-block;
    min-width: 220px;         
    box-sizing: border-box;   
    text-align: center;       
    font-size: 24px; 
}

.btn-confirm-local:hover {
    background: #648046;
}

.confirm-button-area-local {
    display: flex;
    margin-top: 25px;
    justify-content: space-between; 
}
</style>

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
	
	
	<form action="food-add-confirm-servlet" method="POST" enctype="multipart/form-data" style="width: 100%;" onsubmit="return validateForm()">
	
		<label class="photo-upload-wrapper">
			<input type="file" id="foodPhoto" name="foodPhoto" accept="image/*" class="file-input-hidden">
			<div class="photo-circle-btn">＋</div>
			<span class="upload-label-text-local">写真を追加</span>
		</label>
    	
		食材名：<input required type="text" name="foodName">
				<input required type="number" name="number" min="1" step="1">
				<select name ="単位">
					<option value="個">個</option>
					<option value="本">本</option>
					<option value="g">g</option>
				</select><br>
		消費期限：<input required type="date" name="data"><br>
		
		<div class="confirm-button-area-local">
			<a href="javascript:history.back();" class="btn-confirm-local">戻る</a>
			<input type="submit" value="追加" class="btn-confirm-local">
		</div>
	</form>
	
</div>

</div>


<script>
function validateForm() {
    var fileInput = document.getElementById('foodPhoto');
    
    // 写真（ファイル）の選択数が0個だった場合の判定
    if (fileInput.files.length === 0) {
        alert('写真を追加してください！'); // ポップアップを表示
        return false; 
    }
    return true; 
}
</script>

</body>

<%@ include file="footer.jsp" %>

</html>