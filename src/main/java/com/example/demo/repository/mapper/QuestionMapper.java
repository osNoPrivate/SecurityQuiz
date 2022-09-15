package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Question;

/**
 * クエッションマッパー
 * 
 * @author sy199
 *
 */
@Mapper
public interface QuestionMapper {
	
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
