package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Question;

/**
 * クエッション情報取得レポジトリ
 * 
 * @author sy199
 *
 */
public interface QuestionRepository {

	/**
	 * 全クエッション情報取得処理
	 * 
	 * @return 全クエッション情報
	 */
	List<Question> allQuestion();
	
	/**
	 * クエッション情報取得処理
	 * 
	 * @param クエッションid
	 * @return クエッション情報
	 */
	Question selectQuestion(int id);
	
	/**
	 * 解答登録処理
	 * 
	 * @param question クエッションモデル
	 */
	void addAnswer(Question nowQuestion);
	
	/**
	 * 解答情報集計処理
	 * 
	 * @return 全クエッション情報
	 */
	List<Question> countAnswer();
}
