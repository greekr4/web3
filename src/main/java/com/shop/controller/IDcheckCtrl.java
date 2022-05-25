package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shop.model.MemberDAO;

/**
 * Servlet implementation class IDcheckCtrl
 */
@WebServlet("/IDcheckCtrl")
public class IDcheckCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDcheckCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			MemberDAO DAO = new MemberDAO();
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; UTF-8");
			PrintWriter out = response.getWriter();
			String c_id = request.getParameter("ck_id");
			if(!c_id.equals("")) {
			int ck = DAO.checkid(c_id);
			if (ck == 1) {
			//중복없음
//				request.setAttribute("c_id", c_id);
//				RequestDispatcher view = request.getRequestDispatcher("./member/idck.jsp");
//				view.forward(request, response);
				//			opener.document.join-form.j_id.readOnly = true; 
				//			window.close();
				out.println(c_id + "는 사용 가능합니다.<br><br>"
						+ "<button onclick='"
						+ "opener.document.getElementById(\"j_id\").readOnly = true;"
						+ "window.close();"
						+ "'>사용하기</button> &nbsp;&nbsp;&nbsp;"
						
						+ "<button onclick='"
						+ "opener.document.getElementById(\"j_id\").readOnly = false;"
						+ "window.close();"
						+ "'>다시입력</button>");
			}else {
			//중복됨
				out.println(c_id + "는 사용 불가능합니다.<br><br>"
						+ "<button onclick='"
						+ "opener.document.getElementById(\"j_id\").readOnly = false;"
						+ "window.close();"
						+ "'>네..</button>");
			}
			}else {
				out.println("아이디를 입력하고 확인해야죠<br><br>"
						+ "<button onclick='"
						+ "opener.document.getElementById(\"j_id\").readOnly = false;"
						+ "window.close();"
						+ "'>네..</button>");
			}
	}

}
