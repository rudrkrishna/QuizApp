package com.cg.quizapp.repository;

import com.cg.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuizRepository extends JpaRepository<Question,Long> {

}
