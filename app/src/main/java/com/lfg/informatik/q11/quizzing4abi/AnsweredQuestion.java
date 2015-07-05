package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Adrian on 05.07.2015.
 * // TODO: Comment
 */

public class AnsweredQuestion
{
    private Question question;
    private boolean correctAnswered;
    private long duration;

    /**
     * Constructor.
     * @param question the answered question
     * @param correctAnswered true or false answered
     * @param duration time taken to answer the question
     */
    AnsweredQuestion(Question question, boolean correctAnswered, long duration)
    {
        this.question = question;
        this.correctAnswered = correctAnswered;
        this.duration = duration;
    }

    /**
     * Returns the answered Question.
     * @return the answered Question
     */
    public Question getQuestion()
    {
        return question;
    }

    /**
     * Returns true if the Question was answered correctly.
     * @return true if answered correctly
     */
    public boolean isCorrectAnswered()
    {
        return correctAnswered;
    }

    /**
     * Returns the time taken to answer the Question.
     * @return duration
     */
    public long getDuration()
    {
        return duration;
    }
}

