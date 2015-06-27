package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;

/**
 * Created by Chris on 27.06.2015.
 * This class represents a Question with the Answer for the Quiz.
 */

public class Question
{
    private String questionText;
    private ArrayList<Answer> answers;

    /**
     * Constructor.
     * @param questionText text of the question or image path
     * @param answers list of the answer objects belonging to the Question
     */
    public Question(String questionText, ArrayList<Answer> answers)
    {
        this.questionText = questionText;
        this.answers = answers;
    }

    /**
     * Returns the question text.
     * @return text of question or image path
     */
    String getQuestionText()
    {
        return questionText;
    }

    /**
     * Returns the belonging answers.
     * @return the list pf answers
     */
    ArrayList<Answer> getAnswers()
    {
        return answers;
    }
}
