package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;



@Service

public class UserService {

	@Autowired
private	UserRepository userRepository;

	public List<User> searchAll() {
//		ユーザーテーブルの内容を全検索
		
		return userRepository.findAll();
	}
	
	public List<User> searchUser(String keyword){
		return userRepository.findByNameContaining(keyword);
	}
	
	public User findUser(Long id) {
		return userRepository.getReferenceById(id);
	}
	
	public void  deleteUser(Long id) {
		System.out.println(id);
		 userRepository.deleteById(id);
	}
	
	
	
	public void createUser(String name,String createDate) {
		User user=new User();
		user.setName(name);
		user.setCreateDate(createDate);
		
		userRepository.save(user);
	}
	
	public String updateUser(User user) {
		 System.out.println("Updating user: " + user);
	        userRepository.save(user);
	        return "redirect:/user/list";
	}
	
	

}
