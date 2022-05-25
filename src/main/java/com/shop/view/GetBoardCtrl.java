package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_BoardVO;
import com.shop.model.BoardDAO;

/**
 * Servlet implementation class GetBoardCtrl
 */
@WebServlet("/GetBoardCtrl")
public class GetBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBoardCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO DAO = new BoardDAO();
		Shop_BoardVO Vo = DAO.getBoard(no);
		request.setAttribute("BoardVo", Vo);
		RequestDispatcher view = request.getRequestDispatcher("./board/Board.jsp");
		view.forward(request, response);
	}

}
