package com.lfg.informatik.q11.quizzing4abi;

import com.lfg.informatik.q11.quizzing4abi.model_io.SAXDocumentHandler;
import com.lfg.informatik.q11.quizzing4abi.model_io.StatisticsLoader;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Chris on 07.07.2015.
 * Provides reading and writing access to all game statistics and stores them.
 */

public class StatisticsManager // TODO: Change to Streams
{
    private static final String statisticsFilename = "app\\src\\main\\res\\raw\\statistics.xml";

    private static List<GameStatistics> allGameStatistics;

    /**
     * Loads the statistics, if they aren´t loaded, and returns them.
     * @return List of all game statistics or null if loading failed
     */
    public static List<GameStatistics> getAllGameStatistics()
    {
        if(allGameStatistics == null)
        {
            try
            {
                StatisticsLoader statisticsLoader = new StatisticsLoader();
                SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(statisticsLoader);

                saxDocumentHandler.parse(statisticsFilename);

                allGameStatistics = statisticsLoader.takeAllGameStatistics();
            }
            catch (SAXException | ParserConfigurationException | IOException e)
            {
                ExceptionHandler.showAlertDialog("Loading statistics failed. Error: "
                        + e.getMessage());
                return null;
            }
        }

        return allGameStatistics;
    }

    // TODO: Implement add method
}
