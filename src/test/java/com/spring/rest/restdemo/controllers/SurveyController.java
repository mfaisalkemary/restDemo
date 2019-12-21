package com.spring.rest.restdemo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.rest.restdemo.model.Question;
import com.spring.rest.restdemo.services.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	SurveyService service;

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrivequestions(@PathVariable String surveyId) {
		return service.retrieveQuestions(surveyId);
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		return service.retrieveQuestion(surveyId, questionId);
	}

	@GetMapping("/os")
	public String retriveos() {
		return System.getProperty("os.name");
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestion(@PathVariable String surveyId, @RequestBody Question question1) {
		Question addedQuestion= service.addQuestion(surveyId, question1);
		
		if (addedQuestion == null) {
			return ResponseEntity.noContent().build();
		}
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(addedQuestion.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
