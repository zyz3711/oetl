package cn.oetl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.oetl.pojo.News;


public interface NewsService {
	
	PageInfo<News> selectByPageHelper(int pageNo, int pageSize);
	
	public News selectNews(int news_id) throws Exception;

	public int deleteNews(int news_id) throws Exception;

	public int insertNews(News news) throws Exception;

	public int updateNews(News news) throws Exception;
}
