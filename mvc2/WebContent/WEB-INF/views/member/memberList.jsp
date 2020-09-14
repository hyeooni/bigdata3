<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function insertForm(){
		location.href="${cpath}/insertForm.do";
	}
	function deleteFn(num){
		location.href="${cpath}/delete.do?num="+num;
	}
</script>
</head>
<body>
-회원리스트보기(MVC-STEP1)-
<table>
<tr align='center' bgcolor='gray'>
	<td>번호</td>
	<td>이름</td>
	<td>번호</td>
	<td>전화번호</td>
	<td>위도</td>
	<td>경도</td>
	<td>삭제</td>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.num}</td>
	<td><a href="${cpath}/content.do?num=${vo.num}">${vo.name}</td>	<!-- 이름에 링크 걸기.  저런 방식은 겟방식. 꼬리표,쿼리스트링 -->
	<td>${vo.phone}</td>
	<td>${vo.addr}</td>
	<td>${vo.lat}</td>
	<td>${vo.lng}</td>
	<td><input type="button" value="삭제" onclick="deleteFn(${vo.num})"></td>		<!-- 2. 함수 만들기. 어떠한 키 값을 가져가야함-->
</tr>
</c:forEach>
<tr>
	<td colspan="6" align="left">
	<input type="button" value="회원가입" onclick="insertForm()"/>		<!-- 1. 이런 함수 하나 만들기 -->
	</td>
</tr>
</table>
</body>
</html>