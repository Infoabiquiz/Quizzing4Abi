package com.lfg.informatik.q11.quizzing4abi;

import java.util.Date;

/**
 * Created by Chris on 07.07.2015.
 * Saves data about the results/statistics of one single game.
 */

public class GameStatistics
{
    Date datePlayed;
    long secondsPlayed;
    float correctnessRate;
    float averageDifficulty;

    /**
     * Constructor.
     * @param datePlayed the day the game was played
     * @param secondsPlayed the duration of the game in seconds
     * @param correctnessRate the percentage of correct answered Questions
     * @param averageDifficulty the average Question difficulty
     */
    public GameStatistics(long secondsPlayed, Date datePlayed, float correctnessRate,
                          float averageDifficulty)
    {
        this.secondsPlayed = secondsPlayed;
        this.datePlayed = datePlayed;
        this.correctnessRate = correctnessRate;
        this.averageDifficulty = averageDifficulty;
    }

    /**
     * Returns the date when the game was played.
     * @return the day the game was played
     */
    public Date getDatePlayed()
    {
        return datePlayed;
    }

    /**
     * Returns the duration of the game in seconds.
     * @return the duration of the game in seconds
     */
    public long getSecondsPlayed()
    {
        return secondsPlayed;
    }

    /**
     * Returns the percentage of correct answered Questions.
     * @return the percentage of correct answered Questions
     */
    public float getCorrectnessRate()
    {
        return correctnessRate;
    }

    /**
     * Returns the average Question difficulty.
     * @return the average Question difficulty
     */
    public float getAverageDifficulty()
    {
        return averageDifficulty;
    }
}
