package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;

/**
 * Created by Chris on 30.06.2015.
 * Base class for all game states.
 */

public abstract class GameState extends AppState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    protected GameState(Application application)
    {
        super(application);
    }

    /**
     * Handles user click events. Functionality implemented in sub classes.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {

    }
}
