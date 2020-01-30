package com.sivalabs.myservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicationProperties {

    @Value("${githuub.api.base-url}")
    private String githubBaseUrl;

	public String getGithubBaseUrl() {
		return githubBaseUrl;
	}
}
