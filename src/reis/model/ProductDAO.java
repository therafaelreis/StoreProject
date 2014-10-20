package reis.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import reis.util.UtilError;
import reis.util.UtilMessage;
import reis.beans.Products;
import reis.jpa.EntityManagerUtil;


public class ProductDAO {
	
	private EntityManager em;
	public ProductDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public boolean gravar(Products product){
		try{
			em.getTransaction().begin();
			if(product.getId() == null){
				em.persist(product);
			}else{
				em.merge(product);
			}
			em.getTransaction().commit();
			UtilMessage.infoMessage("Product save with success");
			
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
	
	public List<Products> listAll(){
		Query q = em.createQuery("select a from Products a", Products.class);
		List<Products> products = q.getResultList();
		return products;
	}
	
	
	public List<Products> byDescription(String description){
		String query = "from Products where description like :description "
				+ "order by funLevel desc";

		return em.createQuery(query, Products.class).setParameter("description", "%" + StringUtils.defaultIfBlank(description,"") + "%").getResultList();
	}
	
	public Products byId(Long id){
		return em.find(Products.class, id);
	}
	
	
}
