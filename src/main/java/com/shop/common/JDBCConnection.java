package com.shop.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class JDBCConnection {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(url,"SCOTT","TIGER");
		return conn;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn)	{
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(PreparedStatement pstmt, Connection conn)	{
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}
