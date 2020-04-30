package com.julianherrera.springboot.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julianherrera.springboot.web.app.models.service.IUploadFileService;

@SpringBootApplication
public class SaberLqApplication implements CommandLineRunner{

	@Autowired
	private IUploadFileService uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SaberLqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}

	
}
