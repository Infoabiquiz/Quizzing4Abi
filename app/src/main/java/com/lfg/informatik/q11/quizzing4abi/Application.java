package com.lfg.informatik.q11.quizzing4abi;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.app_states.AppStartState;
import com.lfg.informatik.q11.quizzing4abi.app_states.AppState;
import com.lfg.informatik.q11.quizzing4abi.app_states.MainMenuState;
import com.lfg.informatik.q11.quizzing4abi.model_io.FileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

        FileIO.setMainActivity(mainActivity);


        currentAppState = new AppStartState(this);
        int color = SettingsManager.getBackgroundColor();
        currentAppState = new MainMenuState(this);
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
        int color = SettingsManager.getBackgroundColor();
        mainActivity.getWindow().getDecorView()
                .setBackgroundColor(color);
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