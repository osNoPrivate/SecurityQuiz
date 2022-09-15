<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>サマリー画面</title>
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
						<input style="color:black;" type="submit" class="headerSummary-button" value="サマリー">
					</form>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/summaryAddUser/" method="get">
						<input type="submit" class="headerSummaryAddUser-button" value="ユーザー登録">
					</form>
				</td>
			</tr>
		</table>
	</div>
	
	<div align="center" class="main-content">
		<table class="summary-table">
			<tr>
				<th width="10%">合否</th><th width="20%">名前</th><th width="20%">アカウント名</th><th width="20%">権限</th><th width="20%">作成日</th><th width="5%">削除</th><th width="5%">編集</th>
			</tr>
			
			<c:forEach items="${userDataList}" var="userData">
				<tr>
					<td>
						<c:if test="${ userData.result == 1 }">合格</c:if>
						<c:if test="${ userData.result != 1 }"><font color="red">不合格</font></c:if>
					</td>
					<td>
						<c:out value="${userData.name}" />
					</td>
					<td>
						<c:out value="${userData.account}" />
					</td>
					<td>
						<c:if test="${ userData.summary == 1 }">人事</c:if>
						<c:if test="${ userData.summary != 1 }">インターン生</c:if>
					</td>
					<td>
						<fmt:formatDate value="${userData.createdDate}" pattern="yyyy/MM/dd" />
					</td>
					<td>
						<c:if test="${ userData.id != loginUser.id }">
							<form:form action="${pageContext.request.contextPath}/deleteUser/" modelAttribute="user">
								<input type="hidden" name="id" value="${userData.id}">
								<input type="submit" class="summaryDelete-button" value="削除" onClick="return deletecheck()">
							</form:form>
						</c:if>
					</td>
					<td>
						<c:if test="${ userData.id != loginUser.id }">
							<form:form action="${pageContext.request.contextPath}/summaryEditUser/" modelAttribute="userData" >
								<input type="hidden" name="id" value="${userData.id}">
								<input type="hidden" name="account" value="${userData.account}">
								<input type="hidden" name="name" value="${userData.name}">
								<input type="hidden" name="summary" value="${userData.summary}">
								<input type="hidden" name="password" value="${userData.password}">
								<input type="submit" class="summaryEdit-button" value="編集">
							</form:form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<script>
	function deletecheck(){
		if(window.confirm('削除すると、ユーザー情報は元には戻りませんがよろしいですか？')){
			return true;
				}else{
			return false;
				}
		}
</script>
</body>
</html>