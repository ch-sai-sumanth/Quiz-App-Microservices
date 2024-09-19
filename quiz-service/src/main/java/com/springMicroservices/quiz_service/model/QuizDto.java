package com.springMicroservices.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {

    String category;
    int noOfQuestions;
    String title;
}
