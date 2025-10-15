package edu.training.news_portal.dao;

import java.util.List;

import edu.training.news_portal.beans.News;

public interface NewsDao {
	
	List<News> topNews(int count) throws DaoException;

}
