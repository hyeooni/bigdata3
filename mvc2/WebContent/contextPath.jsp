<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>		<!-- 더 짧게 쓰고 싶으면 변수에? -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
context path=${cpath}		<!-- EL, context정보 가져오고 싶을 때 --> <!-- 더 짧게 쓰고 싶으면 변수에? -->
<!-- 경로 변경 시 유용하게! 여기만 바꾸면 이름 바뀌어도 사용 가능 -->
</body>
</html>