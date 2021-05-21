<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div><a href="list">리스트로 돌아가기</a></div>
<h1>${requestScope.data.title}
	<c:if test="${data.isFav eq 0}">
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
	</c:if>
	<c:if test="${data.isFav == 1}">
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a>
	</c:if>
</h1>
<div>글번호 : ${requestScope.data.iboard}</div>
<div>작성자 : ${requestScope.data.unm} | 작성일 : ${requestScope.data.regdt}</div>
<div>${requestScope.data.ctnt}</div>

<script>
	function ajax(iboard){
		console.log('iboard : '+iboard);

		const param = {iboard}

		const init = {
			method: 'POST',
			body: JSON.stringify(param);
		}
		fetch('/board/detail',init)
		.then(res=>res.json())
		.then(myJson=>console.log(myJson));
	}
	ajax(${iboard});
</script>
