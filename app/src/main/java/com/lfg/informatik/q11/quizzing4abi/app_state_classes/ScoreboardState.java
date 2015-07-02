package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Dominik on 02.07.2015.
 * State of the Scoreboard.
 */

public class ScoreboardState extends AppState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public ScoreboardState(Application application)
    {
        super(application);

        application.setLayout(R.layout.main_menu);
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        // TODO: Add functionality
    }
}