<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録画面</title>
<style>
    body { font-family: sans-serif; margin: 40px; background-color: #f9f9f9; }
    .container { border: 1px solid #e0e0e0; width: 500px; margin: 0 auto; padding: 30px; background: white; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.05); }
    h2 { text-align: center; margin-bottom: 30px; color: #333; }
    .form-group { display: flex; align-items: center; margin-bottom: 20px; }
    .form-group label { width: 120px; font-weight: bold; font-size: 16px; }
    .form-group input { flex: 1; padding: 10px; font-size: 16px; border: 1px solid #ccc; background-color: #f0f0f0; border-radius: 4px; }
    .btn-group { text-align: right; margin-top: 30px; }
    .btn { padding: 10px 25px; font-size: 16px; border: 1px solid #999; background: white; cursor: pointer; border-radius: 4px; margin-left: 10px; }
    .btn:hover { background: #eee; }
</style>
</head>
<body>

<div class="container">
    <h2>会員登録画面</h2>
    
    <form action="registration-servlet" method="post">

        <div class="form-group">
            <label>ID</label>
            <input type="text" name="userID" required>
        </div>

        <div class="form-group">
            <label>パスワード</label>
            <input type="password" name="password" required>
        </div>

        <div class="btn-group">
            <input type="submit" value="登録" class="btn">
            <input type="reset" value="クリア" class="btn">
        </div>
        
    </form>
</div>

</body>
</html>