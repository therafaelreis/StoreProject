package reis.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reis.controller.LoginController;

@WebFilter (urlPatterns="/admin/*")
public class SecurityFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String contextPath = httpRequest.getContextPath();
		LoginController loginController = (LoginController) session.getAttribute("loginController");
		
		if(loginController == null || loginController.getEmployeeSession() == null){
			httpResponse.sendRedirect(contextPath + "/index.xhtml");
		}else{
			String page = httpRequest.getRequestURI().toString();
			
			if(page.contains("/admin")){
				if(!loginController.getEmployeeSession().getSection().getName().equals("Manager")){
					httpResponse.sendRedirect(contextPath + "/accessDenied.xhtml");
				}
			}
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
