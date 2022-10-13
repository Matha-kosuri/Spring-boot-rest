package com.novatesoft.awss3.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3FileServiceImpl {
	
	String  uploadFile(MultipartFile fileName);
	void deleteFile(String fileName);
	byte[]  downloadFile(String fileName);
	List<String>  getAllFiles();
	
	
}
