package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Aleksandar on 30.06.2015.
 * The state of the main menu.
 */

public class MainMenuState extends AppState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public MainMenuState(Application application)
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