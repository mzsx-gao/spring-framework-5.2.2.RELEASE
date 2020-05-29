package com.gao.controller;

import com.gao.entity.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class DemoController {

	@ResponseBody
	@RequestMapping("/requestParam")
	public String requestParam(@RequestParam String orderId){
		return "orderId===="+orderId;
	}

	@ResponseBody
	@RequestMapping("/requestBody")
	public String requestBody(@RequestBody RequestEntity requestEntity){
		return requestEntity.toString();
	}
	
	//相当于会找 /WEB-INF/pages/ok.jsp
	@RequestMapping("/ok")
	public String ok(){
		return "ok";
	}

	//重定向测试
	@RequestMapping("/redirect")
	public String redirect(){
		System.out.println("重定向测试");
		return "redirect:/ok";
	}
	/**
	 * 目标方法可以添加 ModelMap 类型,这里的modelMap里保存值后其它地方可以在request作用域拿到，原理如下:
	 *
	 * 当目标方法参数类型是Map时，传到目标方法里的参数是ModelAndViewContainer的defaultModel属性，类型为BindingAwareModelMap
	 * InvocableHandlerMethod#invokeForRequest方法里有这两行代码:
	 * Object[] args = getMethodArgumentValues(request, mavContainer, providedArgs);
	 * Object returnValue = doInvoke(args);
	 *
	 * 由于args是ModelAndViewContainer的defaultModel属性，所以args作为参数传到目标方法后，实际上目标参数里现在拿到的参数modelMap是
	 * ModelAndViewContainer的defaultModel属性的引用，所以在目标方法里向modelMap里set数据后,defaultModel属性自然就有数据了。
	 * 而ModelAndViewContainer就是承担着整个请求过程中数据的传递工作
	 */
	@RequestMapping("/testMap")
	public String testMap(ModelMap modelMap){
		System.out.println("DemoController#testMap..."+modelMap.getClass().getName());
		modelMap.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
//		if(true){
//			throw new RuntimeException("测试springmvc异常处理机制");
//		}
		return "ok";
	}
}
