package cn.oetl.spring;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import cn.oetl.pojo.Admin;
import cn.oetl.web.exception.CustomExceptionResolver;
import cn.oetl.web.interceptor.PostInterceptor;

// 这个@Configuration用于替代springmvc.xml
@Configuration
public class SpringMVCConfig extends WebMvcConfigurationSupport {

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        // viewResolver.setViewClass(JstlView.class); // 这个属性通常并不需要手动配置，高版本的Spring会自动检测
        return viewResolver;
    }
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
   	
    	// 设置默认视图，即访问 ip:8080/项目名/ 的页面
    	// 受到视图解析器前后缀控制
    	registry.addViewController("/").setViewName("/frontpage");
    	registry.addViewController("/login").setViewName("/admin/admin_login");
//    	registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//
    	// 当浏览器请求 /toview 时，跳转到view视图（由视图解析器识别）
//    	registry.addViewController("/toview").setViewName("view");

    	// 对于直接访问 ip:8080/项目名 ,通过重定向跳转到首页    	
//        registry.addRedirectViewController("/","/frontpage.html");
        super.addViewControllers(registry);
    }
	
	// 配置启动时初始化监听器

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	    configurer.setUseSuffixPatternMatch(false).
	            setUseTrailingSlashMatch(true);
	}
	
	// 配置拦截器
	@Autowired
	PostInterceptor postInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(postInterceptor).addPathPatterns("/**");
	}

// =============配置静态资源解析路径==============
	// 配置文件上传路径
	@Value("${web.upload-path}")
	private String path;
	
	// 配置静态资源解析路径
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceHandler配置对外暴露路径，addResourceLocations配置文件存放目录，注意是可变参数类型
//		registry.addResourceHandler("/**").addResourceLocations(
//				"classpath:/ueditor/, "
//				, "classpath:/css/,"
//				, "classpath:/images/, "
//				, "file:${web.upload-path}, "
//				, "classpath:/jsp/");
    	registry.addResourceHandler("/**").addResourceLocations("/");
	}
// ============================================



	// 配置全局异常处理器
	@Bean(name = "exceptionResolver")
	public HandlerExceptionResolver exceptionResolver() {
		CustomExceptionResolver customExceptionResolver = new CustomExceptionResolver();
		return customExceptionResolver;
	}

}