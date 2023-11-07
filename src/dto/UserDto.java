package dto;

/**
 * ユーザーデータ保持するクラス<br>
 * データ検索時のデータ管理やデータ登録時の際にも使用され、以下のフィールドを持つ<br>
 * ・ユーザー名<br>
 * ・パスワード<br>
 * @author user
 *
 */
public class UserDto {

	/**
	 * 商品ID
	 */
	String name;
	
	/**
	 * 商品コード
	 */
	String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}
}
