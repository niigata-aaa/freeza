<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
    .footer-container {
        position: fixed;
        bottom: 25px;
        left: 50%;
        transform: translateX(-50%); 
        width: 92%; 
        max-width: 650px; 
        z-index: 9999;
    }

    .main-footer {
        background-color: #ffffff;
        border-radius: 40px; /* カプセル型にするための大きな丸み */
        box-shadow: 0 4px 15px rgba(165, 140, 115, 0.25); 
        padding: 16px 30px;
        display: flex;
        justify-content: space-around; /* アイコンを均等に並べる */
        align-items: center;
    }

	.footer-item {
        display: flex;
        flex-direction: column;
        align-items: center;
        text-decoration: none;
        color: #7A695D;
        font-family: 'Helvetica Neue', Arial, sans-serif;
        font-size: 14px; 
        font-weight: bold;
        gap: 6px; /* アイコンと文字の間隔を少し広げてゆったりに */
        transition: all 0.2s ease;
        flex: 1; /* 💡 各ボタンが均等に横幅をシェアして、押しやすくする */
        text-align: center;
    }

    /* アイコンのサイズ設定 */
    .footer-item i {
        font-size: 22px;
    }

    /*  選ばれているボタンを緑色 */
    .footer-item.active {
        color: #7D9D66;
    }

    /* ボタンを押したときに少し弾むようなエフェクト */
    .footer-item:active {
        transform: scale(0.92);
    }
</style>

<div class="footer-container">
    <nav class="main-footer">
        <a href="home-servlet" class="footer-item active">
            <i class="fa-solid fa-house"></i>
            <span>ホーム</span>
        </a>

        <a href="food-list-servlet" class="footer-item">
            <i class="fa-solid fa-carrot"></i>
            <span>食材一覧</span>
        </a>

        <a href="recipe-all-list-servlet" class="footer-item">
            <i class="fa-solid fa-kitchen-set"></i>
            <span>レシピ</span>
        </a>

        <a href="recipeMypage.jsp" class="footer-item">
            <i class="fa-solid fa-gear"></i>
            <span>マイページ</span>
        </a>
    </nav>
</div>