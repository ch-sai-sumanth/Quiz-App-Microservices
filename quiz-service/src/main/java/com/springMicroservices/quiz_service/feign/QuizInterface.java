package com.springMicroservices.quiz_service.feign;

import com.springMicroservices.quiz_service.model.QuestionWrapper;
import com.springMicroservices.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @PostMapping("question/generate")
    public ResponseEntity<List<Integer>> creteQuiz(@RequestParam String category, @RequestParam int noOfQuestions);

    @PostMapping("question/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responseList);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionIds);
}
