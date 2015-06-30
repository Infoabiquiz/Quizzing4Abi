package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Chris on 30.06.2015.
 * Base class for all app states. The State pattern is applied.
 */

public class AppState
{
    protected Application application;

    /**
     * Constructor.
     * @param application a valid Application
     */
    public AppState(Application application)
    {
        if(application == null)
            throw new IllegalArgumentException("Null not allowed");

        this.application = application;
    }

    /**
     * Handles user events. More specific click events.
     * @param view the click source (e.g. android button)
     */
    public void onClick(View view)
    {

    }
}