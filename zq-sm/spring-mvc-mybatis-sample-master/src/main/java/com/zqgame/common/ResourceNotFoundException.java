package com.zqgame.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private Long resourceId;

	public ResourceNotFoundException(Long resourceId) {
		this.resourceId = resourceId;
	}

	public ResourceNotFoundException(int resourceId) {
		this.resourceId = (long)resourceId;
	}

	public Long getResourceId() {
		return resourceId;
	}

}
