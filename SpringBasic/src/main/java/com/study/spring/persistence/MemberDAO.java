package com.study.spring.persistence;

import java.util.List;

import com.study.spring.domain.MemberVO;

public interface MemberDAO {
	public String getNow();
	public void insertMember(MemberVO vo);
	public MemberVO get(String user_id);
	public List<MemberVO> getList();
	public void delete(String user_id);
	public void update(MemberVO vo);
}
