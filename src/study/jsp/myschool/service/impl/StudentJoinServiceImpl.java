package study.jsp.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import study.jsp.myschool.model.StudentDepartment;
import study.jsp.myschool.service.StudentJoinService;

public class StudentJoinServiceImpl implements StudentJoinService {

	Logger logger;

	SqlSession sqlSession;

	public StudentJoinServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public StudentDepartment getStudentJoinItem(StudentDepartment student) throws Exception {
		StudentDepartment result = null;
		try {
			result = sqlSession.selectOne("StudentJoinMapper.selectStudentJoinItem", student);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public List<StudentDepartment> getStudentJoinList(StudentDepartment student) throws Exception {
		List<StudentDepartment> result = null;

		try {
			result = sqlSession.selectList("StudentJoinMapper.selectStudentJoinList", student);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 데이터가 없습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}

	@Override
	public int getStudentCount(StudentDepartment student) throws Exception {
		int result = 0;

		try {
			result = sqlSession.selectOne("StudentJoinMapper.selectStudentCount", student);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("데이터 조회에 실패했습니다.");
		}

		return result;
	}
}
