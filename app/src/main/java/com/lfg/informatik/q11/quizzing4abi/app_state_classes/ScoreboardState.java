package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Dominik on 02.07.2015.
 * The state of the Scoreboard. It shows the scoreboard.
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

        // TODO: application.setLayout(R.layout.scoreboard);
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