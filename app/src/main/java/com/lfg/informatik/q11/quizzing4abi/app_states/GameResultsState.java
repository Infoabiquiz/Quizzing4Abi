package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Adrian on 05.07.2015.
 * The last game state, in which the game results are presented.
 */

public class GameResultsState extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameResultsState(Application application)
    {
        super(application);

        application.setLayout(R.layout.game_results);

        // TODO
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.game_results_menu:
            {
                application.setState(new MainMenuState(application));
                break;
            }
        }
    }
}

