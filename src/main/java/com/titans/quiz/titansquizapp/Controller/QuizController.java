package com.titans.quiz.titansquizapp.Controller;

import com.titans.quiz.titansquizapp.DAO.QuestionTableDAO;
import com.titans.quiz.titansquizapp.DAO.QuestionTableRepository;
import com.titans.quiz.titansquizapp.TableClass.QuestionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuestionTableRepository questionTableRepository;

    @Autowired
    QuestionTableDAO questionTableDAO;

    @GetMapping(value = "/getQuestions")
    public List<QuestionTable> getQuestionsList() {
        return questionTableRepository.findAll();
    }

    @PostMapping(value = "/postQuestion")
    public List<QuestionTable> saveQuestion(@RequestBody QuestionTable questionTable) {
        questionTableRepository.save(questionTable);
        return questionTableRepository.findAll();
    }

    @PostMapping(value = "/updateQuestion")
    public List<QuestionTable> updateQuestion(@RequestBody  QuestionTable questionTable) {
        questionTableDAO.update(questionTable);
        return questionTableRepository.findAll();
    }

    @DeleteMapping(value = "/deleteQuestion/{id}")
    public List<QuestionTable> deleteQuestion(@PathVariable(name = "id") long id) {
        questionTableRepository.deleteById(id);
        return questionTableRepository.findAll();
    }

    @DeleteMapping(value = "/deleteAllQuestions")
    public String deleteAllQuestions(){
        questionTableRepository.deleteAll();;
        return "All rows Deleted";
    }

}
