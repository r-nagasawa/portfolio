package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbAccess.DBAccess;
import dbAccess.UpdatePass;
import dbAccess.SelectOne;

/**
 * 商品情報編集時に呼び出されるサーブレット<br>
 * ・doGet...編集対象の商品情報をDBから取得し、編集ページに遷移<br>
 * ・doPost...更新処理を呼び出し、結果表示ページに遷移
 */
@WebServlet("/UpdatePassServlet")
public class UpdatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DBAccess dbAccess;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dbAccess = new SelectOne();
		try {
			dbAccess.execute(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/pass.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn").equals("yes")) {
			dbAccess = new UpdatePass();
			try {
				dbAccess.execute(request);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("message", "操作をキャンセルしました");
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/result2.jsp");
		dis.forward(request, response);
	}

}
