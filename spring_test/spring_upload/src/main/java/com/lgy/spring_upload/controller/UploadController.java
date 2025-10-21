package com.lgy.spring_upload.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UploadController {
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("uploadForm~!!!");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		log.info("uploadFormPost()");
		
		String uploadFolder = "C:\\temp\\upload";
		for (MultipartFile multipartFile : uploadFile) {
			log.info("===============================");
//			getOriginalFilename : 업로드 되는 파일 이름
			log.info("@# 업로드 되는 파일 이름 =>"+multipartFile.getOriginalFilename());
//			getSize : 업로드 되는 파일 크기
			log.info("@# 업로드 되는 파일 크기 =>"+multipartFile.getSize());
			
//			saveFile : 경로하고 파일이름
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
//				transferTo : saveFile 내용을 저장
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping("/uploadJquery")
	public void uploadJquery() {
		log.info("uploadJquery~!!!");
	}
}

















