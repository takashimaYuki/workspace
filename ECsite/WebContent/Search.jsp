<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<h1>検索</h1>
	<br>

	<form action="SearchServlet" method="post">
		<input type="text" name="product_name"> <br>
		<br>

		<p>カテゴリ
		<select name="product_category">
		<option value="家電">家電</option>
		<option value="化粧品">化粧品</option>
		<option value="ぬいぐるみ">ぬいぐるみ</option>
		<option value="その他">その他</option>
		</select>
		</p>
	<input type="submit" name="submit" value="検索">

	</form>

	<table border="1">
		<tr></tr>
	</table>
</body>
</html>