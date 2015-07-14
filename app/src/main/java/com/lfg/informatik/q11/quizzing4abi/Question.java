package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 27.06.2015.
 * This class represents a Question with the Answers for the Quiz.
 */

public class Question
{
    private String questionText;
    private List<Answer> answers;
    private int difficulty; // leicht = 1, mittel = 2, schwer = 3

    /**
     * Constructor.
     * @param questionText text of the question or image name
     * @param answers      list of the answer objects belonging to the Question
     * @param difficulty   difficulty of this Question
     */
    public Question(String questionText, List<Answer> answers, int difficulty)
    {
        this.questionText = questionText;
        this.answers = answers;
        this.difficulty = difficulty;
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

    /**
     * Returns the difficulty of this question.
     * @return the difficulty of this question as int. (1,2 or 3)
     */
    public int getDifficulty()
    {
        return difficulty;
    }
}
