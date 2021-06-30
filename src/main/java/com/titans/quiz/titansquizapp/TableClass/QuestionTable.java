package com.titans.quiz.titansquizapp.TableClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "QuestionDetails")
public class QuestionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    private String questionType;
    private String question;
    private String choice;
    private String answer;
    private String category;
    private String difficultyLevel;
    private String userId;

}
