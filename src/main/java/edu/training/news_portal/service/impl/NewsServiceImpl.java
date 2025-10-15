package edu.training.news_portal.service.impl;

import java.util.List;

import edu.training.news_portal.beans.News;
import edu.training.news_portal.dao.DaoException;
import edu.training.news_portal.dao.DaoProvider;
import edu.training.news_portal.dao.NewsDao;
import edu.training.news_portal.service.NewsService;
import edu.training.news_portal.service.ServiceException;

public class NewsServiceImpl implements NewsService {
	
	private final NewsDao newsDao = DaoProvider.getInstance().getNewsDao();
	
	private final int MAX_AVAILABLE_TOP_NEWS = 10;

	@Override
	public List<News> takeTopNews(int count) throws ServiceException {
		
		if(count <= 0 || count > MAX_AVAILABLE_TOP_NEWS) {
			throw new ServiceException("Error message");
		}
		
		try {
			return newsDao.topNews(count);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
