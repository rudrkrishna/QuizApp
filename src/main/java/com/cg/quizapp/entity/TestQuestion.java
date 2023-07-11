package com.cg.quizapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TestQuestion {
    private Long questionId;
    private String questionDescription;
    private Map<Integer, String> options;
    private Integer answer;
}
