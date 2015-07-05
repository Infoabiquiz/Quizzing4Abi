package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;

import com.lfg.informatik.q11.quizzing4abi.Application;

/**
 * Created by Dominik on 02.07.2015.
 * The state of the Settings window / user preferences.
 */

public class SettingsState extends AppState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public SettingsState(Application application)
    {
        super(application);

        // TODO: application.setLayout(R.layout.settings);
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