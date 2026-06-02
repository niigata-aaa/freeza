<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<style>
body {
    font-family: 'Helvetica Neue', Arial, sans-serif;
    background-color: #fffaf6; /*薄いクリーム色の背景 */
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

/* ログインカード全体の枠 */
.container {
    background-color: #ffffff;
    border: 1px solid #f5ebe0;
    border-radius: 24px; /* 大きめの角丸 */
    width: 420px;
    padding: 40px 35px;
    box-sizing: border-box;
    box-shadow: 0 8px 24px rgba(218, 192, 163, 0.2); /* 優しい影 */
    text-align: center;
    position: relative;
}

/* タイトル「ログイン画面」の装飾 */
h2 {
    color: #4a3b32; /* 優しい焦げ茶色 */
    font-size: 26px;
    margin-top: 0;
    margin-bottom: 35px;
    font-weight: bold;
    letter-spacing: 2px;
}

/* 装飾を再現 */
h2::before, h2::after {
    content: " ✧ ";
    color: #e6ccb2;
    font-size: 18px;
    vertical-align: middle;
}

/*「ID」や「パスワード」の文字ラベル */
.input-label {
    display: block;
    text-align: left;
    color: #4a3b32;
    font-size: 15px;
    font-weight: bold;
    margin-bottom: 8px;
    margin-left: 5px;
}

/* 入力エリア全体のグループ */
.form-group {
    margin-bottom: 25px;
    position: relative;
}

/* 角が丸い入力欄 */
.input-wrapper {
    display: flex;
    align-items: center;
    background-color: #ffffff;
    border: 2px solid #f0e6df; /* 薄いベージュの枠線 */
    border-radius: 16px; /* 丸みのある角 */
    padding: 0 15px;
    transition: all 0.3s ease;
}

/* 入力欄がクリックされたときの色変化 */
.input-wrapper:focus-within {
    border-color: #dd7a4a;
    box-shadow: 0 0 0 3px rgba(221, 122, 74, 0.1);
}

/* 👤 🔑 アイコンのスタイル */
.input-wrapper i {
    color: #b5a499; /* アイコンのグレー色 */
    font-size: 18px;
    margin-right: 12px;
}

/* 実際のテキスト入力欄 */
.input-wrapper input {
    flex: 1;
    border: none;
    outline: none;
    padding: 14px 0;
    font-size: 15px;
    color: #4a3b32;
    background: transparent;
}

/* プレースホルダー（うっすら見えるヒント文字）の色 */
.input-wrapper input::placeholder {
    color: #cbc0b7;
}

/* 会員登録画面へのリンク */
.footer-group {
    margin-top: 25px;
    margin-bottom: 30px;
}

.footer-group a {
    color: #6b8e23; /* ナチュラルなグリーン */
    font-size: 15px;
    text-decoration: underline;
    font-weight: bold;
}

.footer-group a:hover {
    color: #4b6613;
}

/* ログインボタン（オレンジ色・丸み） */
.btn-submit-container {
    text-align: center;
}

.btn-login {
    background-color: #dd7a4a;
    color: #ffffff;
    border: none;
    border-radius: 30px; /* 完全なカプセル型 */
    width: 85%;
    padding: 14px 0;
    font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    box-shadow: 0 4px 12px rgba(221, 122, 74, 0.3);
    transition: all 0.2s ease;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    gap: 10px; /* 文字とアイコンの間隔 */
}

.btn-login:hover {
    background-color: #c96535;
    transform: translateY(-1px);
}

.btn-login:active {
    transform: translateY(1px);
}

/* エラーメッセージ */
.error-msg {
    color: #de6b6b;
    font-weight: bold;
    text-align: center;
    margin-bottom: 20px;
    font-size: 14px;
    background-color: #fff0f0;
    padding: 8px;
    border-radius: 8px;
}
</style>
</head>
<body>

<div class="container">
    <h2>ログイン画面</h2>

    <%-- ログインエラー時のメッセージ --%>
    <% String errorMsg = (String) request.getAttribute("errorMsg"); 
       if(errorMsg != null) { %>
        <div class="error-msg"><i class="fa-solid rel="nofollow" flex"></i> <%= errorMsg %></div>
    <% } %>

    <form action="login-servlet" method="post">
        
        <span class="input-label">ID</span>
        <div class="form-group">
            <div class="input-wrapper">
                <i class="fa-solid fa-user"></i> <input type="text" name="id" id="idField" placeholder="IDを入力してください" required autocomplete="off">
            </div>
        </div>
        
        <span class="input-label">パスワード</span>
        <div class="form-group">
            <div class="input-wrapper">
                <i class="fa-solid fa-lock"></i> <input type="password" name="password" id="passField" placeholder="パスワードを入力してください" minlength="8" required>
            </div>
        </div>
        
        <div class="footer-group">
            <a href="registration.jsp">会員登録画面へ</a>
        </div>
        
        <div class="btn-submit-container">
            <button type="submit" class="btn-login">
                <i class="fa-solid fa-right-to-bracket"></i> ログイン
            </button>
        </div>
        
    </form>
</div>

</body>
</html>