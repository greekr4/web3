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
 * Servlet implementation class EditBoardCtrl
 */
@WebServlet("/EditBoardCtrl")
public class EditBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBoardCtrl() {
        super();
        // TODO Auto-generated constructor stub
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
		int no = Integer.parseInt(request.getParameter("no"));
		PrintWriter out = response.getWriter();
		BoardDAO DAO = new BoardDAO();
		Shop_BoardVO Vo = new Shop_BoardVO();
		Vo.setTit(tit);
		Vo.setCon(con);
		Vo.setWriter(writer);
		Vo.setLock_post(lock_post);
		Vo.setNo(no);
		if ((DAO.editBoard(Vo) > 0)){
			//글쓰기 성공
			out.println("<script>alert('수정성공');</script>");
			out.println("<script>location.href='GetBoardListCtrl';</script>");
		} else {
			//글쓰기 실패
			out.println("<script>alert('수정실패');</script>");
			out.println("<script>location.href='GetBoardListCtrl';</script>");
		}	
		
		
		
	}

}
