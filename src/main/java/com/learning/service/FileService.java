package com.learning.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    Map<String, Object> uploadSingle(MultipartFile file);

}
