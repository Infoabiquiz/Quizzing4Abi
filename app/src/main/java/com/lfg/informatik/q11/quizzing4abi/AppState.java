package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Chris on 30.06.2015.
 * Base class for all app states. The State pattern is applied.
 * Creation of subclasses change the current layout instantly, so be aware
 * and change the current state of the application afterwards!
 */

public abstract class AppState
{
    protected Application application;

    /**
     * Constructor.
     * @param application a valid Application
     */
    protected AppState(Application application)
    {
        if(application == null)
            throw new IllegalArgumentException("Null not allowed");

        this.application = application;
    }

    /**
     * Handles user click events. Functionality implemented in sub classes.
     * @param view the click source (e.g. android button)
     */
    public void onClick(View view)
    {

    }
}