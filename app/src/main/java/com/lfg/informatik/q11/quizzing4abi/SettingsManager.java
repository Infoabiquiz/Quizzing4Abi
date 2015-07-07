package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by Chris on 04.07.2015.
 * Provides reading and writing access to the settings and stores them.
 */

public class SettingsManager
{
    private static final String settingsFilename = "app\\src\\main\\res\\raw\\settings.xml";

    private static String backgroundColor = null;

    /**
     * Loads the settings, if they aren´t loaded, and returns the background color.
     * @return the background color or "" if loading the color failed
     */
    public static String getBackgroundColor()
    {
        if(backgroundColor == null) // then load it
        {
            try
            {
                SettingsLoader settingsLoader = new SettingsLoader();
                SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(settingsLoader);

                saxDocumentHandler.parse(settingsFilename);

                backgroundColor = settingsLoader.getBackgroundColor();
            }
            catch(ParserConfigurationException | SAXException | IOException e)
            {
                ExceptionHandler.showAlertDialog("Loading settings failed. Error: "
                        + e.getMessage());
                return "";
            }
        }

        return backgroundColor;
    }

    /**
     * Saves the new background color and changes the stored one.
     * @param backgroundColor the background color
     * @return false if saving background color failed
     */
    public static boolean setBackgroundColor(String backgroundColor)
    {
        if(backgroundColor == null || backgroundColor.isEmpty())
            throw new IllegalArgumentException("Background color mustn´t be null or empty!");

        try
        {
            XMLWriter xmlWriter = new XMLWriter();

            xmlWriter.elementBegin("Settings");
            xmlWriter.elementBegin("BackgroundColor");
            xmlWriter.setAttribute(null, backgroundColor);

            xmlWriter.saveTo(settingsFilename);

            SettingsManager.backgroundColor = backgroundColor;
        }
        catch(ParserConfigurationException | TransformerException e)
        {
            ExceptionHandler.showAlertDialog("Saving settings failed. Error: " + e.getMessage());
            return false;
        }

        return true;
    }
}
