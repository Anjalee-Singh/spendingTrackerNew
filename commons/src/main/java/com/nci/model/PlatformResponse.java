package com.nci.model;

import com.fasterxml.jackson.databind.JsonNode;

public class PlatformResponse {

	private Status status;
	private JsonNode data;

	public PlatformResponse(Status status,  JsonNode data) {
		this.status = status;
		this.data = data;
	}
	
	public PlatformResponse(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public JsonNode getData() {
		return data;
	}


}
