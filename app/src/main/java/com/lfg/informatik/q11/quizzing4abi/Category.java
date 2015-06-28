package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 27.06.2015.
 * Reviewed.
 * This class represents a Category for the quiz (= school subject).
 * It contains the relevant Questions with the Answers.
 */

public class Category
{
    private String questionCategory;
    private List<Question> questions;

    /**
     * Constructor.
     * @param questionCategory name of category
     * @param questions list of questions
     */
    public Category (String questionCategory, List<Question> questions)
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
     * Returns the questions as readonly.
     * @return the unmodifiable list of questions
     */
    List<Question> getQuestions()
    {
        return Collections.unmodifiableList(questions);
    }
}
