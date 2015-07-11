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
     * Constructor.
     * @param application a valid Application
     */
    public AppStartState(Application application)
    {
        super(application);

        application.setLayout(R.layout.app_start);

        // TODO: Write copy function raw to internal storage
        // TODO: Atm the version/date/hash of the raw files are ignored!

        if(!FileIO.checkFileExistence("settings.xml"))
        {
            InputStream rawSettings = FileIO.openRawResource(R.raw.settings);

            OutputStream internalSettings;
            try
            {
                internalSettings = FileIO.openOutputFile("settings.xml");
            }
            catch (FileNotFoundException e)
            {
                ExceptionHandler.showAlertDialog("Internal settings not found. Error: "
                        + e.getMessage());
                return;
            }

            try
            {
                FileIO.inputToOutput(rawSettings, internalSettings);
            }
            catch (IOException e)
            {
                ExceptionHandler.showAlertDialog("Failed writing to internal Error: "
                        + e.getMessage());
            }
        }
    }
}
