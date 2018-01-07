package com.dbproject5.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.ResourceServe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class ResourceController {
	
	
	@Autowired
	ResourceServe resourceService;
	
	 @PostMapping("/addResource")
		public @ResponseBody String ajaxResult(@RequestBody String data)
		{ 
			
			String result="res";
			int res=resourceService.addResource(data);
			ObjectWriter obj=new ObjectMapper().writer().withDefaultPrettyPrinter();
			try {
				result=obj.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
			
		}

}
