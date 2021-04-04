package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.ECareIncidentDetails;
import com.example.demo.repository.ECareIncidentRepo;


@Service
@CrossOrigin(origins = "http://localhost:4200")
public class eCareIncidentService {

    private ECareIncidentRepo eCareIncidentRepo;

    public eCareIncidentService(ECareIncidentRepo eCareIncidentRepo) {
        this.eCareIncidentRepo = eCareIncidentRepo;
    }

    public ArrayList<ECareIncidentDetails> list() {
       // return eCareIncidentRepo.findAll();
        return (ArrayList<ECareIncidentDetails>) eCareIncidentRepo.findAll();
    }

    public java.util.List<ECareIncidentDetails> save(List<ECareIncidentDetails> incidents) {
        return eCareIncidentRepo.saveAll(incidents);
    }

	public ECareIncidentDetails add(ECareIncidentDetails eCareIncidentDetails) {
		eCareIncidentRepo.save(eCareIncidentDetails);
		if (eCareIncidentRepo.existsById(eCareIncidentDetails.getIncident_id()))
		{
			eCareIncidentRepo.save(eCareIncidentDetails);
		}
		else
		{
			return new ECareIncidentDetails();
		}
		Optional<ECareIncidentDetails> newlyCreateedIncident = eCareIncidentRepo.findById(eCareIncidentDetails.getIncident_id());
		return newlyCreateedIncident.orElse(new ECareIncidentDetails());
		
	}

	
	public void delete(Long incident_id) {
		if (eCareIncidentRepo.existsById(incident_id))
		{
			eCareIncidentRepo.deleteById(incident_id);
		}
		
		
	}

	public ECareIncidentDetails get(Long incident_id) {
		Optional<ECareIncidentDetails> eCareIncidentDetails = null;
		if (eCareIncidentRepo.existsById(incident_id))
		{
			eCareIncidentDetails= eCareIncidentRepo.findById(incident_id);
		}
		 return eCareIncidentDetails.orElseThrow();
		
	}
}

