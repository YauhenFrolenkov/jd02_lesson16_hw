package edu.training.news_portal.web.concrete.impl;

import java.io.IOException;

import edu.training.news_portal.beans.User;
import edu.training.news_portal.service.ServiceException;
import edu.training.news_portal.service.ServiceProvider;
import edu.training.news_portal.service.UserSecurity;
import edu.training.news_portal.web.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAuth implements Command {

	private final UserSecurity security = ServiceProvider.getInstance().getUserSecurity();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			User user;
			if ((user = security.signIn(email, password)) == null) {

				response.sendRedirect("NewsPortalController?command=page_auth&authError=true");
				return;
			}

			HttpSession session = request.getSession(true);
			session.setAttribute("auth", user);
			
			String rememberMe = request.getParameter("remember-me");
			if (rememberMe != null) {
				Cookie cookie = new Cookie("remember-me", user.getName()); //attention, realization is not safe
				response.addCookie(cookie);
			}

			response.sendRedirect("NewsPortalController?command=page_user_home");

		} catch (ServiceException ex) {
			response.sendRedirect("error.jsp");

		}

	}

}
