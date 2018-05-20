package cn.oetl.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.oetl.pojo.Admin;
import cn.oetl.pojo.News;
import cn.oetl.service.AdminService;
import cn.oetl.service.NewsService;

@Controller
@RequestMapping("/admin")
public class AdminHandler {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private NewsService newsService;
	
	// 登录功能
	// 默认get，设置成Post则无法直接访问
	@PostMapping(value = {"/login"})
	public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin = adminService.selectAdminByName(username);
		if(admin == null) {
			session.setAttribute("loginMessage", "不存在此用户！");
			return "/admin/admin_login";
		}
		else if(!admin.getPassword().equals(password)) {
			System.out.println("数据库的password：" + admin.getPassword());
			session.setAttribute("loginMessage", "密码错误！");
			return "/admin/admin_login";
		} else {
			session.setAttribute("admin", admin);
			return "/frontpage";
		}
	}
	
	// 登出功能
	@PostMapping(value = {"/logout"})
	public String logout(HttpSession session) throws Exception {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/admin/frontpage.jsp";
	}
	
	// 分页查找所有admin
	@RequestMapping(value="/all/{pageSize}/{pageNum}", method={RequestMethod.GET})
	public void getAllAdminByLimit(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum) throws Exception {
		List<Admin> listAdmin = adminService.selectAllByLimit(pageNum, pageSize);
		System.out.println(listAdmin);
	}
	
	// 根据id修改admin
	@RequestMapping(value="/update/{adminId}", method={RequestMethod.POST})
	public String updateAdmin(@PathVariable("adminId") Integer adminId, HttpSession session) throws Exception {
		Admin admin = (Admin)session.getAttribute("admin");
		int admin_id = admin.getAdmin_id();
		// root用户的admin_id 是1
		if(admin_id == 1) {
			return "redirect:root用户管理所有admin的页面";
		}
		else {
			return "redirect:当前普通admin修改自己信息的页面";
		}	
	}
	
	// root用户可根据id删除其他admin
	@RequestMapping(value="/delete/{adminId}", method={RequestMethod.POST})
	public String deleteAdmin(HttpSession session, @PathVariable("adminId") Integer adminId) throws Exception {
		Admin admin = (Admin)session.getAttribute("admin");
		int admin_id = admin.getAdmin_id();
		// root用户的admin_id 是1
		if(admin_id != 1) {
			session.setAttribute("rightHint", "您没有权限，不是超级管理员");
			return "redirect:/admin/frontpage.jsp";
		}
		else {
			// 有权删除其他admin
			int i = adminService.deleteAdmin(adminId);
			return "redirect:/admin/frontpage.jsp";
		}		
	}
	
	// root用户可添加admin
	@RequestMapping(value="/admin/add", method={RequestMethod.POST})
	public String insertAdmin(HttpSession session) throws Exception {
		Admin admin = (Admin)session.getAttribute("admin");
		int admin_id = admin.getAdmin_id();
		// root用户的admin_id 是1
		if(admin_id != 1) {
			session.setAttribute("rightHint", "您没有权限，不是超级管理员");
			return "redirect:/admin/frontpage.jsp";
		}
		else {
			return "redirect:root添加admin的页面";
		}
	}
	
}