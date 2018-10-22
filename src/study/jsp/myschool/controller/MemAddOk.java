package study.jsp.myschool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import study.jsp.helper.BaseController;
import study.jsp.helper.WebHelper;
import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Member;
import study.jsp.myschool.service.MemberService;
import study.jsp.myschool.service.impl.MemberServiceImpl;

@WebServlet("/mem_add_ok.do")
public class MemAddOk extends BaseController {

	private static final long serialVersionUID = 2075397727835591630L;
	WebHelper web;
	SqlSession sqlSession;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		String name = web.getString("name");
		String userId = web.getString("userId");
		String userPw = web.getString("userPw");
		String email = web.getString("email");
		String gender = web.getString("gender");
		String birthdate = web.getString("birthdate");
		String tel = web.getString("tel");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		String profileImg = web.getString("profileImg");
		String regDate = web.getString("regDate");
		String editDate = web.getString("editDate");

		logger.debug("name=" + name);
		logger.debug("userId=" + userId);
		logger.debug("userPw=" + userPw);
		logger.debug("email=" + email);
		logger.debug("gender=" + gender);
		logger.debug("birthdate=" + birthdate);
		logger.debug("tel=" + tel);
		logger.debug("postcode=" + postcode);
		logger.debug("addr1=" + addr1);
		logger.debug("addr2=" + addr2);
		logger.debug("profileImg=" + profileImg);
		logger.debug("regDate=" + regDate);
		logger.debug("editDate=" + editDate);

		if (name == null) {
			web.redirect(null, "이름을 입력하세요.");
			return null;
		}
		if (userId == null) {
			web.redirect(null, "아이디을 입력하세요.");
			return null;
		}
		if (userPw == null) {
			web.redirect(null, "비밀번호를 입력하세요.");
			return null;
		}
		if (email == null) {
			web.redirect(null, "이메일을 입력하세요.");
			return null;
		}
		if (gender == null) {
			web.redirect(null, "성별을 입력하세요.");
			return null;
		}
		if (birthdate == null) {
			web.redirect(null, "생년월일을 입력하세요.");
			return null;
		}
		if (tel == null) {
			web.redirect(null, "전화번호를 입력하세요.");
			return null;
		}
		if (postcode == null) {
			web.redirect(null, "우편번호를 입력하세요.");
			return null;
		}
		if (addr1 == null) {
			web.redirect(null, "주소를 입력하세요.");
			return null;
		}
		if (addr2 == null) {
			web.redirect(null, "상세주소을 입력하세요.");
			return null;
		}
		if (profileImg == null) {
			web.redirect(null, "프로필사진을 입력하세요.");
			return null;
		}
		if (regDate == null) {
			web.redirect(null, "가입일시를 입력하세요.");
			return null;
		}
		if (editDate == null) {
			web.redirect(null, "변경일시를 입력하세요.");
			return null;
		}

		Member member = new Member();
		member.setName(name);
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setEmail(email);
		member.setGender(gender);
		member.setBirthdate(birthdate);
		member.setTel(tel);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setProfileImg(profileImg);
		member.setRegDate(regDate);
		member.setEditDate(editDate);

		sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberService = new MemberServiceImpl(sqlSession, logger);

		try {
			for (int i=0; i<10; i++) {
				member.setName(name + "(" + i + ")");
				member.setUserId(userId + "(" + i + ")");
				memberService.addMember(member);
			}

		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		String url = request.getContextPath() + "/mem_view.do?id=" + member.getId();
		web.redirect(url, "저장되었습니다.");
		return null;
	}

}
