package com.org.jwt.pkg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.jwt.pkg.model.Announcement;
import com.org.jwt.pkg.services.AnnouncementService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class AnnouncementController {
	
	@Autowired
	AnnouncementService service;
	
	@GetMapping("getannouncement")
	public ResponseEntity<List<Announcement>> getAnnouncements() {		
	 List<Announcement> list =service.getData();	 
	 return new ResponseEntity<>(list, HttpStatus.OK);	
	}
	
	@DeleteMapping("deleteannouncement/{id}")
	public ResponseEntity<List<Announcement>> deleteProduct(@PathVariable Integer id) {		
	 List<Announcement> list =service.deleteData(id);	 
	 return new ResponseEntity<>(list, HttpStatus.OK);	
	}
		
	@PostMapping("createannouncement")
	public ResponseEntity<List<Announcement>> createAnnouncement(@Valid @RequestBody Announcement anoouncement) {		
	 List<Announcement> list =service.createAnnouncementData(anoouncement);
	 return new ResponseEntity<>(list, HttpStatus.OK);	
	}	
	
	@PostMapping("updateannouncement")
	public ResponseEntity<List<Announcement>> updateAnnouncement(@Valid @RequestBody Announcement anoouncement) {		
	 List<Announcement> list =service.createAnnouncementData(anoouncement);
	 return new ResponseEntity<>(list, HttpStatus.OK);	
	}	

}
