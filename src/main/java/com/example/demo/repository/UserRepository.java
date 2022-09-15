package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

/**
 * ユーザー情報取得処理
 * 
 * @author sy199
 *
 */
public interface UserRepository {

	/**
	 * ユーザー情報登録処理
	 * 
	 * @param user ユーザーモデル
	 */
	void insertUser(User user);
	
	/**
	 * ログインチェック処理
	 * 
	 * @param user ユーザーモデル
	 * @return ユーザー情報
	 */
	User checkUser(User user);
	
	/**
	 * 全ユーザー情報取得処理
	 * 
	 * @return 全ユーザー情報
	 */
	List<User> allUser();
	
	/**
	 * ユーザー情報削除処理
	 * 
	 * @param user ユーザーモデル
	 */
	void deleteUser(User user);
	
	/**
	 * ユーザー情報更新処理
	 * 
	 * @param user ユーザーモデル
	 */
	void updateUser(User user);
	
	/**
	 * パスワード取得処理
	 * 
	 * @param user ユーザーモデル
	 * @return ユーザー情報
	 */
	User selectUser(User user);
}
