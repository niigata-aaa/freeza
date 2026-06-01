<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.FoodBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食材削除</title>
<style>
body {
	font-family: sans-serif;
	margin: 40px;
}

.container {
	border: 1px solid #333;
	width: 480px;
	padding: 20px;
	box-sizing: border-box;
}

h2 {
	margin-top: 0;
	border-bottom: 1px solid #333;
	padding-bottom: 10px;
}

.form-group {
	margin: 20px 0;
	font-size: 18px;
	display: flex;
	align-items: center;
}

.form-group label {
	width: 140px;
}

select {
	padding: 5px;
	font-size: 16px;
	box-sizing: border-box;
}

#foodSelect {
	width: 260px;
}

.button-group {
	display: flex;
	justify-content: space-between;
	margin-top: 40px;
}

input[type="button"], input[type="submit"] {
	padding: 8px 30px;
	font-size: 16px;
	cursor: pointer;
	background-color: #fff;
	border: 1px solid #333;
}
</style>
</head>
<body>

	<div class="container">
		<h2>削除</h2>

		<form action="food-delete-confirm-servlet" method="post">

			<div class="form-group">
				<label for="foodSelect">削除する食材：</label> <select name="foodDelete"
					id="foodSelect">
					<option value="">-- 選択してください --</option>

					<%
					List<FoodBean> foodList = (List<FoodBean>) session.getAttribute("foodList");
                    if (foodList != null) {
                        for (FoodBean food : foodList) {
                	%>
					<option value="<%= food.getFoodId() %>"><%= food.getFoodName() %>
						<%= food.getFoodLostDay() %></option>
					<%
                        }
                    }
                	%>

				</select>
			</div>

			<div class="button-group">
				<input type="button" value="戻る" onclick="history.back()"> <input
					type="submit" value="削除">
			</div>

		</form>
	</div>

</body>
</html>