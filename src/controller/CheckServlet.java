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

import org.apache.catalina.connector.Response;

import dao.ItemDao;
import dbAccess.DBAccess;
import dbAccess.InsertItem;
import dto.ItemDto;


/**
 * 商品登録時に呼び出されるサーブレット<br>
 * ・doGet...
 * ・doPost...
 */
@WebServlet("/insert")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static DBAccess dbAccess;
	ItemDao dao = new ItemDao();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Response.json(response, dto.getItemName(null));
		/*int id = getId(request);
		String name = request.getParameter("name");
		Response.json(response, dto.setName(name));*/
		
		/*
		 * ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/insert.jsp");
		dis.forward(request, response);
		*/
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    Response.json(response, dto.setName(name));
	    
		

	}
}