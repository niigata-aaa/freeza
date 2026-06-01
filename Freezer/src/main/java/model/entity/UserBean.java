package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable{

	/**
	 * ユーザID
	 */
	private String UserId;
	
	/**
	 * パスワード
	 */
	private String PassWord;
	
    /**
	 * UserBeanを構築します。
	 */
	public UserBean() {
		
	}
	
	/**
	 * フィールドuseridの値を返します。
	 * @return ユーザID
	 */
	public String getUserId() {
		return UserId;
	}
	
	/**
	 * フィールドUserIdの値を設定します。
	 * @param userid ユーザID
	 */
	public void setUserId(String UserId) {
		this.UserId= UserId;
	}
	
	/**
	 * フィールドPassWordの値を返します。
	 * @return パスワード
	 */
	public String getPassWord() {
		return PassWord;
	}
	
	/**
	 * フィールドPassWordの値を設定します。
	 * @param PassWord パスワード
	 */
	public void setPassWord(String PassWord) {
		this.PassWord = PassWord;
	}

}
