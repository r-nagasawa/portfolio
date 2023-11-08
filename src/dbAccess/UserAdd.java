package dbAccess;

import java.sql.SQLException;
//import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.UserDto;
//import filter.Judge;

public class UserAdd implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {
		ItemDao dao = null;
		int n = 0;
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		if(name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
			UserDto dto = new UserDto();
			dto.setName(name);
			dto.setPass(password);
			
			try {
				dao = new ItemDao();
				boolean check = dao.doubleCheck(name);
				
				if(check) {
				
					n = dao.insert(dto);
					
				}
				
				if(n > 0) {
					request.setAttribute("message", "ユーザー登録が完了しました");
				} else {
					request.setAttribute("message", "ユーザー登録に失敗しました");
					request.setAttribute("message2", "このユーザー名は使用できません");
				}	
				
			}finally {
				if(dao != null) dao.close();
			}
		}else {
			request.setAttribute("message", "入力が不正です");
		}
		
	}
}