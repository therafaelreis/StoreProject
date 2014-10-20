package reis.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.Part;
import reis.beans.Products;
import reis.model.ProductDAO;

@ManagedBean(name="productController")
@ViewScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Products product;
	private ProductDAO dao;
	private  Part photo;
		
	
	public ProductController(){
		product = new Products();
		dao = new ProductDAO();
	}
	
	public String add() throws IOException{
			this.product.setImage(IOUtils.toByteArray(this.photo.getInputStream()));;
			this.dao.gravar(this.product);
			this.product = new Products();
		return "NewProduct";
		
	}
	
	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}


	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public Part getPhoto() {
		return photo;
	}

	public void setPhoto(Part photo) {
		this.photo = photo;
	}

	
	
	
	
}
