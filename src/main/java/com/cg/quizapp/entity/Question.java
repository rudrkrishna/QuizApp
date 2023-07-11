package com.cg.quizapp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "question")
public class Question {
    private String questionDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @ElementCollection
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @MapKeyColumn(name = "option_key")
    @Column(name = "option_value")
    private Map<Integer, String> options;
    private Integer answer;
}
