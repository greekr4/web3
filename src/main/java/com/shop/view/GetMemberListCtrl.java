package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_MemberVO;
import com.shop.model.BoardDAO;
import com.shop.model.MemberDAO;

/**
 * Servlet implementation class GetMemberListCtrl
 */
@WebServlet("/GetMemberListCtrl")
public class GetMemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemberListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO DAO = new MemberDAO();
		ArrayList<Shop_MemberVO> Volist = DAO.getMemberList();
		request.setAttribute("MemberList", Volist);
		RequestDispatcher view = request.getRequestDispatcher("./member/MemberList.jsp");
		view.forward(request, response);
	}

}
