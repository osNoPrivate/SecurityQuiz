<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>ログイン</title>
</head>
<body>
	<div  class="main-content">
		<div  align="center"class="login-form">
			<c:if test="${ not empty validationError }">
		 		<div class="errorMessages">
		 			<c:forEach items="${validationError}" var="validationError">
		 				<font color="red"><c:out value="${validationError}" /></font><br>
		 			</c:forEach>
		 		</div>
		 	</c:if> 
			<form:form action="${pageContext.request.contextPath}/login/check/" modelAttribute="user">
				<table>
					<tr>
						<td>account</td>
						<td><form:input path="account" placeholder="アカウント名" /></td>
					</tr>
					<tr>
						<td>password&ensp;</td>
						<td><form:input type="password" path="password" placeholder="パスワード"/></td>
					</tr>
				</table>
				<input type="submit" id="login-button" value="login">
			</form:form>
		
			<a href="/SecurityQuiz/addUser/">ユーザー登録はこちら</a>
		</div>
	</div>
</body>
</html>