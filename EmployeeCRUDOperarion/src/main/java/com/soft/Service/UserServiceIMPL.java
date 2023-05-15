package com.soft.Service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.Entity.User;
import com.soft.Repo.UserRepo;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public HashMap<String, Object> userSaveDetailService(User user) {
		// TODO Auto-generated method stub
		HashMap<String, Object> response = new HashMap<>();
		
		try {
			
			User saveduser = userRepo.save(user);
			
			if(saveduser!=null) {
				response.put("message", "you have registered successfully");
				response.put("Status", true);
				response.put("data", saveduser);
			}
			else {
				response.put("message", "you have not registered successfully");
				response.put("Status", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
     // delete user by id
	@Override
	public HashMap<String, Object> userDeletebyIdService(int userId) {
		
		
              HashMap<String, Object> response = new HashMap<>();
		
              if(userRepo.existsById(userId)) {
            	  
            	  userRepo.deleteById(userId);
            	  response.put("message", "user deleted successfully with "+userId);
            	  response.put("Status", true);
            	  
            	  }else {
      				response.put("message", "user not found with this id:"+userId+"userid....");
    				response.put("Status", false);
    			}
		
			return response;
		
	}
	@Override
	public HashMap<String, Object> userUpadteService(int userId, User user) {
		
		HashMap<String, Object> response = new HashMap<>();
		User userUpdate = null;
		Optional<User> checkUserById=null;
		try {
			checkUserById = userRepo.findById(userId);
			if(checkUserById.isPresent()) {
				userUpdate=checkUserById.get();
				userUpdate.setUserName(user.getUserName());
				userUpdate.setUserAddress(user.getUserAddress());
				userUpdate.setUserEmail(user.getUserEmail());
				userUpdate.setUserpassword(user.getUserpassword());
				userUpdate.setUserId(userId);
				userRepo.save(userUpdate);
				response.put("message", "user updated successfully with "+userId);
          	    response.put("Status", true);
          	    response.put("Data", userUpdate);
          	  
          	  }else {
    				response.put("message", "user not found with this id:"+userId+"userid....");
  				response.put("Status", false);
  			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
