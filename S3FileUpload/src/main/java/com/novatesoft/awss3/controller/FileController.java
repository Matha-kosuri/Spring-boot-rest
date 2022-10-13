package com.novatesoft.awss3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.novatesoft.awss3.service.S3FileService;

@RestController
public class FileController {
	@Autowired
	private S3FileService s3FileService;
	
	@RequestMapping("")
	public List<String> getFile() {
		return s3FileService.getAllFiles();
		
	}
	
    @PostMapping("upload")	
    public String upLoad(@RequestParam("file") MultipartFile file) {
    	System.out.println("the filename is"+file.getOriginalFilename());
    	return s3FileService.uploadFile(file);
    }
    
    @DeleteMapping("{filename}")
    	public ResponseEntity<String>  deleteFile(@PathVariable("filename")String filename) {
    	System.out.println("The file  to be deleted"+filename);
    	 s3FileService.deleteFile(filename);
    	  String response = "[" + filename + "] deleted successfully.";
         return new ResponseEntity<>(response, HttpStatus.OK);
    }
    	
    @GetMapping("download/{filename}")
     public byte[] downloadFile(@PathVariable("filename") String filename) {
    	 System.out.println("The file to be dowloaded"+filename);
          byte[]   downloadedfile= s3FileService.downloadFile(filename);
            return downloadedfile;
    		
    	}
    
    
    
  
	
}


