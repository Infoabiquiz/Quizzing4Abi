package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Chris on 30.06.2015.
 * The first state of the app after starting it.
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

        // TODO: Load relevant data here

        application.setState(new MainMenuState(application));
    }
}
