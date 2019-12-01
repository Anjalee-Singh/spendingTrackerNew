package com.nci.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POJO to hold schema upsert response.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class CreateUpdateResponse {

	private String status;
	private String reason;
	private List<String> success = new ArrayList<>();
	private List<String> failed = new ArrayList<>();

	public List<String> getFailed() {
		return failed;
	}

	public List<String> getSuccess() {
		return success;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
