package edu.training.news_portal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.training.news_portal.beans.News;
import edu.training.news_portal.dao.DaoException;
import edu.training.news_portal.dao.NewsDao;

public class DBNewsDao implements NewsDao {

	@Override
	public List<News> topNews(int count) throws DaoException {
		List<News> topNews = new ArrayList<News>();
		
		topNews.add(new News(1, "Новости технологий", "Новый искусственный интеллект уже умеет писать код лучше разработчиков.", "Content 1"));
		topNews.add(new News(2, "Политика", "В Европе обсуждают новый пакет экономических реформ.", "Content 2"));
		topNews.add(new News(3, "Новости технологий", "Национальная сборная одержала уверенную победу в товарищеском матче.", "Content 3"));
		
		return topNews;


	}

}
