package com.example.demo.api.response;

import lombok.Data;

@Data
public class ProfanityResponse {
	private String found;
	private String text; // sanitized
}