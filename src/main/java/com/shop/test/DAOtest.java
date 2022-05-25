package com.shop.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.common.Shop_BoardVO;
import com.shop.common.Shop_MemberVO;
import com.shop.model.BoardDAO;
import com.shop.model.MemberDAO;

class DAOtest {
	private BoardDAO dao1;
	private Shop_BoardVO vo1;
	private MemberDAO dao2;
	private Shop_MemberVO vo2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("ins start");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("ins end");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("DAO test start");
		vo1 = new Shop_BoardVO();
		dao1 = new BoardDAO();
		vo1.setTit("제목");
		vo1.setCon("내용");
		vo1.setWriter("작성자");
		vo1.setLock_post(1);

		vo2 = new Shop_MemberVO();
		dao2 = new MemberDAO();
		vo2.setMid("admin");
		vo2.setMpw("1234");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("DAO test end");
	}

	@Test
	void VOtest1() {
		dao1.addBoard(vo1);
		fail("VOtest1 fail");
	}
	@Test
	void VOtest2() {
		dao2.loginMember(vo2.getMid(), vo2.getMpw());
		fail("VOtest2 fail");
	}

}
