package dbAccess;

import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
//import dto.ItemDto;
//import filter.Judge;

public class DeleteItem implements DBAccess {
	
	public void execute(HttpServletRequest request) throws SQLException{
		ItemDao dao = null;
		int n = 0;
		int code = Integer.parseInt(request.getParameter("code"));
		
		try {
			dao = new ItemDao();
			n = dao.delete(code);
			
			if(n > 0) {
				request.setAttribute("message", "商品の削除が完了しました");
			}else {
				request.setAttribute("message", "商品の削除に失敗しました");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
	
}