package reis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import reis.beans.Products;
import reis.model.ProductDAO;

@WebServlet(urlPatterns = "/photo")
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductDAO dao;
	
	public ImageServlet(){
		dao = new ProductDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long idProduct = Long.valueOf(request.getParameter("product"));
		
		Products prod = dao.byId(idProduct);
		
		response.setContentType("image/jpeg");
		IOUtils.write(prod.getImage(), response.getOutputStream());
	}
}
