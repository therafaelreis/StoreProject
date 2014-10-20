package reis.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import reis.beans.Products;
import reis.beans.Section;
import reis.jpa.EntityManagerUtil;
import reis.util.UtilMessage;

public class SectionDAO  {
	
	private EntityManager em;
	
	public SectionDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public List<Section> listAll(){
		Query q = em.createQuery("select a from Section a", Section.class);
		List<Section> sections = q.getResultList();
		return sections;	
	}
	
	public boolean gravar(Section section){
		try {
			em.getTransaction().begin();
			if (section.getId() == null){
				em.persist(section);
			} else {
				em.merge(section);
			}
			em.getTransaction().commit();
			UtilMessage.infoMessage("Section save with success!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMessage.errorMessage("Error trying to save section");
			return false;
		}
		
	}
}
