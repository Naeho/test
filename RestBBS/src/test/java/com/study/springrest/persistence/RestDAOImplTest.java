package com.study.springrest.persistence;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.springrest.domain.RestVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RestDAOImplTest {
	@Inject
	private RestDAO dao;
	
	@Test
	public void insert() throws Exception{
			RestVO vo = new RestVO();
			vo.setContent("내용");
			vo.setTitle("제목");
			vo.setUser_name("이름");
			dao.insert(vo);
		}
	@Test
	public void get() throws Exception{
		RestVO vo = dao.get(1);
			System.out.println("이름 : " + vo.getUser_name());
		}
	@Test
	public void getList() throws Exception{
			List<RestVO> list = dao.getList();
			Iterator<RestVO> it = list.iterator();
			while(it.hasNext()){
				RestVO vo = it.next();
				System.out.println("이름들 : " + vo.getBoard_no());
			}
		}
	@Test
	public void update() throws Exception{
		RestVO vo = new RestVO();
			vo.setBoard_no(4);
			vo.setContent("내용1");
			vo.setTitle("제목1");
			vo.setUser_name("이름1");
			dao.update(vo);
		}
	@Test
	public void delete() throws Exception{
			dao.delete(2);
		}
}
