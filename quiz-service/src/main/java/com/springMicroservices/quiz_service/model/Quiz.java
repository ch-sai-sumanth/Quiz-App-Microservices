package com.springMicroservices.quiz_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;

    @ElementCollection
    List<Integer> questionNos;
}
