package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.Shop_MemberVO;
import com.shop.model.MemberDAO;


@WebServlet("/LoginMemberCtrl")
public class LoginMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginMemberCtrl() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		MemberDAO DAO = new MemberDAO();
		String l_id = request.getParameter("l_id");
		String l_pw = request.getParameter("l_pw");
		Shop_MemberVO Vo = DAO.loginMember(l_id, l_pw);
		String log = Vo.getMid();
		if(log != null) {
			session.setAttribute("sid", Vo.getMid());
			session.setAttribute("sname", Vo.getMname());
			session.setAttribute("snick", Vo.getMnick());
			out.println("<script>"
					+ "alert('로그인성공');"
					+ "location.href='./index.jsp';"
					+ "</script>");
		} else {
			out.println("<script>"
					+ "alert('로그인실패');"
					+ "history.back();;"
					+ "</script>");
		}
		
		
	}

}
