package com.springMicroservices.question_service.dao;

import com.springMicroservices.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    @Query(value = "SELECT q.id from question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noOfQuestions",nativeQuery = true)
    List<Integer> findQuestionByCategory(String category, int noOfQuestions);
}
