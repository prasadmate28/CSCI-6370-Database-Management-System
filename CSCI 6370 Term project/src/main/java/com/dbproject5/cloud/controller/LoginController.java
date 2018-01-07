package com.dbproject5.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbproject5.cloud.entity.Faculty;
import com.dbproject5.cloud.entity.LoginDetails;
import com.dbproject5.cloud.entity.Resources;
import com.dbproject5.cloud.entity.ServiceAllocation;
import com.dbproject5.cloud.entity.Services;
import com.dbproject5.cloud.entity.Student;
import com.dbproject5.cloud.entity.Users;
import com.dbproject5.cloud.service.CloudAllocationService;
import com.dbproject5.cloud.service.CloudServicesService;
import com.dbproject5.cloud.service.LoginService;
import com.dbproject5.cloud.service.ResourceServe;


@Controller
public class LoginController {

	@Autowired
	public LoginService loginService;
	
	@Autowired
	public CloudServicesService cloudService;
	
	@Autowired
	public CloudAllocationService allocationService;
	
	@Autowired
	public ResourceServe resourceService;
	
	
	
	@GetMapping("/")
	public String loginForm(Model model)
	{           model.addAttribute("details", new Users());

			return "login/login";
	}
	
/*	@GetMapping("/success")
	public String loginSucess()
	{   
		return "login/success";
	}
	@PostMapping("/success")
	 public String findByPassword(@ModelAttribute Users details ,Model model)
	 { 
		System.out.println("Here");
		
		 if (loginService.findBymyID(details.getMyId(),details.getPassword()))
			 return "login/success";
		 else {
			 model.addAttribute("details", new Users());
			 return "login/login";
		 }
	} */
	@PostMapping("/loginDetails")
	public String findBymyIdAndPassword(@ModelAttribute Users details, Model model)
	{
		Users user=loginService.findBymyIdAndPassword(details.getMyId(),details.getPassword());
		List<Services> services=cloudService.findAll();
		if(user==null)
		{
			model.addAttribute("Userdetails", new Users());
			return "login/loginError";
		}
		List<Services> pendingServices=cloudService.findByPending(user.getXx81_ID());
		List<Services> activeServices=cloudService.findActive(user.getXx81_ID());
		model.addAttribute("user", user);
		model.addAttribute("services", services);
		model.addAttribute("pendingServices", pendingServices);
		model.addAttribute("activeServices", activeServices);
		if(user.getRole()=='R')
		{
			List<Resources> resources=resourceService.getResourceInfo(user);
			model.addAttribute("resources", resources);
			return "login/resource";
		}
		if(user.getRole()=='D')
		{
			List<Users> students=allocationService.findByDepartment(user);
			model.addAttribute("students",students);
			Faculty faculty=loginService.findFacultyById(user.getXx81_ID());
			model.addAttribute("faculty",faculty);
			return "login/department";
		}
		else if(user.getRole()=='F')
		{
			List<Users> students=allocationService.geStudentsHoldingService(user);
			model.addAttribute("students",students);
			Faculty faculty=loginService.findFacultyById(user.getXx81_ID());
			model.addAttribute("faculty",faculty);
			return "login/faculty";

		}
         Student student=loginService.findBystudId(user.getXx81_ID());
         model.addAttribute("student", student);
		 return "login/student";
	}
	@PostMapping("/loadDepartment")
	public String loadDepartment(@ModelAttribute Users user, Model model)
	{
		List<Services> services=cloudService.findAll();
		List<Services> pendingServices=cloudService.findByPending(user.getXx81_ID());
		List<Services> activeServices=cloudService.findActive(user.getXx81_ID());
		model.addAttribute("user", user);
		model.addAttribute("services", services);
		model.addAttribute("pendingServices", pendingServices);
		model.addAttribute("activeServices", activeServices);
		List<Users> students=allocationService.findByDepartment(user);
		model.addAttribute("students",students);
		Faculty faculty=loginService.findFacultyById(user.getXx81_ID());
		model.addAttribute("faculty",faculty);

		return "login/department";
	}

}
