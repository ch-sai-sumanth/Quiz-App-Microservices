package com.springMicroservices.question_service.service;

import com.springMicroservices.question_service.dao.QuestionDao;
import com.springMicroservices.question_service.model.Question;
import com.springMicroservices.question_service.model.QuestionWrapper;
import com.springMicroservices.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> allQuestions= questionDao.findAll();

        if(!allQuestions.isEmpty()){
            return new ResponseEntity<>(allQuestions, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<Integer>> createQuiz(String category, int noOfQuestions) {

        List<Integer> randomQuestionIdsByCategory=questionDao.findQuestionByCategory(category,noOfQuestions);

        return new ResponseEntity<>(randomQuestionIdsByCategory,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(List<Response> responseList) {
        //In response we have the question Id and the submitted answer

        int right=0;
        for( Response response : responseList){

            Question question= questionDao.findById(response.getId()).get();

            if(question.getRightAnswer().equals( response.getResponse()))
                right++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> questionIds) {

        List<QuestionWrapper> wrapperList = new ArrayList<>();

        for(Integer id : questionIds){
            Question question=questionDao.findById(id).get();

            QuestionWrapper wrapper = new QuestionWrapper
                    (question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());

            wrapperList.add(wrapper);
        }
        return new ResponseEntity<>(wrapperList,HttpStatus.OK);
    }
}
