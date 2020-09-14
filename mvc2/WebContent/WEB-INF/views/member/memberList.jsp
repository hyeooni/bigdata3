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
-ȸ������Ʈ����(MVC-STEP1)-
<table>
<tr align='center' bgcolor='gray'>
	<td>��ȣ</td>
	<td>�̸�</td>
	<td>��ȣ</td>
	<td>��ȭ��ȣ</td>
	<td>����</td>
	<td>�浵</td>
	<td>����</td>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.num}</td>
	<td><a href="${cpath}/content.do?num=${vo.num}">${vo.name}</td>	<!-- �̸��� ��ũ �ɱ�.  ���� ����� �ٹ��. ����ǥ,������Ʈ�� -->
	<td>${vo.phone}</td>
	<td>${vo.addr}</td>
	<td>${vo.lat}</td>
	<td>${vo.lng}</td>
	<td><input type="button" value="����" onclick="deleteFn(${vo.num})"></td>		<!-- 2. �Լ� �����. ��� Ű ���� ����������-->
</tr>
</c:forEach>
<tr>
	<td colspan="6" align="left">
	<input type="button" value="ȸ������" onclick="insertForm()"/>		<!-- 1. �̷� �Լ� �ϳ� ����� -->
	</td>
</tr>
</table>
</body>
</html>