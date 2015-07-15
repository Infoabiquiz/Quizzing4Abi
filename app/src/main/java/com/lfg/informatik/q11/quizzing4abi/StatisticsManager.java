package com.lfg.informatik.q11.quizzing4abi;

import com.lfg.informatik.q11.quizzing4abi.model_io.FileIO;
import com.lfg.informatik.q11.quizzing4abi.model_io.SAXDocumentHandler;
import com.lfg.informatik.q11.quizzing4abi.model_io.StatisticsLoader;
import com.lfg.informatik.q11.quizzing4abi.model_io.XMLWriter;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by Chris on 07.07.2015.
 * Provides reading and writing access to all game statistics and stores them.
 */

public class StatisticsManager
{
    private static List<GameStatistics> allGameStatistics;

    /**
     * Loads the statistics, if they aren´t loaded, and returns them.
     * @return List of all game statistics or null if loading failed
     */
    public static List<GameStatistics> getAllGameStatistics()
    {
        if(allGameStatistics == null && FileIO.checkFileExistence("statistics.xml"))
        {
            InputStream inputStream = null;
            try
            {
                StatisticsLoader statisticsLoader = new StatisticsLoader();
                SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(statisticsLoader);

                inputStream = FileIO.openInputFile("statistics.xml");
                saxDocumentHandler.parse(inputStream);

                allGameStatistics = statisticsLoader.takeAllGameStatistics();
            }
            catch (SAXException | ParserConfigurationException | IOException e)
            {
                ExceptionHandler.showAlertDialog("Loading statistics failed. Error: "
                        + e.getMessage());
                return null;
            }
            finally
            {
                FileIO.closeStream(inputStream);
            }
        }

        return allGameStatistics;
    }

    /**
     * Adds a new GameStatistics to the list of all game statistics and saves them to the
     * statistics.xml file.
     * @param gameStatistics a valid GameStatistics
     * @return true if writing was successful
     */
    public static boolean addGameStatistics(GameStatistics gameStatistics)
    {
        if(gameStatistics == null)
            throw new IllegalArgumentException("GameStatistics must not be null!");

        // Load the statistics if they are not loaded yet.
        if(allGameStatistics == null)
            getAllGameStatistics();

        OutputStream outputStream = null;
        try
        {
            XMLWriter xmlWriter = new XMLWriter();

            allGameStatistics.add(gameStatistics);

            xmlWriter.elementBegin("Statistics");

            for(GameStatistics currentGameStatistics : allGameStatistics)
            {
                xmlWriter.elementBegin("GameStatistics");

                xmlWriter.elementBegin("Date");
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
                String dateAsString =
                        simpleDateFormat.format(currentGameStatistics.getDatePlayed());
                xmlWriter.setAttribute(null, dateAsString);
                xmlWriter.elementEnd();

                xmlWriter.elementBegin("Duration");
                xmlWriter.setAttribute(null,
                        Long.toString(currentGameStatistics.getSecondsPlayed()));
                xmlWriter.elementEnd();

                xmlWriter.elementBegin("CorrectnessRate");
                xmlWriter.setAttribute(null,
                        Float.toString(currentGameStatistics.getCorrectnessRate()));
                xmlWriter.elementEnd();

                xmlWriter.elementBegin("AverageDifficulty");
                xmlWriter.setAttribute(null,
                        Float.toString(currentGameStatistics.getAverageDifficulty()));
                xmlWriter.elementEnd();

                xmlWriter.elementEnd();
            }

            outputStream = FileIO.openOutputFile("statistics.xml");
            xmlWriter.saveTo(outputStream);

        }
        catch (ParserConfigurationException | TransformerException e)
        {
            ExceptionHandler.showAlertDialog("Adding statistics failed. Error: " + e.getMessage());
            return false;
        }
        catch (FileNotFoundException e)
        {
            ExceptionHandler.showAlertDialog("Opening the statistics file failed. " +
                    "Error: " + e.getMessage());
            return false;
        }
        finally
        {
            FileIO.closeStream(outputStream);
        }

        return true;
    }

    // TODO: Implement delete method
}
