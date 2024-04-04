package com.example.demo.api.response;

import lombok.Data;

@Data
public class ScoreResponse {
	private float score; // neutral = [-0.5,0.5]
	private String type; // positive/neutral/negative
}