package study.jsp.myschool.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Professor;
import study.jsp.myschool.service.ProfessorService;
import study.jsp.myschool.service.impl.ProfessorServiceImpl;

public class ProfessorListTest {
	public static void main(String[] args) {
		/** (1) 조회할 데이터 준비하기 > 여기서는 사용 안함 */
		
		/** (2) Service 객체 생성하기 --> DB접속 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(ProfessorListTest.class.getName());
		// --> import study.jsp.myschool.model.Professor;
		// --> import study.jsp.myschool.service.ProfessorService;
		ProfessorService professorService = new ProfessorServiceImpl(sqlSession, logger);
		
		/** (3) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		List<Professor> list = null;
		try {
			list = professorService.getProfessorList(null);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return;
		} finally {
			sqlSession.close();
		}
		
		/** (4) 결과 표시하기 */
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
