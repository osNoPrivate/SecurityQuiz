<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
 <style type="text/css">
 .card-header {
 	background-color:white;
 	padding:0;
 }
</style>
<title>結果画面</title>
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
		<form action="${pageContext.request.contextPath}/home/" method="get">
			<input type="submit" class="home-button" value="ホーム">
		</form>
	</div>
	
	<div class="main-content" >
		<div class="result-score">あなたの点数<c:out value="${score}" />
			<c:if test="${ score == 100 }">合格</c:if>
			<c:if test="${ score != 100 }"><font color="red">不合格</font></c:if>
		</div>
		
		
		<c:forEach var="question" items="${allQuestion}" varStatus="status">
			<table class="result-area" border="1" >
				<tr>
					<th width="10%"><c:out value="問題${question.id}" /></th>
					<td width="90%" colspan="3">
						<c:if test="${ question.judge == 1 }">正解</c:if>
						<c:if test="${ question.judge != 1 }"><font color="red">不正解</font></c:if>
					</td>
				</tr>
				<tr>
					<th>問題文</th>
					<td colspan="3">
						<c:out value="${ question.question }" />
					</td>
				</tr>
				<tr>
					<th>選択肢</th>
					<td colspan="3">
						<table class="answer">
							<tr>
								<td><c:out value="${question.firstAnswer}" /></td>
								<td><c:out value="${question.secondAnswer}" /></td>
							</tr>
							<tr>
								<td><c:out value="${question.thirdAnswer}" /></td>
								<td><c:out value="${question.fourthAnswer}" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th>答え</th>
					<td>
						<c:if test="${ question.answer == 1 }">&#9312;</c:if>
						<c:if test="${ question.answer == 2 }">&#9313;</c:if>
						<c:if test="${ question.answer == 3 }">&#9314;</c:if>
						<c:if test="${ question.answer == 4 }">&#9315;</c:if>
					</td>
					<th width="15%">あなたの解答</th>
					<td width="35%">
						<c:if test="${ question.answerResult == 1 }">&#9312;</c:if>
						<c:if test="${ question.answerResult == 2 }">&#9313;</c:if>
						<c:if test="${ question.answerResult == 3 }">&#9314;</c:if>
						<c:if test="${ question.answerResult == 4 }">&#9315;</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="4"	style="padding:0;">
						<div class="wrapper">
							<div class="container" style="padding:0;">
								<div class="accordion" id="accordionExample">
									<div class="card" style="text-align: center;">
										<div class="card-header" id="heading${question.id}">
											<h2 class="mb-0" style="font-size: 1.5em;">
												<button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapse${question.id}" aria-expanded="false" aria-controls="collapse${question.id}">↓↓&nbsp;解説&nbsp;↓↓</button>
											</h2>
										</div>
										<div id="collapse${question.id}" class="collapse" aria-labelledby="heading${question.id}" data-parent="#accordionExample">
											<div class="card-body"><c:out value="${ question.explanation }" /></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
	
<!-- bootstrap用 -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>