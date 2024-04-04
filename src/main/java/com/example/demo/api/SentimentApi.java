package com.example.demo.api;

import com.example.demo.api.response.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@AllArgsConstructor
public class SentimentApi {

	public ScoreResponse scoreText(String input) {

		WebClient client = WebClient.create("https://twinword-sentiment-analysis.p.rapidapi.com/analyze/");
		
		return client.get()
			.uri("?text=" + input).accept(MediaType.APPLICATION_JSON)
			.header("X-RapidAPI-Key", "YOUR-API-KEY")
			.header("X-RapidAPI-Host", "twinword-sentiment-analysis.p.rapidapi.com")
			.retrieve()
			.toEntity(ScoreResponse.class).block().getBody();
	}

	public ProfanityResponse sanitiseString(String input) {

		WebClient client = WebClient.create("http://api1-ap.webpurify.com/services/rest/");
		
		return client.get()
			.uri("?method=webpurify.live.replace&api_key=YOUR-API-KEY&text=" + input + "&replacesymbol=*&format=json")
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.toEntity(FullResponse.class).block().getBody().getRsp();
	}
}