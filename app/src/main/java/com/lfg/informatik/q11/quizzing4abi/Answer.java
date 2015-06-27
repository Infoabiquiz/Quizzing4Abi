package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Tung on 27.06.2015.
 */

public class Answer
{
    private boolean correct;
    private String answerText;

    /**
     * Constructor.
     * @param correct Value hold True or False
     * @param answerText contains the Text of an Answer
     */
    public Answer(boolean correct, String answerText)
    {
        this.correct = correct;
        this.answerText = answerText;
    }

    /**
     * Returns Value of Answers True or False
     * @return True or False
     */
    boolean iscorrect()
    {
        return correct;
    }

    /**
     * Returns Text of Answers
     * @return String of Answertext
     */
    String getAnswersText()
    {
        return answerText;
    }
}
