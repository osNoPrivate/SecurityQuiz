<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/public/css/style.css" rel="stylesheet" type="text/css">
<title>問題</title>
</head>
<body>

	<div class="header" style="margin:0 20px 0 20px;">
		
		<form action="${pageContext.request.contextPath}/logout/" method="get">
			<input class="logout-button" type="submit" value="ログアウト">
		</form>
		<div class="headerName">SecurityQuiz</div>
				
		<table style="float:right;">
			<tr>
				<td>
					&ensp;&ensp;<c:out value="${loginUser.name}" />&ensp;さん
				</td>
			</tr>
		</table>
	</div>
	
	<div class="main-content">
	<div  style="float:right;">
		<br>
		<div align="right" class="pagenation">
			<c:forEach items="${allQuestionData}" var="questionData">
				<c:if test="${ questionData.answerResult == null }">
					<form:form action="${pageContext.request.contextPath}/pagenation/" modelAttribute="question">
						<input type="hidden" name="id" value="${questionData.id}">
						<input type="submit" class="pagenation" style="color:#CCCCCC; " value="${questionData.id}" >
					</form:form>
				</c:if>
				<c:if test="${ questionData.answerResult != null }">
					<form:form action="${pageContext.request.contextPath}/pagenation/" modelAttribute="question">
						<input type="hidden" name="id" value="${questionData.id}">
						<input type="submit" class="pagenation" style="color:black; " value="${questionData.id}" >
					</form:form>
				</c:if>
			</c:forEach>
		</div>
		
		<table >
				<tr>
					<td align="right" >
						<form action="${pageContext.request.contextPath}/home/" method="get">
							<input type="submit" class="stopQuestion-button" value="解答を中断する">
						</form>
					</td>
				</tr>
				<tr>
					<td align="right">
						<form:form action="${pageContext.request.contextPath}/result/" modelAttribute="question">
							<input type="hidden" name="id" value="${nowQuestion.id}">
							<input type="submit" class="endQuestion-button" value="解答終了">
						</form:form>
					</td>
				</tr>
			</table>
	</div>
		<c:if test="${ not empty validationError }">
			<div class="errorMessages">
				<c:forEach items="${validationError}" var="validationError">
					<font color="red"><c:out value="${validationError}" /></font><br>
				</c:forEach>
			</div>
		</c:if>
		
		<div align="center" class="question-era">
			<table>
				<tr>
					<td>
						<form:form action="${pageContext.request.contextPath}/returnQuestion/" modelAttribute="question">
							<input type="hidden" name="id" value="${nowQuestion.id}">
							<input type="submit" value="<<戻る" style="margin:6px 0 0 0;border: none;font-size: 15px;background-color: #ffffff;cursor: pointer;">
						</form:form>
					</td>
					<td>
						<div class="question-number"><c:out value="問題${nowQuestion.id}" /></div>
					</td>
					<td>
						<form:form action="${pageContext.request.contextPath}/nextQuestion/" modelAttribute="question">
							<input type="hidden" name="id" value="${nowQuestion.id}">
							<input type="submit" value="次へ>>" style="margin:6px 0 0 0;border: none;font-size: 15px;background-color: #ffffff;cursor: pointer;">
						</form:form>
					</td>
				</tr>
			</table>
			<br>
			<c:out value="${nowQuestion.question}" /><br><br>
					
			<form:form action="${pageContext.request.contextPath}/addQuestion/" modelAttribute="question">
				<table class="question-table">
					<tr align="left">	
						<td>
							<input type="radio" name="answerResult"  <c:if test="${nowQuestion.answerResult == 1}">checked</c:if> value=1  required><c:out value="${nowQuestion.firstAnswer }"></c:out><br>
							<input type="radio" name="answerResult"  <c:if test="${nowQuestion.answerResult == 2}">checked</c:if> value=2 ><c:out value="${nowQuestion.secondAnswer }"></c:out><br>
							<input type="radio" name="answerResult"  <c:if test="${nowQuestion.answerResult == 3}">checked</c:if> value=3 ><c:out value="${nowQuestion.thirdAnswer }"></c:out><br>
							<input type="radio" name="answerResult"  <c:if test="${nowQuestion.answerResult == 4}">checked</c:if> value=4 ><c:out value="${nowQuestion.fourthAnswer }"></c:out><br>
							<input type="hidden" name="answer" value="${nowQuestion.answer}">
							<input type="hidden" name="id" value="${nowQuestion.id}">
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" class="answer-button" value="解答">
			</form:form>
		</div>
	</div>
</body>
</html>