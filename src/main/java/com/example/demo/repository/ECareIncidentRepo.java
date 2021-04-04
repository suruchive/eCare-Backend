package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.ECareIncidentDetails;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ECareIncidentRepo extends JpaRepository<ECareIncidentDetails, Long> {

	
}
