<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>ホーム画面</title>
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
						<input style="color:black;" type="submit" class="headerHome-button" value="ホーム">
					</form>
				</td>
				<td>
					<c:if test="${ loginUser.summary == 1 }">
						<form action="${pageContext.request.contextPath}/summary/" method="get">
							<input  type="submit" class="headerSummary-button" value="サマリー">
						</form>
					</c:if>
				</td>
			</tr>
		</table>
		
	</div>
	
	<div class="main-content" align="center">
		<table style="margin:50px;">
			<tr>
				<th align="center">
				 説明
				</th>
			</tr>
			<tr>
				<th align="left">
				・このクイズを通して、セキュリティに関する理解を深めてください。<br>
				・問題は計10問、各10点配点の100点満点になります。<br>
				・合格基準は100点です。<br>
				・必ず解答を選択した後、解答ボタンを押下してください。<br>
				・全ての問題に解答してから、解答終了ボタンを押下してください。<br>
				・未解答の問題は、ページ上部に数字が灰色で表示されています。<br>
				</th>
			</tr>
		</table>
		
		<form action="${pageContext.request.contextPath}/question/" method="get">
			<input type="submit" id="start-button" value="開始">
		</form>
		
		<c:if test="${ not empty userScore }">
			<table class="home-table" border="1">
				<tr>
					<th>合否</th>
					<th>スコア</th>
					<th>日時</th>
				<tr>
				<c:forEach items="${userScore}" var="userScore">
				<tr >
					<td>
						<c:if test="${ userScore.score == 100 }">合格</c:if>
						<c:if test="${ userScore.score != 100 }">不合格</c:if>
					</td>
					<td><c:out value="${userScore.score}" /></td>
					<td><fmt:formatDate value="${userScore.createdDate}" pattern="yyyy/MM/dd" /></td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
</body>
</html>