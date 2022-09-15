package com.example.demo.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Score;

/**
 * スコアマッパー
 * 
 * @author sy199
 *
 */
@Mapper
public interface ScoreMapper {
	
	/**
	 * スコア情報登録処理
	 * 
	 * @param score スコアモデル
	 */
	void insertScore(Score score);
	
	/**
	 * 全スコア情報取得
	 * 
	 *  @return 全スコア情報
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
