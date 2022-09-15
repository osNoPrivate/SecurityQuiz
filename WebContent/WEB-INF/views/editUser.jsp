<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>ユーザー編集</title>
</head>
<body>
	
	<div class="header" style="margin:0 20px 0 20px;">
		
		<form action="${pageContext.request.contextPath}/logout/" method="get">
			<input class="logout-button" type="submit" value="ログアウト">
		</form>
		<div class="headerName">SecurityQuiz</div>
				
		<table style="float:right;">
			<tr>
				<td align="right">
					<form action="${pageContext.request.contextPath}/editUser/" method="get">
						<input type="submit" class="userEdit-button"value="編集">
					</form>
				</td>
				<td>
					&ensp;&ensp;<c:out value="${loginUser.name}" />&ensp;さん
				</td>
			</tr>
		</table>
		
		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/home/" method="get">
						<input type="submit" class="headerHome-button" value="ホーム">
					</form>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/summary/" method="get">
						<input  type="submit" class="headerSummary-button" value="サマリー">
					</form>
				</td>
			</tr>
		</table>
	</div>
	
	<div align="center" class="main-content" style="margin:100px auto 0 auto;font-size: 18px;font-weight:bold;align-items: center;">
		<c:if test="${ not empty validationError }">
	 		<div class="errorMessages">
	 			<c:forEach items="${validationError}" var="validationError">
	 				<font color="red"><c:out value="${validationError}" /></font><br>
	 			</c:forEach>
	 		</div>
	 	</c:if>
	 	<font color="red"><c:out value="${errorMessage}" /></font>
	 	
	 	<form:form action="${pageContext.request.contextPath}/editUser/update/"
					modelAttribute="editUserForm">
		
			<form:errors path="*" style="color:red;"></form:errors><br>
			<table>
				<tr>
					<th align="center" colspan="2">ユーザー編集</th>
				</tr>
				<tr>
					<td>name</td>
					<td><form:input path="name" placeholder="名前" value="${ loginUser.name }" /></td>
				</tr>
				<tr>
					<td>account</td>
					<td><form:input path="account" placeholder="アカウント名" value="${ loginUser.account }"/></td>
				</tr>
				<tr>
					<td>password</td>
					<td><form:input type="password" path="password" placeholder="パスワード"/></td>
				</tr>
				<tr>
					<td>checkPassword</td>
					<td><form:input type="password" path="checkPassword" placeholder="パスワード確認"/></td>
				</tr>
				<tr>
					<td>authority</td>
					<td>
						<c:if test="${ loginUser.summary==1 }">人事<input type="hidden" name="summary" value="1"></c:if>
						<c:if test="${ loginUser.summary==2 }">インターン生<input type="hidden" name="summary" value="2"></c:if>
					</td>
				</tr>
			</table>
			
			<input type="hidden" name="id" value="${ loginUser.id }">
			<input class="summaryEditUser-button" type="submit" value="編集">
		</form:form>
	</div>
</body>
</html>