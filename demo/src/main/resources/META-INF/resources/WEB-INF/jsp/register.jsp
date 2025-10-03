<%-- register.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規登録</title>
</head>
<body>
<h1>新規登録</h1>
<form action="/register-process" method="post">
    <label for="email">メールアドレス:</label><br>
    <input type="email" id="email" name="email" required><br>
    <label for="password">パスワード:</label><br>
    <input type="password" id="password" name="password" required><br><br>
    <input type="submit" value="登録">
</form>
<p>すでにアカウントをお持ちですか？ <a href="/login">ログインはこちら</a></p>
</body>
</html>