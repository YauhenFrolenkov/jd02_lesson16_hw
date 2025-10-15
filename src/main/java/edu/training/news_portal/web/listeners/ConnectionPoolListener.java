package edu.training.news_portal.web.listeners;

import java.sql.SQLException;

import edu.training.news_portal.dao.DaoRuntimeException;
import edu.training.news_portal.dao.pool.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class ConnectionPoolListener implements ServletContextListener {
	
	public ConnectionPoolListener() {
		
	}
	
	public void contextInitialized(ServletContextEvent sce) {
		try {
						
			ConnectionPool.getFirstInstance("jdbc:mysql://localhost:3306/nova_news_4?useSSL=false", "root", "1234", 5);
		} catch (SQLException e) {
			//получим responce и отправим ответ на страницу ошибок
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			ConnectionPool.getInstance().close();
		} catch (SQLException e) {
			//logger FATAL ERROR
			
		}
	}

}
