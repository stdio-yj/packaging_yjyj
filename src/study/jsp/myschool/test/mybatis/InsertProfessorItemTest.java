package study.jsp.myschool.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Professor;

public class InsertProfessorItemTest {
	public static void main(String[] args) {
		
		/** (1) 데이터베이스 접속처리 */
		// --> import org.apache.ibatis.session.SqlSession;
		// --> import study.jsp.myschool.dao.MyBatisConnectionFactory;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		
		/** (2) 데이터베이스에 저장할 교수의 정보를 저장하고 있는 JavaBeans객체 */
		// --> import study.jsp.myschool.model.Professor;
		Professor professor = new Professor();
		professor.setName("야옹이");
		professor.setUserid("yaongi");
		professor.setPosition("교수");
		professor.setSal(450);
		professor.setComm(0);
		professor.setHiredate("2015-01-02");
		// Professor 테이블의 deptno 컬럼은 Department 테이블의 deptno를 참조하기 때문에
		// department 테이블에 저장되어 있지 않은 값을 설정할 경우 에러가 발생한다.
		professor.setDeptno(101);
		
		/** (3) 데이터 저장 기능 호출하기 + 트렌젝션 */
		try {
			// ProfessorMapper.updateProfessorItem 기능을 호출한다.
			// 두 번째 파라미터는 저장할 데이터를 담고 있는 Beans객체
			int result = sqlSession.insert("ProfessorMapper.insertProfessorItem", professor);
			
			// 리턴값은 저장된 행의 수
			if (result == 0) {
				// 저장된 행이 없다면 강제로 예외를 발생시킨다.
				// --> 이 예외를 처리 가능한 catch블록으로 제어가 이동한다.
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			sqlSession.rollback();
			System.out.println("저장된 데이터가 없습니다.");
			return;
		} catch (Exception e) {
			// 에러가 발생했으므로 SQL 수행 내역을 되돌림
			sqlSession.rollback();
			System.out.println(e.getLocalizedMessage());
			System.out.println("데이터 저장에 실패했습니다.");
			return;
		} finally {
			// 입력,수정,삭제 처리의 경우 실제 반영을 위해서 commit 필요함
			sqlSession.commit();
			// 데이터베이스 접속 해제
			sqlSession.close();
		}
		
		/** (4) 저장된 데이터 출력하기 */
		// 저장된 데이터의 식별값(PK)은 파라미터로 전달된 Beans에 보관된다.
		System.out.println("Primary Key=" + professor.getProfno());
	}
}
