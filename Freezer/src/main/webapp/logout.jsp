<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト確認</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>
body {
    font-family: 'Helvetica Neue', Arial, sans-serif;
    background-color: #fffaf6; 
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

/* 確認ボックス全体の枠 */
.container {
    background-color: #ffffff;
    border: 1px solid #f5ebe0;
    border-radius: 24px;
    width: 420px;
    padding: 40px 35px;
    box-sizing: border-box;
    box-shadow: 0 8px 24px rgba(218, 192, 163, 0.2); 
    text-align: center;
}

/* タイトルの装飾 */
h2 {
    color: #4a3b32; 
    font-size: 24px;
    margin-top: 0;
    margin-bottom: 25px;
    font-weight: bold;
    letter-spacing: 1px;
}

/* 質問文エリア */
.confirm-body {
    color: #6b5b52;
    font-size: 18px;
    font-weight: bold;
    line-height: 1.8;
    margin-bottom: 35px;
}

/* ログアウトアイコン */
.logout-icon {
    font-size: 48px;
    color: #cbc0b7;
    margin-bottom: 20px;
}

/* ボタンの並び */
.btn-group {
    display: flex;
    justify-content: space-between;
    gap: 15px;
}

/* 共通ボタンスタイル */
.btn {
    flex: 1;
    padding: 13px 0;
    font-size: 16px;
    font-weight: bold;
    border-radius: 30px; /* カプセル型 */
    cursor: pointer;
    transition: all 0.2s ease;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    gap: 8px;
}

/* ↩キャンセルボタン */
.btn-cancel {
    background-color: #f7f0ea;
    color: #7a6b61;
    border: 1px solid #eade水平d2;
}
.btn-cancel:hover {
    background-color: #ede2d7;
}

/* ログアウトボタン */
.btn-submit {
    background-color: #dd7a4a; 
    color: #ffffff;
    border: none;
    box-shadow: 0 4px 12px rgba(221, 122, 74, 0.3);
}
.btn-submit:hover {
    background-color: #c96535;
    transform: translateY(-1px);
}
.btn-submit:active {
    transform: translateY(1px);
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
<%
    // 🔍 セッションを確認して、キャンセル時の戻り先を自動判定
    String cancelUrl = "home-servlet"; // デフォルト（一般利用者用）
    
    if (session.getAttribute("adminId") != null) {
        cancelUrl = "admin-home.jsp"; // 管理者がログイン中なら、管理者トップへ戻す
    }
%>

<div class="container">
    <form action="logout-servlet" method="post">
        
        <div class="logout-icon">
            <i class="fa-solid fa-door-open"></i>
        </div>

        <h2>ログアウト</h2>
        
        <div class="confirm-body">
            ログアウトします。<br>
            よろしいですか？
        </div>
        
        <div class="btn-group">
            <button type="button" class="btn btn-cancel" onclick="location.href='<%= cancelUrl %>'">
                キャンセル
            </button>
            
            <button type="submit" class="btn btn-submit">
                ログアウト
            </button>
        </div>
    </form>
</div>

</body>
</html>