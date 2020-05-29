package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bns.model.Response;
import com.bns.service.FileStorageService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class FileUploadController {

	@Autowired
    private FileStorageService fileStorageService;
	
	 @PostMapping("/uploadFile")
	    public Response uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/downloadFile/")
	            .path(fileName)
	            .toUriString();

	        return new Response(fileName, fileDownloadUri,
	            file.getContentType(), file.getSize());
	    }
	
}
