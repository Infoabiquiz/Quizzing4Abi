package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;

/**
 * Created by Adrian on 27.06.2015.
 */

public class Category
{
    private String questionCategory;
    private ArrayList<Question> questions;

    /**
     * Constructor.
     * @param questionCategory name of category
     * @param questions list of questions
     */
    public Category (String questionCategory, ArrayList<Question> questions)
    {
        this.questionCategory = questionCategory;
        this.questions = questions;
    }

    /**
     * Returns the category name.
     * @return name of category
     */
    String getCategoryName()
    {
        return questionCategory;
    }

    /**
     * Returns the questions.
     * @return list of questions
     */
    ArrayList<Question> getQuestions()
    {
        return questions;
    }
}
