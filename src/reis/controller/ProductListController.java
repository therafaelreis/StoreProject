package reis.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import reis.beans.Products;
import reis.model.ProductDAO;

@ManagedBean(name="productListController")
@RequestScoped
public class ProductListController implements Serializable{

	private static final long serialVersionUID = 1L;

	private String description;
	private ProductDAO dao = new ProductDAO();
	private List<Products> products;
	
	
	public String listar(){
		return "/store/list?faces-redirect=true";
	}

	public void search(){
		this.products  = dao.byDescription(description);
	}
	
	public void allProd(){
		this.products = dao.listAll();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
}
