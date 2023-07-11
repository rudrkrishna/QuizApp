package com.cg.quizapp.service;

import com.cg.quizapp.entity.Question;
import com.cg.quizapp.entity.TestQuestion;
import com.cg.quizapp.exceptions.QuestionNotFoundException;
import com.cg.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Question addQuestion(Question question){
        Question q= quizRepository.save(question);
        return q;
    }

    public List<Question> getAllQuestions() {

        return quizRepository.findAll();

    }

    public List<TestQuestion> startTest() {
        List<TestQuestion> li= new ArrayList<>();
        List<Question> all= quizRepository.findAll();
        for(Question q:all){
            TestQuestion question= new TestQuestion();
            question.setQuestionDescription(q.getQuestionDescription());
            question.setOptions(q.getOptions());
            question.setQuestionId(q.getQuestionId());
            li.add(question);
        }

        return li;

    }

    public String checkTestScore(List<TestQuestion> testQuestions) throws QuestionNotFoundException{
        int testScore=0;
        for(TestQuestion t:testQuestions){
            Optional<Question> q= quizRepository.findById(t.getQuestionId());
            if(q.isPresent()  ){
                if(q.get().getAnswer().equals(t.getAnswer()))
                    testScore++;
            }
            else{
                throw new QuestionNotFoundException("Question Not found with ID: "+t.getQuestionId());
            }
        }
        return "Your Score is : "+testScore;
    }
}
