package reis.test;

import javax.persistence.EntityManager;

import reis.beans.Employee;
import reis.beans.Section;
import reis.jpa.EntityManagerUtil;

public class SectionTest {
	 
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Employee e = new Employee();
		
		Section section = new Section();
		section.setName("Administrator");
		
		e.setUsername("rafael");
		e.setPassword("123");
		e.setSection(section);

		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("Inserido com sucesso!");
	}
	
}
