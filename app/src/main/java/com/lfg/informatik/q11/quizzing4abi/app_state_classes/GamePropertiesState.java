package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;

/**
 * Created by Chris on 01.07.2015.
 * The first state if a new Game is started. It shows the game creation options.
 */

public class GamePropertiesState extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public GamePropertiesState(Application application)
    {
        super(application);

        // TODO: application.setLayout(R.layout.game_properties);
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
