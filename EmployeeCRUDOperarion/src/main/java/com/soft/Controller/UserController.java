package com.soft.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soft.Entity.User;
import com.soft.Service.UserService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	//save user by id
	@PostMapping("/saveUserId")
	public HashMap<String, Object> saveUserDetails(@RequestBody User save){
		
		HashMap<String, Object> response= userService.userSaveDetailService(save);
		
		return response;
		
	}
	//delete user by id
	@DeleteMapping("/deleteUserById")
	public HashMap<String, Object> deleteUserById(@RequestParam int userId){
		HashMap<String, Object> response =userService.userDeletebyIdService(userId);
		return response;
		}
	//update by user id
	@PostMapping("updateUserbyId/{id}")
	public HashMap<String, Object> updateUser(@RequestParam int userId , @RequestBody User user){
		HashMap<String, Object> response = userService.userUpadteService(userId, user);
		return response;
		
	}
	
	

}
