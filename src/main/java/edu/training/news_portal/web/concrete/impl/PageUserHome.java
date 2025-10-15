package edu.training.news_portal.web.concrete.impl;

import java.io.IOException;

import edu.training.news_portal.beans.User;
import edu.training.news_portal.web.concrete.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PageUserHome implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userHome.jsp");
		dispatcher.forward(request, response);
		
	}

}
