<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List" import="model.entity.FoodBean" import="model.entity.RecipeBean" import="model.entity.FoodLostBean" import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>

<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/localrecipeTable.css">
<style>
	body {
        font-family: 'Helvetica Neue', Arial, sans-serif;
        background-color: #fffaf6; 
        margin: 0;
        padding-top: 0px;    /* 上の余白を空ける設定 */
        padding-bottom: 60px;   /* フッター用の下の余白 */
    }
    /* 全体のコンテナスタイル */
    .home-section {
        margin: 20px 10px;
        padding: 15px;
        border: 2px solid #2B3A67;
        border-radius: 15px;
        background-color: #fff;
    }
    .section-title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 15px;
        color: #333;
    }
    
    /* 横並びのスクロール枠 */
    .scroll-box {
        display: flex;
        gap: 15px;
        overflow-x: auto;
        padding: 10px 5px;
    }

    /* 上下に分かれた丸みのあるカードデザイン */
    .custom-card {
        border: 2px solid #2B3A67;
        border-radius: 20px;
        width: 110px;
        min-width: 110px; /* 横スクロール時に潰れないように固定 */
        overflow: hidden;
        background: #fff;
        display: flex;
        flex-direction: column;
        align-items: center;
        position: relative;
    }
    .card-img-area {
        width: 100%;
        height: 85px;
        display: flex;
        justify-content: center;
        align-items: center;
        border-bottom: 1px solid #2B3A67;
        position: relative;
    }
    .card-img-area img {
        width: 75px;
        height: 75px;
        object-fit: cover;
        border-radius: 8px;
    }
    .card-name-area {
        width: 100%;
        height: 45px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        font-size: 12px;
        font-weight: bold;
        color: #333;
        background-color: #fafafa;
        text-align: center;
        padding: 2px;
    }

    /* 消費期限バッジ */
    .expiry-badge {
        position: absolute;
        top: 4px;
        left: 4px;
        color: white;
        font-size: 10px;
        font-weight: bold;
        padding: 2px 6px;
        border-radius: 6px;
        box-shadow: 1px 1px 3px rgba(0,0,0,0.2);
        z-index: 10;
    }
    .expiry-badge.red { background-color: #E57373; }
    .expiry-badge.orange { background-color: #FFB74D; }
    .expiry-badge.green { background-color: #81C784; }

    /* サブテキスト（日付など） */
    .sub-date {
        font-size: 9px;
        color: #777;
        font-weight: normal;
        margin-top: 1px;
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
    <div class="home-section">
        <div class="section-title">⚠️ 消費期限が近い食材</div>
        <div class="scroll-box">
            <% 
            List<FoodBean> foodlostdayList = (List<FoodBean>) request.getAttribute("foodlostdayList");
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd"); 
            
            if(foodlostdayList == null || foodlostdayList.isEmpty()) {
            %>
                <p style="color: #666; font-size: 14px;">消費期限が近い食材はありません。</p>
            <% 
            } else { 
                for(FoodBean foodlostday : foodlostdayList) { 
                    String formattedDate = (foodlostday.getFoodLostDay() != null) ? sdf.format(foodlostday.getFoodLostDay()) : "--/--";
            %>
                <div class="custom-card">
                    <div class="card-img-area">
                        <span class="expiry-badge <%= foodlostday.getMarkColor() %>">
                            <% if (foodlostday.getDaysLeft() != 0) { %>
                            あと<%= foodlostday.getDaysLeft() %>日
                            <% } else { %>
                            今日まで
                            <% } %>
                        </span>
                        <%-- 画像データが存在するかチェック --%>
						<% if (foodlostday.getBase64Image() != null && !foodlostday.getBase64Image().isEmpty()) { %>
        					<img src="data:image/jpeg;base64,<%= foodlostday.getBase64Image() %>"/>
             
    					<% } else { %>
        			<div style="width:100px">No Image</div>
    			<% } %>
                    </div>
                    <div class="card-name-area">
                        <%= foodlostday.getFoodName() %>
                        <span class="sub-date"><%= formattedDate %>まで</span>
                    </div>
                </div>
            <% 
                } 
            } 
            %>
        </div>
    </div>

<div class="home-section">
        <div class="section-title">🍳 今ある食材で作れるレシピ</div>
        <div class="scroll-box">
            <% 
            List<RecipeBean> recipeList = (List<RecipeBean>) request.getAttribute("recipeList");
            if(recipeList == null || recipeList.isEmpty()) {
            %>
                <p style="color: #666; font-size: 14px;">作れるレシピがありません。食材を登録してみましょう！</p>
            <% 
            } else { 
                for(RecipeBean recipe : recipeList) { 
            %>
                <a href="recipe-all-detail-servlet?RecipeId2=<%= recipe.getRecipeId() %>" style="text-decoration: none; color: inherit;">
                    <div class="custom-card">
                        <div class="card-img-area">
                             <%-- 画像データが存在するかチェック --%>
       							 <% if (recipe.getBase64Image() != null && !recipe.getBase64Image().isEmpty()) { %>
							        <img src="data:image/jpeg;base64,<%= recipe.getBase64Image() %>"/>
							             
							    	<% } else { %>
							        	<div style="width:100px">No Image</div>
							    <% } %>

                        </div>
                        <div class="card-name-area">
                            <%= recipe.getRecipeName() %>
                        </div>
                    </div>
                </a>
            <% 
                } 
            } 
            %>
        </div>
    </div>    
    
    <div class="home-section">
        <div class="section-title">🗑️ 廃棄食材</div>
        <div class="scroll-box">
            <% 
            List<FoodLostBean> foodlostList = (List<FoodLostBean>) request.getAttribute("foodlostList");
            if(foodlostList == null || foodlostList.isEmpty()) {
            %>
                <p style="color: #666; font-size: 14px;">廃棄された食材はありません</p>
            <% 
            } else { 
                for(FoodLostBean foodlost : foodlostList) { 
            %>
                <div class="custom-card">
                    <div class="card-img-area">
                        <%-- 画像データが存在するかチェック --%>
					        <% if (foodlost.getBase64Image() != null && !foodlost.getBase64Image().isEmpty()) { %>
					        <img src="data:image/jpeg;base64,<%= foodlost.getBase64Image() %>"/>
					             
					    	<% } else { %>
					        	<div style="width:100px">No Image</div>
					    	<% } %>
                        
                    </div>
                    <div class="card-name-area">
                        <%= foodlost.getFoodLostName() %>
                    </div>
                </div>
            <% 
                } 
            } 
            %>
        </div>
    </div>

</body>
<%@ include file="footer.jsp" %>
</html>