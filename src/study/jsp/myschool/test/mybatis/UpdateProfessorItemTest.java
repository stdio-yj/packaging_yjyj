package study.jsp.myschool.test.mybatis;

import org.apache.ibatis.session.SqlSession;

import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Professor;

public class UpdateProfessorItemTest {
	public static void main(String[] args) {
		
		/** (1) 데이터베이스 접속처리 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

		/** (2) 수정할 교수의 정보를 저장하고 있는 JavaBeans객체 */
		// --> import study.jsp.myschool.model.Professor;
		Professor professor = new Professor();
		professor.setProfno(9903);
		professor.setName("왕교수");
		professor.setUserid("kingprof");
		professor.setPosition("교수");
		professor.setSal(550);
		professor.setComm(50);
		professor.setHiredate("2016-05-20");
		professor.setDeptno(102);

		/** (3) 데이터 저장 기능 호출하기 + 트렌젝션 */
		try {
			// ProfessorMapper.updateProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 수정할 데이터를 담고 있는 Beans객체
			int result = sqlSession.update("ProfessorMapper.updateProfessorItem", professor);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			sqlSession.rollback();
			System.out.println("수정된 데이터가 없습니다.");
			return;
		} catch (Exception e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			sqlSession.rollback();
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 수정에 실패했습니다.");
			return;
		} finally {
			// 입력,수정,삭제 처리의 경우 실제 반영을 위해서 commit 필요함
			sqlSession.commit();
			// 데이터베이스 접속 해제
			sqlSession.close();
		}

		/** (4) 결과 출력하기 */
		System.out.println("수정되었습니다.");
	}
}
