<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>サマリーユーザー編集</title>
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
						<input type="submit" class="headerSummary-button" value="サマリー">
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
	 	
	 	<form:form action="${pageContext.request.contextPath}/summaryEditUser/update/"
					modelAttribute="summaryEditUserForm">
		
			<form:errors path="*" style="color:red;"></form:errors><br>
			<table>
				<tr>
					<th align="center" colspan="2"><c:out value="${summaryEditUserForm.name}" />&ensp;さんのユーザー編集</th>
				</tr>
				<tr>
					<td>name</td>
					<td><form:input path="name" placeholder="名前" value="${ summaryEditUserForm.name }" /></td>
				</tr>
				<tr>
					<td>account</td>
					<td><form:input path="account" placeholder="アカウント名" value="${ summaryEditUserForm.account }"/></td>
				</tr>
				<tr>
					<td>password</td>
					<td>変更できません</td>
				</tr>
				<tr>
					<td>checkPassword&ensp;</td>
					<td>変更できません</td>
				</tr>
				<tr>
					<td>summary</td>
					<td><form:select path="summary" items="${selectName}" itemLabel="name" itemValue="status" ></form:select></td>
				</tr>
			</table>
			
			<input type="hidden" name="id" value="${summaryEditUserForm.id}">
			<input type="hidden" name="password" value="${summaryEditUserForm.password}">
			<input class="summaryEditUser-button" type="submit" value="編集">
		</form:form>
	</div>
</body>
</html>