package com.bbva.cgto.dto.response;

import java.io.Serializable;


/**
 * The ResponseDTO class...
 */
public class ResponseDTO implements Serializable  {
	private static final long serialVersionUID = 2931699728946643245L;

	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseDTO{" +
				"response='" + response + '\'' +
				'}';
	}
}
