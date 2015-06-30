package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Adrian on 30.06.2015.
 * This class manages the current state of the app and handles all user events.
 */

public class Application
{
    AppState currentAppState;
    MainActivity mainActivity;

    // TODO: Hardcode first app state (loading screen).
    /**
     * Constructor.
     * @param currentAppState current state of app
     * @param mainActivity main activity
     */
   public Application(AppState currentAppState, MainActivity mainActivity)
    {
        this.currentAppState = currentAppState;
        this.mainActivity = mainActivity;
    }

    /**
     * Changes the State.
     * @param AppState new state of the app
     */
    public void setState(AppState AppState)
    {
        currentAppState = AppState;
    }

    /**
     * Changes the current layout on the screen.
     * @param layoutID ID of the new layout
     */
    public void setLayout(int layoutID)
    {
        mainActivity.setContentView(layoutID);
    }

    /**
     * Forwards user click events to the current app state.
     * @param view the click source (e.g. android button)
     */
    public void onClick(View view)
    {
        currentAppState.onClick(view);
    }
}