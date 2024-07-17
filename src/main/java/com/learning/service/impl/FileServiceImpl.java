package com.learning.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learning.service.FileService;
import com.learning.utils.GlobalPathUtils;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public Map<String, Object> uploadSingle(MultipartFile file) {		
	    String fileName = UUID.randomUUID().toString();
        int lastIndexOfDot = file.getOriginalFilename().lastIndexOf(".");
        String extension = file.getOriginalFilename().substring(lastIndexOfDot);
        fileName += extension;

        System.out.println(extension);
        System.out.println(fileName);

        // Create path object
        Path path = Paths.get(GlobalPathUtils.fileServerPath + fileName);

        // Copy file to server path
        try {
            Files.copy(file.getInputStream(), path);
            Map<String, Object> result = new HashMap<>();
            result.put("isUploaded", true);
            result.put("fileName", fileName);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}

}
