package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;

/**
 * Created by Adrian on 27.06.2015.
 */

public class Category
{
    private String questionCategory;
    private ArrayList<Question> questions;

    public Category (String questionCategory, ArrayList<Question> questions)
    {
        this.questionCategory = questionCategory;
        this.questions = questions;
    }

    String getCategoryName()
    {
        return questionCategory;
    }

    ArrayList<Question> getQuestions()
    {
        return questions;
    }
}
