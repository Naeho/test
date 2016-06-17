package com.study.spring.persistance;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.spring.domain.MemberVO;
import com.study.spring.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOImplTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void test() { System.out.println("Test DAO = " + dao);}
	
	@Test
	public void getNowTest() { System.out.println("Test DAO now = " + dao.getNow());}
	
	@Test
	public void insertTest() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUser_id("id"+System.currentTimeMillis());
		vo.setUser_name("나라네");
		vo.setPw("패스워드라네");
		vo.setEmail("asa5861@naver.com");
		
		dao.insertMember(vo);
		
	}
	@Test
	public void getTest() throws Exception {
		MemberVO vo = dao.get("aaa");
		System.out.println("이메일 : " + vo.getEmail());
	}
	@Test
	public void getTestList() throws Exception {
		List<MemberVO> list = dao.getList();
		Iterator<MemberVO> it = list.iterator();
		while(it.hasNext()){
			MemberVO vo = it.next();
			System.out.println("비밀번호:"+vo.getEmail());
		}
	}
	@Test
	public void update() throws Exception{
		MemberVO vo = new MemberVO();
		vo = dao.get("aaa");
		vo.setUser_name("수정수정");
		vo.setPw("modify");
		
		dao.update(vo);
		
	}
	@Test
	public void delete() throws Exception{
			
		dao.delete("id1464757540340");
		
	}
	

	
}
