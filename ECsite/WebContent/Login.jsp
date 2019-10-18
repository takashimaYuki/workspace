<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン</h1>
	<!-- ① LoginServletという名前で情報を送っている -->
	<!-- ②入力された名前とパスワードを送っている -->
	<form action="LoginServlet" method="post" name="Login">
		<table>
			<tr>
				<td>名前</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" name="password"></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="LOGIN">


</form>
</body>
</html>