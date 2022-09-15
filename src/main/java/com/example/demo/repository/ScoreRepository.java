package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Score;


/**
 * 
 * スコア情報取得リポジトリ
 * 
 * @author sy199
 *
 */
public interface ScoreRepository {

	/**
	 * スコア情報登録処理
	 * 
	 * @param score スコアモデル
	 */
	void insertScore(Score score);
	
	/**
	 * 全スコア情報リスト取得
	 * 
	 * @return 全スコア情報
	 */
	List<Score> allScore();
	
	/**
	 * 全ユーザースコア情報取得
	 * 
	 * @param score スコアモデル
	 * @return 全ユーザースコア情報
	 */
	List<Score> userScore(Score score);
	
}
