package com.lfg.informatik.q11.quizzing4abi;

import java.util.Timer;

/**
 * Created by Adrian on 05.07.2015.
 */
public class AnsweredQuestion {
    Question question;
    boolean correctanswered;
    long duration;

    /**
     * Constructor
     * @param question the question
     * @param correctanswered true or false answered
     * @param duration time taken to answer the question
     */

    AnsweredQuestion(Question question, boolean correctanswered, long duration)
    {
        this.question=question;
        this.correctanswered=correctanswered;
        this.duration=duration;
    }

    /**
     * gets question
     * @return question
     */
    public Question getQuestion() {        return question;    }

    /**
     * Returns boolean of correctanswered
     * @return correctanswered
     */
    public boolean isCorrectAnswered() {        return correctanswered;    }

    /**
     * Returns the time
     * @return duration
     */
    public long getDuration() {        return duration;    }
}

