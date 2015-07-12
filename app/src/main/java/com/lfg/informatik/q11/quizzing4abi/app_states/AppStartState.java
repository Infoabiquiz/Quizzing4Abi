package com.lfg.informatik.q11.quizzing4abi.app_states;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.ExceptionHandler;
import com.lfg.informatik.q11.quizzing4abi.R;
import com.lfg.informatik.q11.quizzing4abi.model_io.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Chris on 30.06.2015.
 * The first state of the app after starting it.
 * Note: This class only provides loading functionality in the Constructor
 * and nothing else. It must´t create the following State by itself!
 */

public class AppStartState extends AppState
{
    /**
     * Constructor. Creates relevant internal storage files if they do not exist.
     * @param application a valid Application
     */
    public AppStartState(Application application)
    {
        super(application);

        application.setLayout(R.layout.app_start);

        // TODO: Write copy function raw to internal storage

        if(!FileIO.checkFileExistence("settings.xml"))
        {
            InputStream rawSettings = FileIO.openRawResource(R.raw.settings);

            OutputStream internalSettings = null;
            try
            {
                internalSettings = FileIO.openOutputFile("settings.xml");
                FileIO.inputToOutput(rawSettings, internalSettings);
            }
            catch (IOException e)
            {
                ExceptionHandler.showAlertDialog("Internal settings could not be created. Error: "
                        + e.getMessage());
                return;
            }
            finally
            {
                FileIO.closeStream(rawSettings);
                FileIO.closeStream(internalSettings);
            }
        }

        if(!FileIO.checkFileExistence("statistics.xml"))
        {
            InputStream rawSettings = FileIO.openRawResource(R.raw.statistics);

            OutputStream internalStatistics = null;
            try
            {
                internalStatistics = FileIO.openOutputFile("statistics.xml");
                FileIO.inputToOutput(rawSettings, internalStatistics);
            }
            catch (IOException e)
            {
                ExceptionHandler.showAlertDialog("Internal statistics could not be created. Error: "
                        + e.getMessage());
            }
            finally
            {
                FileIO.closeStream(rawSettings);
                FileIO.closeStream(internalStatistics);
            }
        }
    }
}
