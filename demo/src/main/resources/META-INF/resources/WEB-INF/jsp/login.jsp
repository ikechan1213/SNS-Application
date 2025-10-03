<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <%-- CSSファイルを読み込むためのリンク --%>
    <link rel="stylesheet" href="/css/style.css">
    <%-- Google Fontsからフォントを読み込む (オプション) --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>

<main class="login-container">
    <div class="login-form">
        <%-- ロゴの代わりにテキストを使いますが、後で画像に置き換えられます --%>
        <div class="logo">🐦</div>

        <h1>アカウントにログイン</h1>

        <%-- Spring Securityのログイン処理へのPOST先を指定 --%>
        <form action="/login-process" method="post">

            <%-- ログイン失敗時のエラーメッセージ表示 --%>
            <c:if test="${param.error}">
                <div class="error-message">
                    ユーザー名またはパスワードが正しくありません。
                </div>
            </c:if>

            <div class="form-group">
                <%-- Spring Securityがユーザー名を認識するためのname="username" --%>
                <input type="text" id="username" name="username" placeholder="ユーザー名" required>
            </div>

            <div class="form-group">
                <%-- Spring Securityがパスワードを認識するためのname="password" --%>
                <input type="password" id="password" name="password" placeholder="パスワード" required>
            </div>

            <button type="submit" class="btn btn-primary">ログイン</button>
        </form>

        <div class="links">
            <a href="/register">アカウントをお持ちでないですか？ 新規登録</a>
        </div>
    </div>
</main>

</body>
</html>