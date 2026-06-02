<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.entity.RecipeBean" %>

<%
List<RecipeBean> recommendRecipes = (List<RecipeBean>) request.getAttribute("recommendRecipes");
%>

<div class="recipe-recommend-box" style="display: flex; gap: 15px; overflow-x: auto; padding: 10px;">
    <%
    if (recommendRecipes != null && !recommendRecipes.isEmpty()) {
        for (RecipeBean recipe : recommendRecipes) {
    %>
        <div class="recipe-card" style="text-align: center; min-width: 120px;">
            <img src="./<%= recipe.getRecipeImg() %>" width="100" height="100" style="border-radius: 8px; object-fit: cover;"><br>
            <span style="font-size: 14px; font-weight: bold;"><%= recipe.getRecipeName() %></span>
        </div>
    <%
        }
    } else {
    %>
        <p style="color: #666; font-size: 14px; padding: 10px;">今ある食材で作れるレシピがありません。</p>
    <%
    }
    %>
</div>