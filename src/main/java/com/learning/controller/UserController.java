package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.learning.dto.UserDto;
import com.learning.entity.User;
import com.learning.service.UserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private static final String LIST ="user/main";
	private static final String FORM ="user/form";
	private static final String RD_TO_LIST = "redirect:/user";
	
	private final UserService userService;
	
	@GetMapping({"/",""})
	public String listPage(Model model) {
		Iterable<User> users = userService.findAllUsers();
		model.addAttribute("data", users);
		return LIST;
		
	}
	
	@GetMapping("/create")
	public String createPage(Model model) {
		model.addAttribute("data", UserDto.builder().build());
		return FORM;
		
	}
	
    @PostMapping("/save")
    public String saveUser(UserDto reqest, @RequestParam("thumbnail") MultipartFile thumbnail, Model model) {

        System.out.println(reqest);
        System.out.println(reqest.uuid());
        System.out.println(thumbnail.getOriginalFilename());
        
        User user = userService.createNewUser(reqest, thumbnail);
        
    	model.addAttribute("data", user);
        if(user!=null) {
        	model.addAttribute("status", "SUCCES");
        }else {
        	model.addAttribute("status", "ERROR");
        }
        return RD_TO_LIST;
    }


}
