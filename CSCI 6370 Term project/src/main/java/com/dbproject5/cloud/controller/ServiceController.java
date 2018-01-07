package com.dbproject5.cloud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.CloudServicesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class ServiceController {
   
	@Autowired
	public CloudServicesService cloudService;
	 @PostMapping("/requestService")
	public @ResponseBody String ajaxResult(@RequestBody String content)
	{ 
		System.out.println(content);
		Users user=new Users();
		String result="res";
		ServiceAllocation allocation=cloudService.requestService(content);
		ObjectWriter obj=new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			result=obj.writeValueAsString(allocation);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	 @PostMapping("/approveResources")
	 public @ResponseBody String approveRequests(@RequestBody String data)
	 {
		 String result="";
		 result=cloudService.approveRequests(data);
		 return result;
	 }
	 
	 @PostMapping("/viewPendingRequests")
     public String viewPendingRequests(@ModelAttribute Users user,Model model)
	 {
		 
	    List<Users> pendingUsers=cloudService.getPendingUsers(user);
	    model.addAttribute("pendingUsers", pendingUsers);
	    model.addAttribute("user",user);
		
		 return "login/pendingReq";
	 }
}
