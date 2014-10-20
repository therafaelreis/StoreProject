package reis.model;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import reis.beans.Employee;
import reis.jpa.EntityManagerUtil;
import reis.util.UtilError;
import reis.util.UtilMessage;

public class EmployeeDAO {
	
	EntityManager em ;
	
	public EmployeeDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public boolean gravar(Employee employee){
		try{
			em.getTransaction().begin();
			if(employee.getId() == null){
				em.persist(employee);
			}else{
				em.merge(employee);
			}
			em.getTransaction().commit();
			UtilMessage.infoMessage("Employee save with success");
			
			return true;
		}catch(Exception e){
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMessage.errorMessage("Error trying to persist the object" + UtilError.getMensagemErro(e));
			
			return false;
		}
	}
	
	public boolean login(String username, String password){
		Query query = em.createQuery("from Employee where upper(username) = :username"+ " and upper(password) = :password");
		query.setParameter("username", username.toUpperCase());
		query.setParameter("password", password.toUpperCase());
		
		if(!query.getResultList().isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public Employee findByName(String username){
		return (Employee) em.createQuery("from Employee where upper(username) = " + ":username").setParameter("username", username.toUpperCase()).getSingleResult();
	}
}
