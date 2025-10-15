package edu.training.news_portal.service;

import java.util.List;

import edu.training.news_portal.beans.News;

public interface NewsService {
	
	List<News> takeTopNews(int count) throws ServiceException;

}
