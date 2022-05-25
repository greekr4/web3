package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_BoardVO;
import com.shop.model.BoardDAO;

/**
 * Servlet implementation class DelBoardCtrl
 */
@WebServlet("/DelBoardCtrl")
public class DelBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelBoardCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		PrintWriter out = response.getWriter();
		BoardDAO DAO = new BoardDAO();
		Shop_BoardVO Vo = new Shop_BoardVO();
		Vo.setNo(no);
		if ((DAO.delBoard(Vo) > 0)){
			//글쓰기 성공
			out.println("<script>alert('삭제성공');</script>");
			out.println("<script>location.href='GetBoardListCtrl';</script>");
		} else {
			//글쓰기 실패
			out.println("<script>alert('삭제실패');</script>");
			out.println("<script>location.href='GetBoardListCtrl';</script>");
		}	
		
		
	}

}
