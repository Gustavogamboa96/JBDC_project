package com.conigxia.jump.dao;

import java.util.List;

public interface EMSDao {
	public  List<Employee> getAll();
	public Employee getEmployee(int employee_id);
	public void addEmployee(Employee newbie);
	public void updateEmployee(int employee_id, int option, String newinfo);
	public void deleteEmployee(int employee_id);
}
