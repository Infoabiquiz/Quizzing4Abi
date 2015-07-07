package com.lfg.informatik.q11.quizzing4abi.model_io;

import com.lfg.informatik.q11.quizzing4abi.ExceptionHandler;
import com.lfg.informatik.q11.quizzing4abi.GameStatistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris on 07.07.2015.
 * This XMLHandler implementation loads the global game statistics.
 */

public class StatisticsLoader implements XMLHandler
{
    private String currentTag;
    private String datePlayed;
    private String secondsPlayed;
    private String correctnessRate;
    private String averageDifficulty;
    private List<GameStatistics> allGameStatistics;

    /**
     * Constructor.
     */
    public StatisticsLoader()
    {
        allGameStatistics = new LinkedList<>();
    }

    /**
     * After the building process has finished, calling this method will return the List of built
     * GameStatistics and transfer ownership to the caller.
     * @return List of built GameStatistics
     */
    public List<GameStatistics> takeAllGameStatistics()
    {
        List<GameStatistics> temp = new LinkedList<>(allGameStatistics);
        allGameStatistics = new LinkedList<>();
        return temp;
    }

    /**
     * Has to be called at the occurrence of each beginning tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagBegin(String tagName)
    {
        currentTag = tagName;
    }

    /**
     * Has to be called for each ending tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagEnd(String tagName)
    {
        if(tagName.equals("GameStatistics"))
        {
            try
            {
                Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss",
                        Locale.getDefault()).parse(datePlayed);

                allGameStatistics.add(new GameStatistics(date,
                        Long.valueOf(secondsPlayed).longValue(),
                        Float.valueOf(correctnessRate).floatValue(),
                        Float.valueOf(averageDifficulty).floatValue()));
            }
            catch (ParseException e)
            {
                ExceptionHandler.showAlertDialog("Loading GameStatistics failed. Error: " + e.getMessage());
            }
        }
    }

    /**
     * Has to be called for each attribute.
     * @param attributeName name of the attribute or null/"" for a text node
     * @param content       content of the attribute
     */
    @Override
    public void attribute(String attributeName, String content)
    {
        switch (currentTag)
        {
            case "Date":
                datePlayed = content;
                break;
            case "Duration":
                secondsPlayed = content;
                break;
            case "CorrectnessRate":
                correctnessRate = content;
                break;
            case "AverageDifficulty":
                averageDifficulty = content;
                break;
        }
    }
}
