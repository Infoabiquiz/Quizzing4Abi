package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Tung on 27.06.2015.
 * This class represents an Answer to a Question.
 */

public class Answer
{
    private boolean isCorrect;
    private String answerText;

    /**
     * Constructor.
     * @param isCorrect  correctness of this answer
     * @param answerText contains the text of the Answer or the image name
     */
    public Answer(boolean isCorrect, String answerText)
    {
        this.isCorrect = isCorrect;
        this.answerText = answerText;
    }

    /**
     * Returns the correctness of this Answer.
     * @return correctness of this Answer
     */
    public boolean isCorrect()
    {
        return isCorrect;
    }

    /**
     * Returns the text of the answer or the image name.
     * @return String of the answer Text
     */
    public String getAnswersText()
    {
        return answerText;
    }
}
