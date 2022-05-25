package com.shop.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shop.common.Shop_BoardVO;
import com.shop.common.Shop_MemberVO;

class VOtest {
	private Shop_BoardVO bvo;
	private Shop_MemberVO mvo;
	private String data1 = "여기는 제목";
	private String data2 = "admin"; 
	
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
		System.out.println("test start");
		bvo = new Shop_BoardVO();
		mvo = new Shop_MemberVO();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("test end");
	}

	@Test
	void VOtest1() {
		bvo.setTit("여기는 제목");
		System.out.println("데이터 : "+bvo.getTit());
		assertEquals(data1, bvo.getTit());
		fail("VOtest1 fail");
	}
	@Test
	void VOtest2() {
		mvo.setMid("admin");
		System.out.println("데이터 : "+mvo.getMid());
		assertEquals(data2, mvo.getMid());
		fail("VOtest2 fail");
	}

}
