<%-- header.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // セッションからユーザー情報を取得
    String loggedInUser = (String) session.getAttribute("loggedInUser");
    if (loggedInUser == null) {
        // ログインしていない場合
%>
<a href="/login">ログイン</a>
<%
} else {
    // ログインしている場合
%>
<p>ようこそ、<%= loggedInUser %>さん</p>
<a href="/logout">ログアウト</a>
<a href="/mypage">マイページ</a>
<%
    }
%>