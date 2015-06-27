package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Tung on 27.06.2015.
 */
public class Answer
{
    public boolean correct;
    public String answerText;

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
     * Returns answerText boolean Value
     * @return True or False
     */
    boolean iscorrect()
    {
        return correct;
    }

    /**
     * Returns AnswerText
     * @return String of Answertext
     */
    String getAnswersText()
    {
        return answerText;
    }
}
