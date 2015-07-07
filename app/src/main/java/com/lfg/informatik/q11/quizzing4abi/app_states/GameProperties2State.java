package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Chris on 01.07.2015.
 * The second state if a new Game is started. It shows the available SubCategories for the
 * chosen Categories, from which the user chooses from.
 */

public class GameProperties2State extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameProperties2State(Application application)
    {
        super(application);

        application.setLayout(R.layout.game_properties2);
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
