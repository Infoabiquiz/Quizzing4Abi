package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.app_states.AppStartState;
import com.lfg.informatik.q11.quizzing4abi.app_states.AppState;

/**
 * Created by Adrian on 30.06.2015.
 * This class manages the current state of the app and handles all user events.
 */

public class Application
{
    private AppState currentAppState;
    private MainActivity mainActivity;

    /**
     * Constructor.
     * @param mainActivity main activity
     */
   public Application(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        new AppStartState(this); // current state assignment left out for bug prevention!
    }

    /**
     * Changes the State.
     * @param appState new state of the app
     */
    public void setState(AppState appState)
    {
        currentAppState = appState;
    }

    /**
     * Changes the current layout on the screen.
     * @param layoutID ID of the new layout
     */
    public void setLayout(int layoutID)
    {
        mainActivity.setContentView(layoutID);
        mainActivity.findViewById(layoutID).setBackgroundColor(
                SettingsManager.getBackgroundColor());
    }

    /**
     * Returns the View object with the given ID.
     * @param viewID the ID of the required View
     * @return the required View
     */
    public View getViewByID(int viewID)
    {
        return mainActivity.findViewById(viewID);
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