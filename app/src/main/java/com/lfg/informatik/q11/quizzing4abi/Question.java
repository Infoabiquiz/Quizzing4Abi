package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 27.06.2015.
 * Reviewed.
 * This class represents a Question with the Answers for the Quiz.
 */

public class Question
{
    private String questionText;
    private List<Answer> answers;

    /**
     * Constructor.
     * @param questionText text of the question or image name
     * @param answers      list of the answer objects belonging to the Question
     */
    public Question(String questionText, List<Answer> answers)
    {
        this.questionText = questionText;
        this.answers = answers;
    }

    /**
     * Returns the question text.
     * @return text of question or image name
     */
    public String getQuestionText()
    {
        return questionText;
    }

    /**
     * Returns the belonging answers as readonly.
     * @return the unmodifiable list of answers
     */
    public List<Answer> getAnswers()
    {
        return Collections.unmodifiableList(answers);
    }
}
