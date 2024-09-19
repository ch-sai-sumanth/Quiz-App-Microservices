package com.springMicroservices.quiz_service.service;

import com.springMicroservices.quiz_service.dao.QuizDao;
import com.springMicroservices.quiz_service.feign.QuizInterface;
import com.springMicroservices.quiz_service.model.QuestionWrapper;
import com.springMicroservices.quiz_service.model.Quiz;

import com.springMicroservices.quiz_service.model.Response;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;


    public String createQuiz(String category, int noOfQuestions, String title) {
        List<Integer> questionIds = quizInterface.creteQuiz(category,noOfQuestions).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionNos(questionIds);
        quizDao.save(quiz);

        return "Quiz Created";
    }

    public ResponseEntity<Integer> calculateResult(int quizId,List<Response> response) {

        ResponseEntity<Integer> score = quizInterface.getScore(response);
       return score;
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestions(int quizId) {
        List<Integer> questionNos = quizDao.findById(quizId).get().getQuestionNos();
        List<QuestionWrapper> questions = quizInterface.getQuestions(questionNos).getBody();
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }
}
