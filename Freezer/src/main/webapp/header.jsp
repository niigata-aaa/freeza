<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    /* ヘッダー全体の背景や余白の設定 */
    .main-header {
        position: fixed; 
        top: 0;
        left: 0;         
        width: 100%;
        height: 90px;    /* ヘッダーの高さを 90px に固定 */
        background-color: #FAF6F0;
        padding: 15px 25px;
        display: flex;
        align-items: center;
        border-bottom: 1px solid #E6DEC9;
        font-family: 'Helvetica Neue', Arial, 'Hiragino Kaku Gothic ProN', 'Hiragino Sans', Meiryo, sans-serif;
        box-sizing: border-box; 
        z-index: 9999;   /* 💡 食材カードよりも必ず手前に表示されるようにする魔法の数字 */
    }
    
    /* ロゴとタイトルのブロック */
    .header-left {
        display: flex;
        align-items: center;
        gap: 15px;
    }

    .header-logo {
        height: 60px;
        width: auto;
    }

    .title-group {
        display: flex;
        flex-direction: column;
        gap: 2px;
    }

    .main-title {
        color: #4A2E1B;
        font-size: 26px;
        font-weight: bold;
        margin: 0;
        letter-spacing: 1px;
    }

    .sub-title {
        color: #705C4E;
        font-size: 13px;
        margin: 0;
    }
</style>

<header class="main-header">
    <div class="header-left">
        <img src="${pageContext.request.contextPath}/img/yasai.png" alt="ロゴ" class="header-logo">
        
        <div class="title-group">
            <h1 class="main-title">ロスロス</h1>
            <p class="sub-title">家庭内フードロス削減システム</p>
        </div>
    </div>
</header>