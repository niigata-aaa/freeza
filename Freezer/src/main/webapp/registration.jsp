<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録 - ロスロス</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<style>
    body { 
        font-family: 'Helvetica Neue', Arial, 'Hiragino Kaku Gothic ProN', 'Hiragino Sans', Meiryo, sans-serif; 
        margin: 0; 
        padding: 40px 20px;
        background-color: #fffaf6;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        box-sizing: border-box;
    }

    .container { 
        border: 1px solid #f5ebe0; 
        width: 100%;
        max-width: 450px;
        padding: 40px 30px; 
        background: #ffffff; 
        border-radius: 24px;
        box-shadow: 0 8px 24px rgba(218, 192, 163, 0.25);
        box-sizing: border-box;
    }

    /* アイコンタイトル */
    .logo-area {
        text-align: center;
        margin-bottom: 10px;
    }
    .logo-area i {
        font-size: 40px;
        color: #dd7a4a; 
    }

    h2 { 
        text-align: center; 
        margin-top: 0;
        margin-bottom: 35px; 
        color: #4A2E1B;
        font-size: 24px;
        font-weight: bold;
        letter-spacing: 1px;
    }

    .form-group { 
        display: flex; 
        flex-direction: column;
        margin-bottom: 22px; 
    }

    .form-group label { 
        margin-bottom: 8px; 
        font-weight: bold; 
        font-size: 14px; 
        color: #705C4E; 
    }

    .form-group input { 
        padding: 14px 16px; 
        font-size: 16px; 
        border: 2px solid #f0e6df; 
        background-color: #ffffff; 
        border-radius: 12px; 
        color: #4A2E1B;
        outline: none;
        transition: all 0.2s ease;
        box-sizing: border-box;
    }

    .form-group input:focus {
        border-color: #dd7a4a;
        background-color: #fffdfb;
        box-shadow: 0 0 0 4px rgba(221, 122, 74, 0.1);
    }

	/* 均等配置 */
    .btn-group { 
        display: flex;
        gap: 12px;
        margin-top: 35px; 
    }

    .btn { 
        flex: 1; /* 2つのボタンの長さを同じにする */
        padding: 14px; 
        font-size: 16px; 
        font-weight: bold;
        border: none;
        cursor: pointer; 
        border-radius: 14px; 
        transition: all 0.2s ease;
        text-align: center;
    }

    /* 登録ボタン */
    .btn-submit {
        background-color: #dd7a4a;
        color: white;
        box-shadow: 0 4px 12px rgba(221, 122, 74, 0.2);
    }
    .btn-submit:hover { 
        background-color: #cb6533; 
        transform: translateY(-1px);
    }
    .btn-submit:active {
        transform: translateY(1px);
    }

    /* クリアボタン */
    .btn-clear {
        background-color: #f7f2ed;
        color: #a39081;
    }
    .btn-clear:hover {
        background-color: #eee5dc;
    }

    /* ログイン画面へ戻るリンクを追加 */
    .back-to-login {
        text-align: center;
        margin-top: 25px;
        font-size: 13px;
    }
    .back-to-login a {
        color: #dd7a4a;
        text-decoration: none;
        font-weight: bold;
    }
    .back-to-login a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container">
    <div class="logo-area">
        <i class="fa-solid fa-carrot"></i>
    </div>
    <h2>会員登録</h2>
    
    <form action="registration-servlet" method="post">

        <div class="form-group">
            <label for="userID">ユーザーID</label>
            <input type="text" id="userID" name="userID" placeholder="例: user01 　【６文字以上入力してください】" minlength="6" required>
        </div>

        <div class="form-group">
            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" minlength="8" required>
        </div>

        <div class="btn-group">
            <input type="reset" value="クリア" class="btn btn-clear">
            <input type="submit" value="登録する" class="btn btn-submit">
        </div>
        
    </form>

    <div class="back-to-login">
        すでにアカウントをお持ちの方は <a href="login.jsp">ログイン</a>
    </div>
</div>

</body>
</html>