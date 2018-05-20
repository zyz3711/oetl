package cn.oetl.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

// 全局异常处理器，需要实现springmvc中的HandlerExceptionResolver接口
// 本质上这也是个Handler，但是不需要注解或者配置文件注册，需要有特定的适配器来调用执行
public class CustomExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// ex：系统抛出的异常会被这个参数捕捉
		ex.printStackTrace();
		CustomException customException = null;
		// 如果该异常类型是我自定义的异常，强转为自定义异常
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		}
		// 如果该异常类型不是我自定义的异常，则构造一个自定义异常
		else {
			customException = new CustomException("未知错误，请与管理员联系");
		}
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}
}