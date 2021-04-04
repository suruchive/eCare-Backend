package com.example.demo.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ECareIncidentDetails;
import com.example.demo.service.eCareIncidentService;

@RestController
@RequestMapping("eCare/v4")
@CrossOrigin(origins = "http://localhost:4200")
public class ECareIncidentController {

	
	@Autowired
	Environment env;
	
	@Autowired
	eCareIncidentService eService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/eCare-incidents/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<ECareIncidentDetails> retrieveIncidents()
	{
		return eService.list();
			
	}
	
	@GetMapping(path="/eCare-incident/incident_id/{incident_id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ECareIncidentDetails retrieveIncident(@PathVariable Long incident_id)
	{
		return eService.get(incident_id);
			
	}
	
	@PostMapping(path = "/add-incident", produces = MediaType.TEXT_HTML_VALUE)
	public String addIncident(@RequestBody ECareIncidentDetails eCareIncidentDetails)
	{ 
		ECareIncidentDetails addedIncident= eService.add(eCareIncidentDetails);
		return "Incident created with Id :: "+addedIncident.getIncident_id();
				
	}
	
	/*
	 * @PutMapping(path = "/update-incident/incident_id/{incident_id}") public
	 * String updateIncident(@PathVariable Long incident_id,@RequestBody
	 * ECareIncidentDetails eCareIncidentDetails) { ECareIncidentDetails
	 * addedIncident= eService.add(eCareIncidentDetails); return
	 * "Incident having Id :: "+addedIncident.getIncident_id()
	 * +" has been updated ";
	 * 
	 * }
	 */
	
	@PutMapping(path = "/update-incident/incident_id/{incident_id}", produces = MediaType.TEXT_HTML_VALUE)
	public String updateIncident(@PathVariable Long incident_id,@RequestBody ECareIncidentDetails eCareIncidentDetails)
	{ 
		ECareIncidentDetails addedIncident= eService.add(eCareIncidentDetails);
		return "Incident having Id :: "+addedIncident.getIncident_id() +" has been updated ";
				
	}
	
	@DeleteMapping(path = "/delete-incident/incident_id/{incident_id}", produces = MediaType.TEXT_HTML_VALUE)
	public String deleteIncident(@PathVariable Long incident_id)
	{ 
		eService.delete(incident_id);
		return "Incident having Id :: "+incident_id +" has been deleted ";
				
	}
	
}
