package com.learning.service;


import org.springframework.web.multipart.MultipartFile;

import com.learning.dto.UserDto;
import com.learning.entity.User;

public interface UserService {
	
	User createNewUser(UserDto request, MultipartFile multipartFile);
	Iterable<User> findAllUsers();

}
