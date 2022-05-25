package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_BoardVO;
import com.shop.model.BoardDAO;

/**
 * Servlet implementation class AddBoardCtrl
 */
@WebServlet("/AddBoardCtrl")
public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoardCtrl() {
        super();

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		String tit = request.getParameter("tit");
		String con = request.getParameter("con");
		String writer = request.getParameter("writer");
		int lock_post = Integer.parseInt(request.getParameter("lock_post"));
		PrintWriter out = response.getWriter();
		BoardDAO DAO = new BoardDAO();
		Shop_BoardVO Vo = new Shop_BoardVO();
		Vo.setTit(tit);
		Vo.setCon(con);
		Vo.setWriter(writer);
		Vo.setLock_post(lock_post);
		
		if ((DAO.addBoard(Vo) > 0)){
			//글쓰기 성공
			out.println("<script>alert('등록성공');</script>");
			out.println("<script>window.close();</script>");
		} else {
			//글쓰기 실패
			out.println("<script>alert('등록실패');</script>");
			out.println("<script>window.close();</script>");
		}
		
		
		
		
	}

}
