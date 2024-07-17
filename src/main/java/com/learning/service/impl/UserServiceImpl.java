package com.learning.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learning.dto.UserDto;
import com.learning.entity.User;
import com.learning.repository.UserRepository;
import com.learning.service.SequenceService;
import com.learning.service.UserService;
import com.learning.utils.StringAppUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final FileServiceImpl fileService;
    private final SequenceService sequenceService;
	
	@Override
	public User createNewUser(UserDto request, MultipartFile multipartFile) {
		
		log.info("Inside CreateNewUser: {}", request);	
		
		User newUser = User.builder()
				.id(sequenceService.stringId12digits("users"))
				.uuid(StringAppUtils.uuid16digits())
				.username(request.username())
				.password(request.password())
				.displayName(request.displayName())
				.build();
		
		try {
			
			Map<String, Object> result = fileService.uploadSingle(multipartFile);
			newUser.setThumbnail((String) result.get("fileName"));
			userRepository.save(newUser);
			
		} catch (Exception e) {
			
			log.error("Error Inside CreateNewUser: {}, {}", request, e.getMessage());
			return null;
			
		}
		return newUser;
	}

	@Override
	public Iterable<User> findAllUsers() {
		Iterable<User> user = userRepository.findAll();
		return user;
	}

}
