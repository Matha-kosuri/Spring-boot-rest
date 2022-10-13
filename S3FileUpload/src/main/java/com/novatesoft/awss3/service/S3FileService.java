package com.novatesoft.awss3.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class S3FileService implements S3FileServiceImpl{
	@Autowired
	private AmazonS3 amazons3;
	
	@Value("${bucketName}")
	private String bucketName;

	@Override
	public String uploadFile(MultipartFile fileName) {
		String originalFileName = fileName.getOriginalFilename();
		File file1;
		PutObjectResult por = null;
		try {
			
			file1 = convertMultipartTOFile(fileName);
			System.out.println(originalFileName);
		    por=amazons3.putObject(bucketName,originalFileName,file1);
		   } catch (IOException e) {
		      e.printStackTrace();
		}
		
		return por.getContentMd5();
		
	}

	

	@Override
	public void deleteFile(String fileName) {
		 DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileName);
		 amazons3.deleteObject(deleteObjectRequest);
	}

	@Override
	public byte[] downloadFile(String fileName) {
		byte[] b = null;
		S3Object s3obj=amazons3.getObject(bucketName, fileName);
		S3ObjectInputStream s3inputobj=s3obj.getObjectContent();
		try {
			
		b= IOUtils.toByteArray(s3inputobj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<String> getAllFiles() {
		ListObjectsV2Result listObjResult=amazons3.listObjectsV2(bucketName);
		return listObjResult.getObjectSummaries().stream().map(o->o.getKey()).collect(Collectors.toList());
	}
	


	private File convertMultipartTOFile(MultipartFile fileName) throws IOException{
		File convFile = new File (fileName.getOriginalFilename());
		
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(fileName.getBytes());
		fos.close();
		return convFile;
	}
	

}
