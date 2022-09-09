<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー登録</title>
</head>
<body>
<div align="center" class="main-content" style="margin:100px auto 0 auto;font-size: 18px;font-weight:bold;align-items: center;">
 	<c:if test="${ not empty validationError }">
 		<div class="errorMessages">
 			<c:forEach items="${validationError}" var="validationError">
 				<font color="red"><c:out value="${validationError}" /></font><br>
 			</c:forEach>
 		</div>
 	</c:if> 

	<form:form action="${pageContext.request.contextPath}/addUser/insert/"
				modelAttribute="userForm">
	
		<form:errors path="*" style="color:red;"></form:errors><br>
		<table>
			<tr>
				<th align="center" colspan="2">ユーザー登録</th>
			</tr>
			<tr>
				<td>name</td>
				<td><form:input path="name" placeholder="名前" /></td>
			</tr>
			<tr>
				<td>account</td>
				<td><form:input path="account" placeholder="アカウント名" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><form:input type="password" path="password" placeholder="パスワード"/></td>
			</tr>
			<tr>
				<td>checkPassword&ensp;</td>
				<td><form:input type="password" path="checkPassword" placeholder="パスワード確認"/></td>
			</tr>
			<tr>
				<td>summary</td>
				<td>インターン生</td>
			</tr>
		</table>
		<input type="hidden" name="summary" value="2"><br>
		<input class="summaryAddUser-button" type="submit" value="登録">
	</form:form>
	
	<a href="/SecurityQuiz/">ログインはこちら</a>
</div>
</body>
</html>