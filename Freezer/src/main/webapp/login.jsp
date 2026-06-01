<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style>
body {
    font-family: sans-serif;
    margin: 40px;
}
.container {
    border: 1px solid #333;
    width: 480px;
    padding: 30px;
    box-sizing: border-box;
}
h2 {
    text-align: center;
    margin-top: 0;
    margin-bottom: 30px;
}
.form-group {
    border: 1px solid #e74c3c; /* 赤い枠線 */
    margin: 15px 0;
    padding: 10px;
    display: flex;
    align-items: center;
}
.form-group label {
    width: 120px;
    font-size: 18px;
    font-weight: bold;
}
.form-group input {
    flex: 1;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    background-color: #eee; /* 入力欄の中のグレー色 */
}
.footer-group {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 30px;
}
.footer-group a {
    color: #3498db;
    text-decoration: underline;
}
input[type="submit"] {
    padding: 10px 30px;
    font-size: 16px;
    cursor: pointer;
    background-color: #fff;
    border: 1px solid #333;
}
</style>
</head>
<body>

<div class="container">
    <h2>ログイン画面</h2>

    <form action="login-servlet" method="post">
        
        <div class="form-group">
            <label for="idField">ID</label>
            <input type="text" name="name" id="idField" required>
        </div>
        
        <div class="form-group">
            <label for="passField">パスワード</label>
            <input type="password" name="password" id="passField" minlength="8" required>
        </div>
        
        <div class="footer-group">
            <a href="registration.jsp">会員登録画面へ</a>
            <input type="submit" value="ログイン">
        </div>
        
    </form>
</div>

</body>
</html>