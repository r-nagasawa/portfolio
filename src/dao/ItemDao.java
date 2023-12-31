package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import dto.ItemDto;
import dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * DBとの接続、操作、切断を処理するクラス<br>
 * Dao...Data Access Objectの略
 * @author user
 *
 */
public class ItemDao {

	private Connection con;
	private String sql;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<ItemDto> list = null;
	ArrayList<UserDto> Userlist = null;
	
	/**
	 * testdbに接続するためのコンストラクタ
	 * @throws SQLException
	 */
	
	public ItemDao() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/javaexam?serverTimezone=UTC";
		String user = "root";
		String pass = "root";
		
		//DriverManager：一連のJDBCドライバに接続して管理する
		con = DriverManager.getConnection(url, user, pass);
	}
	
	/**
	 * DB接続を切断する
	 */
	public void close() {
		try {
			if(con != null) con.close(); 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public class Response {
		  private final ObjectMapper OM = new ObjectMapper();
		  public void json(HttpServletResponse responce, Object toJson)
		    throws IOException
		  {
			 responce.setContentType("application/json");
			 responce.getWriter().print(
		      OM.writeValueAsString(toJson)
		    );
		  }
		}
	
	
	//登録するユーザーネームが既にあるものかどうか判断する
	public boolean doubleCheck(String name) throws SQLException{
		sql = "select * from user where name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery(); 
			
			
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		}finally {
			ps.close();
		}
	}
	
	public int insert(UserDto dto) throws SQLException{
		sql = "insert into user (name, password)values(?,?)";
		int n = 0;
		
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getName());
				ps.setString(2, dto.getPass());
				n = ps.executeUpdate();
		}finally{
			ps.close();
		}
		return n;
	}
	
	
	/**
	 * ログイン時のデータ照合
	 * @param name 名前
	 * @param pass　パスワード
	 * @return ログイン成功時...1 <br>ログイン失敗時...0
	 * @throws SQLException
	 */

	// getLoginInfoメソッド
	public int getLoginInfo (String name, String pass) throws SQLException{
		
		String sql = "select * from user where name = ? and password = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pass);

		try {
			rs = ps.executeQuery(); 
			rs.next();
			return rs.getRow();
		}finally {
			ps.close();
		}
	} 
	
	/**
	 * DBから全データを抽出する
	 * @return 全データを保持するリスト
	 * @throws SQLException
	 */
	
	// getItemsAllメソッド
	public ArrayList<ItemDto> getItemsAll() throws SQLException {
		String sql = "select * from item";
		ps = con.prepareStatement(sql);
		return search(ps);
	}
	
	public ArrayList<UserDto> getUserAll() throws SQLException {
		String sql = "select * from user";
		ps = con.prepareStatement(sql);
		return userSearch(ps);
	}

	/**
	 * 11/10追記
	 * DBから1レコードを抽出する(nameで検索)
	 * @param name 抽出したいname
	 * @return 該当データ
	 * @throws SQLException
	 */
	public ItemDto getItemName(String name) throws SQLException{
		ItemDao dao = new ItemDao();
		sql = "select * from item where name = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		return search(ps).get(0);
	}
	/**
	 * DBから1レコードを抽出する(商品コードで検索)
	 * @param code 抽出したい商品コード
	 * @return 該当データ
	 * @throws SQLException
	 */
	public ItemDto getItem(int code) throws SQLException{
		
		sql = "select * from item where code = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, code);
		return search(ps).get(0);
	}
	
	public UserDto getUser(int id) throws SQLException{
		
		sql = "select * from user where id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return userSearch(ps).get(0);
	}
	
	/**
	 * DBから名前検索
	 * @param name 商品名
	 * @return 名前検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromName(String name) throws SQLException{
		
		sql = "select * from item where name like ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		return search(ps);
	}
	
	/**
	 * DBからカテゴリ検索
	 * @param category カテゴリ名
	 * @return カテゴリ検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromCategroy(String category) throws SQLException{
		
		sql = "select * from item where category = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, category);
		return search(ps);
	}
	
	/**
	 * DBから範囲指定の値段検索
	 * @param p1 最低値
	 * @param p2 最高値
	 * @return 値段検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsFromPrice(int p1, int p2) throws SQLException{
		
		sql = "select * from item where price between ? and ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, p1);
		ps.setInt(2, p2);
		return search(ps);
	}
	
	/**
	 * DBから10,000円以上の値段検索
	 * @return 検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */
	public ArrayList<ItemDto> getItemsMoreThan10000() throws SQLException{
		sql = "select * from item where price >= 10000";
		ps = con.prepareStatement(sql);
		return search(ps);
	}
	
	/**
	 * select文を実行するメソッド
	 * @param ps パラメータがセットされたSQLを持つオブジェクト
	 * @return 検索にヒットしたデータを持つリスト
	 * @throws SQLException
	 */

	private ArrayList<ItemDto> search(PreparedStatement ps)throws SQLException{
		try {
			rs = ps.executeQuery(); 
			list = new ArrayList<ItemDto>();
			ItemDto dto;
			while(rs.next()) {
				dto = new ItemDto();
				dto.setId(rs.getInt("id"));
				dto.setCode(rs.getInt("code"));
				dto.setName(rs.getString("name"));
				dto.setCategory (parseCategory(rs.getString("category")));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}
		}finally {
			ps.close();
		}
		return list;
	}
	
	private ArrayList<UserDto> userSearch(PreparedStatement ps)throws SQLException{
		try {
			rs = ps.executeQuery(); 
			Userlist = new ArrayList<UserDto>();
			UserDto dto;
			while(rs.next()) {
				dto = new UserDto();
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("password"));
				Userlist.add(dto);
			}
		}finally {
			ps.close();
		}
		return Userlist;
	}
	
	/**
	 * 画面から受け取ったデータをDBに挿入するメソッド
	 * @param dto (パラメータをまとめてもつオブジェクト)
	 * @return 成功件数
	 * @throws SQLException
	 */

	//登録するitemと同じ名前のitemがないかのチェック
	public boolean WCheck(String name) throws SQLException{
		sql = "select * from item where name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery(); 
			
			
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		}finally {
			ps.close();
		}
	}
	
	//insertメソッド
	public int insert(ItemDto dto) throws SQLException{
		sql = "insert into item (code, name, category, price)values(?,?,?,?)";
		int n = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.hashCode());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCategory());
			ps.setInt(4, dto.getPrice());
			n = ps.executeUpdate();
		}finally{
			ps.close();
		}
		return n;
	}
	
	/**
	 * DBへの更新処理
	 * @param dto 既存商品の更新情報を持つオブジェクト
	 * @return 成功件数
	 * @throws SQLException
	 */
	
	// updateメソッド
	public int update(ItemDto dto) throws SQLException {
		sql = "update item set name = ?, category = ?, price= ? where code = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getCategory());
			ps.setInt(3, dto.getPrice());
			ps.setInt(4, dto.getCode());
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		return n;
	}
	
	public int update(UserDto dto) throws SQLException {
		sql = "update user set password = ? where id = ?";
		int n = 0;
		try {
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps = con.prepareStatement(sql);
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		return n;
	}
	
	/**
	 * DBへの削除処理
	 * @param code 商品コード
	 * @return 成功件数
	 * @throws SQLException
	 */

	// deleteメソッド
	public int delete(int code) throws SQLException{
		sql = "delete from item where code = ?";
		int n = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		return n;
	}
	
	/**
	 * カテゴリを変換するメソッド
	 * @param category DB用カテゴリ名
	 * @return 画面用カテゴリ名
	 */
	private String parseCategory(String category) {
		
		String ctgr = null;
		
		switch(category) {
		case "general":
			ctgr = "雑貨";
			break;
		case "electric":
			ctgr = "家電";
			break;
		case "book":
			ctgr = "書籍";
			break;
		case "food":
			ctgr = "食品";
			break;
		case "fashion":
			ctgr = "ファッション";
			break;
		default:
			ctgr = "未分類";	
		}
		
		return ctgr;
	}
}
