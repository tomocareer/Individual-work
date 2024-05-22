package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}

	@GetMapping("user/update/{id}")
	public String updatePage(@PathVariable Long id, Model model) {
		System.out.println(id);
		User user = userService.findUser(id);
		System.out.println(user);
		model.addAttribute("user", user);
		return "user/update.html";
	}

	@GetMapping("user/delete/{id}")
	public String deleteList(@PathVariable Long id) {
		System.out.println("Deleting user with ID: " + id);
		userService.deleteUser(id);
		return "redirect:/user/list"; // 実際の削除は行わず、リストページにリダイレクトする

	}

	@PostMapping("/user/update")
	public String updateUser(@ModelAttribute User user) {
		System.out.println(user);
		LocalDateTime updateDate=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
		String formatteDate=updateDate.format(formatter);
		user.setUpdateDate(formatteDate);

		userService.updateUser(user);
		return "redirect:/user/list";
	}

	@PostMapping("/user/create")
	public String createUser(@RequestParam String name) {

		LocalDateTime createDate =LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
		
		String formatteDate=createDate.format(formatter);
		System.out.println(formatteDate);
		userService.createUser(name,formatteDate);
		return "redirect:/user/list"; // 実際の削除は行わず、リストページにリダイレクトする

	}
	
	@GetMapping("/user/search")
	public String searchPerson(@RequestParam("keyword") String keyword, Model model) {
		List<User> userlist = userService.searchUser(keyword);
		model.addAttribute("userlist", userlist);
		return "/user/list";
	}
	
	

}
