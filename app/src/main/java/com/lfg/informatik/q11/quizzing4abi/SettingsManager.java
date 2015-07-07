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

    private static int backgroundColor = 0xFFFFFFFF;
    private static boolean settingsLoaded = false;

    /**
     * Loads the settings, if they aren´t loaded, and returns the background color.
     * @return the background color or 0 if loading the color failed
     */
    public static int getBackgroundColor()
    {
        if(!settingsLoaded)
        {
            try
            {
                SettingsLoader settingsLoader = new SettingsLoader();
                SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(settingsLoader);

                saxDocumentHandler.parse(settingsFilename);

                backgroundColor = settingsLoader.getBackgroundColor();

                settingsLoaded = true;
            }
            catch(ParserConfigurationException | SAXException | IOException e)
            {
                ExceptionHandler.showAlertDialog("Loading settings failed. Error: "
                        + e.getMessage());
                return 0;
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
        try
        {
            XMLWriter xmlWriter = new XMLWriter();

            xmlWriter.elementBegin("Settings");
            xmlWriter.elementBegin("BackgroundColor");
            xmlWriter.setAttribute(null, String.valueOf(backgroundColor));

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
