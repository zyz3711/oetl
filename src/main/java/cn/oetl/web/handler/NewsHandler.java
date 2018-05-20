package cn.oetl.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import cn.oetl.pojo.Admin;
import cn.oetl.pojo.Attachment;
import cn.oetl.pojo.News;
import cn.oetl.service.AdminService;
import cn.oetl.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsHandler {
	
	@Autowired
	private NewsService newsService;
	
	// 分页获取新闻列表
	@RequestMapping(value="/all/{pageSize}/{pageNum}", method={RequestMethod.GET})
	public void selectNews(@PathVariable("pageSize")Integer pageSize, @PathVariable("pageNum")Integer pageNum) throws Exception {
		
	}
	
	// 根据news_id获取新闻
	@RequestMapping(value="/{newsId}", method={RequestMethod.GET})
	@ResponseBody
	public News selectNewsById(@PathVariable("newsId") Integer newsId) throws Exception {
		News news = newsService.selectNews(newsId);
		return news;
	}
	
	// 添加新闻
	@RequestMapping(value="/add", method={RequestMethod.POST})
	public String insertNews() throws Exception {
		return "news/add_news";
	}
	
	// 按照id删除新闻（同时删除附件）
	@RequestMapping(value="/delete/{newsId}", method={RequestMethod.POST})
	public String deleteNews(HttpSession session, @PathVariable("newsId")Integer newsId) throws Exception {
		News news = newsService.selectNews(newsId);
		int id1 = news.getAdmin().getAdmin_id();
		Admin admin = (Admin)session.getAttribute("admin");
		// 只有超级管理员或者新闻的管理者有权限删除新闻
		if(admin.getAdmin_id() == 1 || admin.getAdmin_id() == id1) {
			int i = newsService.deleteNews(newsId);
			session.setAttribute("deleteMessage", "删除成功");
		} else {
			session.setAttribute("deleteMessage", "您没有权限删除这条新闻！");
		}
		return "forward:新闻管理页面";
	}
	
	//更新某条新闻的信息
	@RequestMapping(value="/update/{newsId}", method={RequestMethod.POST})
	public void updateNews(@PathVariable("newsId")Integer newsId) throws Exception {
		News news = new News();
		news.setNews_id(newsId);
		// 更新新闻信息
		newsService.updateNews(news);
	}

}