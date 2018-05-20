package cn.oetl.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.oetl.pojo.Admin;

@Component(value = "postInterceptor")
public class PostInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session = arg0.getSession();
		String uri = arg0.getRequestURI();

		if (uri.indexOf("login") >= 0 || uri.indexOf("news/all") >= 0) {
			// 如果进行登陆提交，放行
			return true;
		}
		if (arg0.getMethod() == "post") {
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin == null) {
				
				// 执行这里表示用户身份需要认证，跳转登陆页面
				arg0.getRequestDispatcher("/admin/login.jsp").forward(arg0, arg1);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
	}
}
