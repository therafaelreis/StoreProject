package reis.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import reis.beans.Employee;
import reis.converter.SectionConverter;
import reis.model.EmployeeDAO;
import reis.model.SectionDAO;


@ManagedBean(name="employeeController")
@SessionScoped
public class EmployeeController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	EmployeeDAO dao;
	Employee employee;
	SectionDAO sectionDAO;
	
	public EmployeeController(){
		dao = new EmployeeDAO();
		sectionDAO = new SectionDAO();
		employee = new Employee();
	}
	
	public void gravar(){
		this.dao.gravar(this.employee);
		employee = new Employee();
	}

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SectionDAO getSectionDAO() {
		return sectionDAO;
	}

	public void setSectionDAO(SectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}





}
