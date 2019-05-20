
package com.yyc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyc.entity.UserInfo;
import com.yyc.service.UserService;

/**************************************
* @author 尹以操 E-mail:34782655@qq.com
* @version 创建时间：2017年6月23日 下午4:18:25
* 类说明:
***************************************
*/
@Controller
@RequestMapping(value="/main")
public class MainController {
	private static Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * 1、@Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。 
	   2、@Autowired默认按类型装配（这个注解是属业spring的），默认情况下必须要求依赖对象必须存在，
	   	如果要允许null 值，可以设置它的required属性为false，如：@Autowired(required=false) ，
	   	如果我们想使用名称装配可以结合@Qualifier注解进行使用，如下： 
		@Autowired() @Qualifier("baseDao")     
		private BaseDao baseDao;    
 	   3、@Resource（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 
		 如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找，
		 如果注解写在setter方法上默认取属性名进行装配。 当找不到与名称匹配的bean时才按照类型进行装配。
		 但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。
	 */
	@Resource
	private UserService userService;
	@RequestMapping(value="/test")
	@ResponseBody
	public String testConnection(){
		logger.info("进入test方法...");
		return "请求/main/test成功！";
	}
	
	@RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){
		logger.info("进入showUser方法...");
        int userId = Integer.parseInt(request.getParameter("id"));  
        UserInfo user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";  
    }  
}
