<%-- login.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<form action="/login-process" method="post">
    <label for="email">メールアドレス:</label><br>
    <input type="email" id="email" name="email" required><br>
    <label for="password">パスワード:</label><br>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="ログイン">
</form>
<p>アカウントをお持ちでないですか？ <a href="/register">新規登録はこちら</a></p>
</body>
</html>