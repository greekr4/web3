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
 * Servlet implementation class EditMemberCtrl
 */
@WebServlet("/EditMemberCtrl")
public class EditMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberCtrl() {
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
		String my_id = request.getParameter("my_id");
		String my_pw = request.getParameter("my_pw");
		String my_name = request.getParameter("my_name");
		String my_nick = request.getParameter("my_nick");
		String my_tel = request.getParameter("my_tel");
		String my_address = request.getParameter("my_address");
		String my_email = request.getParameter("my_email");
		int my_cash = Integer.parseInt(request.getParameter("my_cash"));
		int my_point = Integer.parseInt(request.getParameter("my_point"));
		int my_grade = Integer.parseInt(request.getParameter("my_grade"));
		Shop_MemberVO Vo = new Shop_MemberVO();
		MemberDAO DAO = new MemberDAO();
		Vo.setMid(my_id);
		Vo.setMpw(my_pw);
		Vo.setMname(my_name);
		Vo.setMnick(my_nick);
		Vo.setMtel(my_tel);
		Vo.setMaddress(my_address);
		Vo.setMemail(my_email);
		Vo.setMcash(my_cash);
		Vo.setMpoint(my_point);
		Vo.setMgrade(my_grade);
		if(DAO.editMember(Vo) > 0) {
			out.println("<script>alert('변경완료');history.back();</script>");
		} else {
			out.println("<script>alert('변경실패');history.back();</script>");
		}

	}

}
