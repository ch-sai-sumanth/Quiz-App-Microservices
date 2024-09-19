package com.springMicroservices.question_service.controller;

import com.springMicroservices.question_service.model.Question;
import com.springMicroservices.question_service.model.QuestionWrapper;
import com.springMicroservices.question_service.model.Response;
import com.springMicroservices.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("generate")
    public ResponseEntity<List<Integer>> creteQuiz(@RequestParam String category,@RequestParam int noOfQuestions){
        return questionService.createQuiz(category,noOfQuestions);
    }

    @PostMapping("score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responseList){
        return questionService.calculateScore(responseList);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionIds){
        return questionService.getQuestions(questionIds);
    }
}
