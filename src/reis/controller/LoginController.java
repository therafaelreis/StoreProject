package reis.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import reis.beans.Employee;
import reis.model.EmployeeDAO;
import reis.util.UtilMessage;


@SessionScoped
@ManagedBean(name="loginController")
public class LoginController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private EmployeeDAO dao;
	private Employee employeeSession;
	private String username;
	private String password;
	
	public LoginController() {
		dao = new EmployeeDAO();
	}
	
	public String loginPage(){
		return "/login";
	}
	
	public String login(){
		if(dao.login(username, password)){
			employeeSession = dao.findByName(username);
			UtilMessage.infoMessage("Login with success");
			return "/admin/main";
		}else{
			UtilMessage.errorMessage("Username or password wrong!");
			return "/index";
		}
	}
	
	public EmployeeDAO getDao() {
		return dao;
	}
	
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}
	
	public Employee getEmployeeSession() {
		return employeeSession;
	}

	public void setEmployeeSession(Employee employeeSession) {
		this.employeeSession = employeeSession;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	 

}
