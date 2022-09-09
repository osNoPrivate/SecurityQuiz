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
		
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題1</th>
				<td width="90%" colspan="3">
					<c:if test="${ question1.judge == 1 }">正解</c:if>
					<c:if test="${ question1.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question1.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question1.firstAnswer}" /></td>
							<td><c:out value="${question1.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question1.thirdAnswer}" /></td>
							<td><c:out value="${question1.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question1.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question1.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question1.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question1.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question1.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question1.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question1.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question1.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target1" aria-expand="false" aria-controls="#target1">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target1">
							<c:out value="${ question1.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題2</th>
				<td width="90%" colspan="3">
					<c:if test="${ question2.judge == 1 }">正解</c:if>
					<c:if test="${ question2.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question2.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question2.firstAnswer}" /></td>
							<td><c:out value="${question2.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question2.thirdAnswer}" /></td>
							<td><c:out value="${question2.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question2.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question2.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question2.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question2.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question2.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question2.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question2.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question2.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target2" aria-expand="false" aria-controls="#target2">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target2">
							<c:out value="${ question2.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題3</th>
				<td width="90%" colspan="3">
					<c:if test="${ question3.judge == 1 }">正解</c:if>
					<c:if test="${ question3.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question3.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question3.firstAnswer}" /></td>
							<td><c:out value="${question3.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question3.thirdAnswer}" /></td>
							<td><c:out value="${question3.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question3.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question3.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question3.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question3.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question3.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question3.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question3.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question3.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target3" aria-expand="false" aria-controls="#target3">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target3">
							<c:out value="${ question3.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題4</th>
				<td width="90%" colspan="3">
					<c:if test="${ question4.judge == 1 }">正解</c:if>
					<c:if test="${ question4.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question4.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question4.firstAnswer}" /></td>
							<td><c:out value="${question4.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question4.thirdAnswer}" /></td>
							<td><c:out value="${question4.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question4.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question4.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question4.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question4.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question4.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question4.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question4.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question4.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target4" aria-expand="false" aria-controls="#target4">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target4">
							<c:out value="${ question4.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題5</th>
				<td width="90%" colspan="3">
					<c:if test="${ question5.judge == 1 }">正解</c:if>
					<c:if test="${ question5.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question5.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question5.firstAnswer}" /></td>
							<td><c:out value="${question5.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question5.thirdAnswer}" /></td>
							<td><c:out value="${question5.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question5.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question5.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question5.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question5.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question5.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question5.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question5.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question5.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target5" aria-expand="false" aria-controls="#target5">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target5">
							<c:out value="${ question5.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題6</th>
				<td width="90%" colspan="3">
					<c:if test="${ question6.judge == 1 }">正解</c:if>
					<c:if test="${ question6.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question6.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question6.firstAnswer}" /></td>
							<td><c:out value="${question6.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question6.thirdAnswer}" /></td>
							<td><c:out value="${question6.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question6.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question6.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question6.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question6.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question6.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question6.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question6.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question6.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target6" aria-expand="false" aria-controls="#target6">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target1">
							<c:out value="${ question6.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題7</th>
				<td width="90%" colspan="3">
					<c:if test="${ question7.judge == 1 }">正解</c:if>
					<c:if test="${ question7.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question7.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question7.firstAnswer}" /></td>
							<td><c:out value="${question7.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question7.thirdAnswer}" /></td>
							<td><c:out value="${question7.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question7.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question7.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question7.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question7.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question7.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question7.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question7.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question7.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target7" aria-expand="false" aria-controls="#target7">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target7">
							<c:out value="${ question7.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題8</th>
				<td width="90%" colspan="3">
					<c:if test="${ question8.judge == 1 }">正解</c:if>
					<c:if test="${ question8.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question8.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question8.firstAnswer}" /></td>
							<td><c:out value="${question8.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question8.thirdAnswer}" /></td>
							<td><c:out value="${question8.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question8.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question8.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question8.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question8.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question8.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question8.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question8.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question8.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target8" aria-expand="false" aria-controls="#target8">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target8">
							<c:out value="${ question8.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題9</th>
				<td width="90%" colspan="3">
					<c:if test="${ question9.judge == 1 }">正解</c:if>
					<c:if test="${ question9.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question9.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question9.firstAnswer}" /></td>
							<td><c:out value="${question9.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question9.thirdAnswer}" /></td>
							<td><c:out value="${question9.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question9.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question9.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question9.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question9.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question9.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question9.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question9.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question9.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target9" aria-expand="false" aria-controls="#target9">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target9">
							<c:out value="${ question9.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="result-area" border="1" >
			<tr>
				<th width="10%">問題10</th>
				<td width="90%" colspan="3">
					<c:if test="${ question10.judge == 1 }">正解</c:if>
					<c:if test="${ question10.judge != 1 }"><font color="red">不正解</font></c:if>
				</td>
			</tr>
			<tr>
				<th>問題文</th>
				<td colspan="3">
					<c:out value="${ question10.question }" />
				</td>
			</tr>
			<tr>
				<th>選択肢</th>
				<td colspan="3">
					<table class="answer">
						<tr>
							<td><c:out value="${question10.firstAnswer}" /></td>
							<td><c:out value="${question10.secondAnswer}" /></td>
						</tr>
						<tr>
							<td><c:out value="${question10.thirdAnswer}" /></td>
							<td><c:out value="${question10.fourthAnswer}" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th>答え</th>
				<td>
					<c:if test="${ question10.answer == 1 }">&#9312;</c:if>
					<c:if test="${ question10.answer == 2 }">&#9313;</c:if>
					<c:if test="${ question10.answer == 3 }">&#9314;</c:if>
					<c:if test="${ question10.answer == 4 }">&#9315;</c:if>
				</td>
				<th width="15%">あなたの解答</th>
				<td width="35%">
					<c:if test="${ question10.answerResult == 1 }">&#9312;</c:if>
					<c:if test="${ question10.answerResult == 2 }">&#9313;</c:if>
					<c:if test="${ question10.answerResult == 3 }">&#9314;</c:if>
					<c:if test="${ question10.answerResult == 4 }">&#9315;</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4"	>
					<div class="accordion">
						<div align="center" class="parent" data-toggle="collapse" data-target="#target10" aria-expand="false" aria-controls="#target10">↓&nbsp;解説&nbsp;↓</div>
						<div class="child collapse" id="target10">
							<c:out value="${ question10.explanation }" />
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	
<!-- bootstrap用 -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>