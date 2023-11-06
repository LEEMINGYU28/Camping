package com.java4.camping.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
	@GetMapping("/test")
	public ArrayList<HashMap<String, Object>> test(HttpServletRequest req) throws Exception{

		//response Data
		ArrayList<HashMap<String, Object>> rtnArray = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> rtnMap = new HashMap<String, Object>();

		rtnMap.put("requestData1", req.getParameter("name"));
		rtnMap.put("requestData2", req.getParameter("food"));
		rtnArray.add(rtnMap);

		return rtnArray; 
	}

}
