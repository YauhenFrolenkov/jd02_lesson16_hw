package edu.training.news_portal.web.filter;

import java.io.IOException;

import edu.training.news_portal.beans.User;
import edu.training.news_portal.service.ServiceException;
import edu.training.news_portal.service.ServiceProvider;
import edu.training.news_portal.service.UserSecurity;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter("/NewsPortalController") 
public class RememberMeFilter extends HttpFilter implements Filter {
	
	private final UserSecurity security = ServiceProvider.getInstance().getUserSecurity();

	public RememberMeFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);  

		if (session == null || session.getAttribute("auth") == null) {  
			Cookie[] cookies = ((HttpServletRequest) request).getCookies();

			 if (cookies != null) {
	                for (Cookie c : cookies) {
	                    if ("remember-me".equals(c.getName())) {
	                        String email = c.getValue(); // используем email, а не ID
	                        try {
	                            User user = security.findByEmail(email);
	                            if (user != null) {
	                                session = ((HttpServletRequest) request).getSession(true);
	                                session.setAttribute("auth", user);
	                            }
	                        } catch (ServiceException e) {
	                        	System.err.println("RememberMeFilter: ошибка при поиске пользователя по email: " + email);
	                        	e.printStackTrace();
	                        }
	                        break;
	                    }
	                }
	            }
	        }

	       			
		System.out.println("RememberMeFilter before");
		chain.doFilter(request, response);
		System.out.println("RememberMeFilter after");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}



