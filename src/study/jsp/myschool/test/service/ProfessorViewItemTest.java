package study.jsp.myschool.test.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Professor;
import study.jsp.myschool.service.ProfessorService;
import study.jsp.myschool.service.impl.ProfessorServiceImpl;

public class ProfessorViewItemTest {
	public static void main(String[] args) {
		/** (1) 조회할 데이터 준비하기 */
		// --> import study.jsp.myschool.model.Professor;
		Professor professor = new Professor();
		professor.setProfno(9908);
		
		/** (2) Service 객체 생성하기 --> DB접속 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(ProfessorViewItemTest.class.getName());
		// --> import study.jsp.myschool.model.Professor;
		// --> import study.jsp.myschool.service.ProfessorService;
		ProfessorService professorService = new ProfessorServiceImpl(sqlSession, logger);
		
		/** (3) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		Professor item = null;
		try {
			item = professorService.getProfessorItem(professor);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return;
		} finally {
			sqlSession.close();
		}
		
		/** (4) 결과 표시하기 */
		System.out.println(item.toString());
	}
}
