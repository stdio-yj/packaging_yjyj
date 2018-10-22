package study.jsp.myschool.service;

import java.util.List;

import study.jsp.myschool.model.Member;

/** 회원 관리 기능을 제공하기 위한 Service 계층. */
public interface MemberService {
	
	/**
	 * 회원 등록하기
	 * @param member 저장할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	// --> import study.jsp.myschool.model.Professor;
	public void addMember(Member member) throws Exception;
	
	/**
	 * 회원 수정하기
	 * @param member 수정할 정보를 담고 있는 Beans
	 * @throws Exception
	 */
	public void editMember(Member member) throws Exception;
	
	/**
	 * 회원 삭제하기
	 * @param member 삭제할 교수의 일련번호를 담고 있는 Beans
	 * @throws Exception
	 */
	public void deleteMember(Member member) throws Exception;
	
	/**
	 * 회원 상세 조회
	 * @param member 조회할 교수의 일련번호를 담고 있는 Beans
	 * @return 조회된 데이터가 저장된 Beans
	 * @throws Exception
	 */
	public Member getMemberItem(Member member) throws Exception;
	
	/**
	 * 회원 목록 조회
	 * @return 조회 결과에 대한 컬렉션
	 * @throws Exception
	 */
	// -> import java.util.List;
	public List<Member> getMemberList(Member member) throws Exception;
	
	public int getMemberCount(Member member) throws Exception;
	
}
