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
 * Servlet implementation class GetMemberSearchListCtrl
 */
@WebServlet("/GetMemberSearchListCtrl")
public class GetMemberSearchListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemberSearchListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String s_type = request.getParameter("s_type");
		String s_detail = request.getParameter("s_detail");
		ArrayList<Shop_MemberVO> Volist = new ArrayList<Shop_MemberVO>();
		MemberDAO DAO = new MemberDAO();
		Volist = DAO.getMemberSearch(s_type,s_detail);
		request.setAttribute("MemberList", Volist);
		RequestDispatcher view = request.getRequestDispatcher("./member/MemberList.jsp");
		view.forward(request, response);
	}

}
