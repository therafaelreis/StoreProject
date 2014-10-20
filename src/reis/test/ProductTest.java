package reis.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import reis.beans.Products;
import reis.jpa.EntityManagerUtil;

public class ProductTest {

	public static void main(String[] args) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Query q = em.createQuery("select a from Products a", Products.class);
		List<Products> products = q.getResultList();
		
		for(Products p : products ){
			System.out.println(p.getDescription());
		}
		
		

	}

}
