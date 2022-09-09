package com.example.demo.entity;

public class Question {

	private Integer id;
	private String question;
	private String firstAnswer;
	private String secondAnswer;
	private String thirdAnswer;
	private String fourthAnswer;
	private String answerText;
	private Integer answer;
	private String explanation;
	private Integer answerResult;
	private Integer judge;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getFirstAnswer() {
		return firstAnswer;
	}
	public void setFirstAnswer(String firstAnswer) {
		this.firstAnswer = firstAnswer;
	}
	public String getSecondAnswer() {
		return secondAnswer;
	}
	public void setSecondAnswer(String secondAnswer) {
		this.secondAnswer = secondAnswer;
	}
	public String getThirdAnswer() {
		return thirdAnswer;
	}
	public void setThirdAnswer(String thirdAnswer) {
		this.thirdAnswer = thirdAnswer;
	}
	public String getFourthAnswer() {
		return fourthAnswer;
	}
	public void setFourthAnswer(String fourthAnswer) {
		this.fourthAnswer = fourthAnswer;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public Integer getAnswerResult() {
		return answerResult;
	}
	public void setAnswerResult(Integer answerResult) {
		this.answerResult = answerResult;
	}
	public Integer getJudge() {
		return judge;
	}
	public void setJudge(Integer judge) {
		this.judge = judge;
	}
}
