package cn.oetl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.oetl.dao.mapper.AdminMapper;
import cn.oetl.dao.mapper.AttachmentMapper;
import cn.oetl.dao.mapper.NewsMapperSecond;
import cn.oetl.pojo.Admin;
import cn.oetl.pojo.News;
import cn.oetl.service.AdminService;
import cn.oetl.service.AttachmentService;
import cn.oetl.service.NewsService;

@Service(value = "newsService")
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsMapperSecond newsMapper;

//	@Autowired
	PageHelper pageHelper;
	
	@Override
	public PageInfo<News> selectByPageHelper(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
        List<News> news = newsMapper.selectAll();
        PageInfo<News> pageInfo = new PageInfo<News>(news);
        return pageInfo;
	}
	
	@Override
	public News selectNews(int news_id) {
		return newsMapper.selectByPrimaryKey(news_id);
	}

	@Override
	public int deleteNews(int news_id) {
		return newsMapper.deleteByPrimaryKey(news_id);
	}

	@Override
	public int insertNews(News news) {
		return newsMapper.insert(news);
	}

	@Override
	public int updateNews(News news) {
		return newsMapper.updateByPrimaryKey(news);
	}

}