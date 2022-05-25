package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_MemberVO;
import com.shop.model.MemberDAO;

/**
 * Servlet implementation class JoinMember
 */
@WebServlet("/JoinMemberCtrl")
public class JoinMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinMemberCtrl() {
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
		PrintWriter out = response.getWriter();
		MemberDAO DAO = new MemberDAO();
		Shop_MemberVO Vo = new Shop_MemberVO();
		String j_id = request.getParameter("j_id");
		String j_pw = request.getParameter("j_pw");
		String j_name = request.getParameter("j_name");
		String j_nick = request.getParameter("j_nick");
		String j_tel = request.getParameter("j_tel");
		String j_address = request.getParameter("j_address");
		String j_address2 = request.getParameter("j_address2");
		j_address = j_address +" "+ j_address2;
		String j_email = request.getParameter("j_email");
		int j_cash = Integer.parseInt(request.getParameter("j_cash"));
		int j_point = Integer.parseInt(request.getParameter("j_point"));
		int j_grade = Integer.parseInt(request.getParameter("j_grade"));

		Vo.setMid(j_id);
		Vo.setMpw(j_pw);
		Vo.setMname(j_name);
		Vo.setMnick(j_nick);
		Vo.setMtel(j_tel);
		Vo.setMaddress(j_address);
		Vo.setMemail(j_email);
		Vo.setMcash(j_cash);
		Vo.setMpoint(j_point);
		Vo.setMgrade(j_grade);
		
		if (DAO.joinMember(Vo) > 0) {
		out.println("<script>"
				+ "alert('가입성공!');"
				+ "location.href='index.jsp';"
				+ "</script>");
		}
		
	}

}
