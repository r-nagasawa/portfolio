package dbAccess;

import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.UserDto;



public class UpdatePass implements DBAccess {
	
	public void execute(HttpServletRequest request) throws SQLException{
		ItemDao dao = null;
		int n = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
			request.setAttribute("message", "入力が不正です");
			return;
		}
		
		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setPass(pass);
		
		try {
			dao = new ItemDao();
			n = dao.update(dto);
			
			if( n > 0 ) {
				request.setAttribute("message", "パスワードの変更が完了しました");
			}else {
				request.setAttribute("message", "パスワードの変更に失敗しました");
			}
		}finally {
			if(dao != null) dao.close();
		}
	}
}