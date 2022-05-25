package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.JDBCConnection;
import com.shop.common.Shop_BoardVO;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	
	/////////////////////////////////////////////
	public ArrayList<Shop_BoardVO> getBoardList(){
		ArrayList<Shop_BoardVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from shop_board order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Shop_BoardVO>();
			while(rs.next()) {
				Shop_BoardVO vo = new Shop_BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTit(rs.getString("tit"));
				vo.setCon(rs.getString("con"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setViewed(rs.getInt("viewed"));
				vo.setThumb(rs.getInt("thumb"));
				vo.setLock_post(rs.getInt("lock_post"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	/////////////////////////////////////////////
	public Shop_BoardVO getBoard(int no) {
		Shop_BoardVO vo = new Shop_BoardVO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from shop_board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNo(rs.getInt("no"));
				vo.setTit(rs.getString("tit"));
				vo.setCon(rs.getString("con"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setViewed(rs.getInt("viewed"));
				vo.setThumb(rs.getInt("thumb"));
				vo.setLock_post(rs.getInt("lock_post"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return vo;
	}
	/////////////////////////////////////////////
	public int addBoard(Shop_BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into shop_board values("
					+ "(select nvl(max(no),0)+1 from shop_board),"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "sysdate,"
					+ "0,"
					+ "0,"
					+ "?"
					+ ")";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTit());
			pstmt.setString(2, vo.getCon());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getLock_post());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	/////////////////////////////////////////////
	public int editBoard(Shop_BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update shop_board set "
					+ "tit=?,"
					+ "con=?,"
					+ "regdate=sysdate,"
					+ "lock_post=?"
					+ " where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTit());
			pstmt.setString(2, vo.getCon());
			pstmt.setInt(3, vo.getLock_post());
			pstmt.setInt(4, vo.getNo());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}	
	/////////////////////////////////////////////
	public int delBoard(Shop_BoardVO vo) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from shop_board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}		
	/////////////////////////////////////////////////
	public ArrayList<Shop_BoardVO> getBoardSearch(String s_type,String s_txt){
		ArrayList<Shop_BoardVO> list = null;
		try {
			conn = JDBCConnection.getConnection();
			if(s_type.equals("tit")) {
			sql = "select * from shop_board where tit like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+s_txt+"%");
			}else {
			sql = "select * from shop_board where con like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+s_txt+"%");
			}
			rs = pstmt.executeQuery();
			list = new ArrayList<Shop_BoardVO>();
			while(rs.next()) {
				Shop_BoardVO vo = new Shop_BoardVO();
				vo.setNo(rs.getInt("no"));
				vo.setTit(rs.getString("tit"));
				vo.setCon(rs.getString("con"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setViewed(rs.getInt("viewed"));
				vo.setThumb(rs.getInt("thumb"));
				vo.setLock_post(rs.getInt("lock_post"));
				list.add(vo);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return list;
	}
	/////////////////////////////////////////////////
}
