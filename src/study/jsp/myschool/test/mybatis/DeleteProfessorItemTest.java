package study.jsp.myschool.test.mybatis;

import org.apache.ibatis.session.SqlSession;

import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Professor;

public class DeleteProfessorItemTest {
	public static void main(String[] args) {
		
		/** (1) 데이터베이스 접속처리 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

		/** (2)삭제할 교수의 일련번호를 저장하고 있는 JavaBeans 객체 */
		// --> import study.jsp.myschool.model.Professor;
		Professor professor = new Professor();
		professor.setProfno(9913);

		/** (3) 데이터 삭제 기능 호출하기 + 트렌젝션 */
		try {
			// ProfessorMapper.deleteProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 삭제할 데이터를 담고 있는 Beans객체
			int result = sqlSession.delete("ProfessorMapper.deleteProfessorItem", professor);
			
			// 삭제된 행의 수가 없는 경우 강제로 예외를 발생시킨다.
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();	// SQL 수행 내역을 되돌림
			System.out.println("삭제된 데이터가 없습니다.");
			return;
		} catch (Exception e) {
			sqlSession.rollback();	// SQL 수행 내역을 되돌림
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 삭제에 실패했습니다.");
			return;
		} finally {
			sqlSession.commit();	// 실제 반영을 위해서 commit
			sqlSession.close();		// 데이터베이스 접속 해제
		}

		/** (4) 결과 출력하기 */
		System.out.println("삭제되었습니다.");
		
	}
}
