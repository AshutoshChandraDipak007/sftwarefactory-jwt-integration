package com.org.jwt.pkg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.jwt.pkg.model.Announcement;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Integer>{

}
