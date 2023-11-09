package dbAccess;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.UserDto;

/**
 * DBAccessインターフェースを実装する検索クラス<br>
 * DBからパラメータに受取った商品コードの商品を一件のみ検索する<br>
 */
public class SelectPass implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		
		ItemDao dao = null;
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			dao = new ItemDao();
			UserDto dto = dao.getUser(id);
			request.setAttribute("user", dto);
		}finally {
			if(dao != null) dao.close();
		}
	}

}