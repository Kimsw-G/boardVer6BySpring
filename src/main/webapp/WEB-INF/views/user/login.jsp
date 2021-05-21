<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>${errMsg}</div>
<div>
	<form action="login" method="post">
		<div><input type="text" name="uid" placeholder="id"></div>
		<div><input type="password" name="upw" placeholder="password"></div>
	</form>

	<div>
		<a href="join">회원가입</a>
	</div>
</div>
