package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.ReplyVO;
import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOImplTest {
	@Inject
	private ReplyDAO dao;
	
	@Test
	public void insert() throws Exception{
			ReplyVO vo = new ReplyVO();
			vo.setUser_name("이름");
			vo.setContent("내용");
			vo.setBoard_no(9);
			dao.insert(vo);
		}
	@Test
	public void get() throws Exception{
		ReplyVO vo = dao.get(1);
			System.out.println("이름 : " + vo.getUser_name());
		}
	@Test
	public void getList() throws Exception{
			RestVO rvo = new RestVO();
			List<ReplyVO> list = dao.getList(rvo.getBoard_no());
			Iterator<ReplyVO> it = list.iterator();
			while(it.hasNext()){
				ReplyVO vo = it.next();
				System.out.println("이름들 : " + vo.getUser_name());
			}
		}
	@Test
	public void update() throws Exception{
		ReplyVO vo = new ReplyVO();
			vo.setReply_no(0);
			vo.setContent("내용1");
			vo.setUser_name("이름1");
			dao.update(vo);
		}
	@Test
	public void delete() throws Exception{
			dao.delete(2);
		}
}
