package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "ecareincidentdetails")
public class ECareIncidentDetails {
	public Long getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(Long incident_id) {
		this.incident_id = incident_id;
	}

	public Long getCustomer_requestid() {
		return customer_requestid;
	}

	public void setCustomer_requestid(Long customer_requestid) {
		this.customer_requestid = customer_requestid;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getIssue_Description() {
		return issue_Description;
	}

	public void setIssue_Description(String issue_Description) {
		this.issue_Description = issue_Description;
	}

	@Override
	public String toString() {
		return "ECareIncidentDetails [incident_id=" + incident_id + ", customer_requestid=" + customer_requestid
				+ ", customer_name=" + customer_name + ", issue_Description=" + issue_Description + "]";
	}

	@Id
	@Column(name="incident_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long incident_id;
	
	@Column(name="customer_requestid")
	private Long customer_requestid;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@Column(name="issue_Description")
	private String issue_Description;
}
