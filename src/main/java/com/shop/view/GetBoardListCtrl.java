package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Shop_BoardVO;
import com.shop.model.BoardDAO;


@WebServlet("/GetBoardListCtrl")
public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetBoardListCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO DAO = new BoardDAO();
		ArrayList<Shop_BoardVO> Volist = DAO.getBoardList();
		request.setAttribute("BoardVolist", Volist);
		RequestDispatcher view = request.getRequestDispatcher("./board/BoardList.jsp");
		view.forward(request, response);
	}

}
