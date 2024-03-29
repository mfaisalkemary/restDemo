package com.spring.rest.restdemo.services;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.restdemo.model.Question;
import com.spring.rest.restdemo.model.Survey;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<Survey>();
	static {
		Question question1 = new Question("question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question2 = new Question("question2", "Most Populus Country in the World", "China",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question3 = new Question("question3", "Highest GDP in the World", "United States",
				Arrays.asList("India", "Russia", "United States", "China"));
		Question question4 = new Question("question4", "Second largest english speaking country", "India",
				Arrays.asList("India", "Russia", "United States", "China"));
		List<Question> questions = new ArrayList<Question>(Arrays.asList(question1, question2, question3, question4));

		Survey survey = new Survey("1", "my faviourite survey", "description", questions);

		surveys.add(survey);
	}

	public List retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurvey(String surveyId) {
		for (Survey survey : surveys) {
			if (survey.getId().equals(surveyId)) {
				return survey;
			}

		}
		return null;
	}

	public List<Question> retrieveQuestions(String surveyId) {
		Survey survey = retrieveSurvey(surveyId);
		if (survey == null) {
			return null;
		}
		return survey.getQuestions();
	}

	public Question retrieveQuestion(String surveyId, String questionId) {
		Survey survey = retrieveSurvey(surveyId);
		if (survey == null) {
			return null;
		}
		for (Question question : survey.getQuestions()) {
			if (question.getId().equals(questionId)) {
				return question;
			}
		}
		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Question addQuestion(String surveyId, Question question) {
		Survey survey = retrieveSurvey(surveyId);

		if (survey == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		question.setId(randomId);

		survey.getQuestions().add(question);

		return question;
	}

}
