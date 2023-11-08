package dbAccess;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDao;
import dto.UserDto;

public class Profile implements DBAccess {

	@Override
	public void execute(HttpServletRequest request) throws SQLException {

		ItemDao dao = null;
		
		try {
			dao = new ItemDao();
			ArrayList<UserDto> userList = dao.getUserAll();
			if(userList.size() > 0) {
				request.setAttribute("userList", userList);
			}else {
					request.setAttribute("message", "まだデータがありません");
				}
		}finally {
			if(dao != null) dao.close();
		}
	}
}