package study.jsp.myschool.service;

import java.util.List;

import study.jsp.myschool.model.Department;

public interface DepartmentService {
	
	public void addDepartment(Department depatment) throws Exception;
	public void editDepartment(Department depatment) throws Exception;
	public void deleteDepartment(Department depatment) throws Exception;
	public Department getDepartmentItem(Department depatment) throws Exception;
	public List<Department> getDepartmentList(Department depatment) throws Exception;
	public int getDepartmentCount(Department department) throws Exception;	
}
