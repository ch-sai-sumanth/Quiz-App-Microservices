package com.springMicroservices.quiz_service.controller;

import com.springMicroservices.quiz_service.model.QuestionWrapper;
import com.springMicroservices.quiz_service.model.QuizDto;
import com.springMicroservices.quiz_service.model.Response;
import com.springMicroservices.quiz_service.service.QuizService;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public String createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategory(),quizDto.getNoOfQuestions(),quizDto.getTitle());
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int quizId,@RequestBody List<Response> response){
        return quizService.calculateResult(quizId,response);
    }

    @PostMapping("getQuiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable int quizId){
        return quizService.getQuestions(quizId);
    }
}
