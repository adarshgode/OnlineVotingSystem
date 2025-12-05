package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//converting ServletRequest and Response to HttpServletRequest and response
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession(false);
		boolean isLoggedIn = (session != null && session.getAttribute("voter") != null );
		
		//load/allow all css,jss,images folders and their content
		String path = req.getRequestURI();
		System.out.println(path);
		
		if(path.endsWith("candidateregister") || path.endsWith("candidateregister.jsp") ||
				path.endsWith("voterregister") || path.endsWith("voterregister.jsp") || 
				 path.endsWith("successvote") ||  path.endsWith("successvote.jsp")
				|| path.contains("/css/") || path.contains("/js/") || path.contains("/images/")) {
			chain.doFilter(request, response);
			return;
		}
		
		boolean isLoginPath = path.endsWith("login") || path.endsWith("login.jsp") ;
		
		if(!isLoggedIn && !isLoginPath) {
			resp.sendRedirect("login");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
