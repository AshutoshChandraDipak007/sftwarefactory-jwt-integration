package com.org.jwt.pkg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.jwt.pkg.model.Announcement;
import com.org.jwt.pkg.repo.AnnouncementRepo;

import jakarta.annotation.PostConstruct;



@Service
public class AnnouncementService {
	
	@Autowired
	AnnouncementRepo repo;
	
	@PostConstruct
	public void saveDummyUser(){
		repo.save(new Announcement(123,"22-Aug-2023","description","impactedServices","type","PROD","23-Oct-2024","23-Sept-2024"));
	}
	

	public List<Announcement> getData(){
		return (List<Announcement>) repo.findAll();	
	}
	
	public List<Announcement> deleteData(Integer id){		
			repo.deleteById(id);		
	 return (List<Announcement>) repo.findAll();		
	}
	
	public List<Announcement> createAnnouncementData(Announcement announcement){
		repo.save(announcement);
		return (List<Announcement>) repo.findAll();		
	}
}
