package com.min.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.biz.member.MemberService;
import com.min.biz.member.MemberVO;
// Component를 상속받은 어노테이션이다.
@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	// 의존성주입
	@Autowired // 이름으로 찾는것이 아닌 타입으로 찾는 것이다. MemberDAO타입의 객체가 메모리에 있어야만 한다.
	private MemberDAO2 memberDAO; // 핵심로직을 수행할 객체
	

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public MemberVO selectOneMember(MemberVO vo) {
		if(vo.getMid().equals("timo")) {
			throw new IllegalArgumentException("[실행 시 예외]");
		}
		return memberDAO.selectOneMember(vo);
	}

	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return memberDAO.selectAllMember(vo);
	}

}
