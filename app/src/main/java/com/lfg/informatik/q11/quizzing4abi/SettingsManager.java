package com.lfg.informatik.q11.quizzing4abi;

import com.lfg.informatik.q11.quizzing4abi.model_io.FileIO;
import com.lfg.informatik.q11.quizzing4abi.model_io.SAXDocumentHandler;
import com.lfg.informatik.q11.quizzing4abi.model_io.SettingsLoader;
import com.lfg.informatik.q11.quizzing4abi.model_io.XMLWriter;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by Chris on 04.07.2015.
 * Provides reading and writing access to the settings and stores them.
 */

public class SettingsManager
{
    private static int backgroundColor = 0xFFFFFFFF;
    private static boolean settingsLoaded = false;

    /**
     * Loads the settings, if they aren´t loaded, and returns the background color.
     * @return the background color or 0 if loading the color failed
     */
    public static int getBackgroundColor()
    {
        if(!settingsLoaded && FileIO.checkFileExistence("settings.xml"))
        {
            InputStream inputStream = null;
            try
            {
                SettingsLoader settingsLoader = new SettingsLoader();
                SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(settingsLoader);

                inputStream = FileIO.openInputFile("settings.xml");
                saxDocumentHandler.parse(inputStream);

                backgroundColor = settingsLoader.getBackgroundColor();

                settingsLoaded = true;
            }
            catch(ParserConfigurationException | SAXException | IOException e)
            {
                ExceptionHandler.showAlertDialog("Loading settings failed. Error: "
                        + e.getMessage());
                return 0;
            }
            finally
            {
                FileIO.closeStream(inputStream);
            }
        }

        return backgroundColor;
    }

    /**
     * Saves the new background color and changes the stored one.
     * @param backgroundColor the background color
     * @return false if saving background color failed
     */
    public static boolean setBackgroundColor(int backgroundColor)
    {
        OutputStream outputStream = null;
        try
        {
            XMLWriter xmlWriter = new XMLWriter();

            xmlWriter.elementBegin("Settings");
            xmlWriter.elementBegin("BackgroundColor");

            xmlWriter.setAttribute(null, '#' + Integer.toHexString(backgroundColor).toUpperCase());

            outputStream = FileIO.openOutputFile("settings.xml");
            xmlWriter.saveTo(outputStream);

            SettingsManager.backgroundColor = backgroundColor;
        }
        catch(ParserConfigurationException | TransformerException e)
        {
            ExceptionHandler.showAlertDialog("Saving settings failed. Error: " + e.getMessage());
            return false;
        }
        catch(FileNotFoundException e)
        {
            ExceptionHandler.showAlertDialog("Opening the settings file failed. Error: "
                    + e.getMessage());
            return false;
        }
        finally
        {
            FileIO.closeStream(outputStream);
        }

        return true;
    }
}
