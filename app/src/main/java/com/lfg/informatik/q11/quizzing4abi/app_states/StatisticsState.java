package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Chris on 15.07.2015.
 * The state of the Statistics. It shows the global statistics.
 */

public class StatisticsState extends AppState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public StatisticsState(Application application)
    {
        super(application);

        application.setLayout(R.layout.statistics);

        // TODO: Add functionality
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        // TODO: Add functionality

        switch (view.getId())
        {
            case R.id.statics_menu:
            {
                application.setState(new MainMenuState(application));
                break;
            }
        }
    }
}