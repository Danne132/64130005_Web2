package com.duyan.HelloSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //Để chương trình xác định đây là một controller
public class HelloController {
	// Mỗi controller có một action
	// Cần có một URL tương ứng để gọi cho action này
	@RequestMapping("/hello") //Người dùng request đến địa chỉ /hello
	public String helloBoot() {
		// Code xử lý... 
		return "helloView";
	}
}
