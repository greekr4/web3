package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.MemberDAO;

/**
 * Servlet implementation class DelMemberCtrl
 */
@WebServlet("/DelMemberCtrl")
public class DelMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMemberCtrl() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		String uid = request.getParameter("uid");
		MemberDAO DAO = new MemberDAO();
		if(DAO.delMember(uid) > 0) {
			if(sid.equals("admin")) {
			out.println("<script>alert('삭제완료');location.href='GetMemberListCtrl';</script>");
			}else {
			session.invalidate();
			response.sendRedirect("index.jsp");
			out.println("<script>alert('탈퇴완료');location.href='index.jsp';</script>");
			
			}
		}else {
			out.println("<script>alert('탈퇴실패');history.back();</script>");
		}
	}

}
