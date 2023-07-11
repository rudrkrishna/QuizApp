package com.cg.quizapp.controller;

import com.cg.quizapp.entity.Question;
import com.cg.quizapp.entity.TestQuestion;
import com.cg.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(quizService.addQuestion(question), HttpStatus.OK);

    }
    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(quizService.getAllQuestions(), HttpStatus.OK);
    }
    @GetMapping("/startTest")
    public ResponseEntity<List<TestQuestion>> startTest(){
        return new ResponseEntity<>(quizService.startTest(), HttpStatus.OK);
    }
    @PostMapping("/checkScore")
    public ResponseEntity<String> checkScore(@RequestBody List<TestQuestion> testQuestions){
        return new ResponseEntity<String>(quizService.checkTestScore(testQuestions), HttpStatus.OK);
    }


}
