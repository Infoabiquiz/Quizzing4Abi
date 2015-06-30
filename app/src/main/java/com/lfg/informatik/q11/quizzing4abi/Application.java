package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Chris on 30.06.2015.
 *
 */

public class Application
{

    AppState CurrentAppState;
    MainActivity Activity;

    /**
     *Constructor
     * @param CurrentAppState current state of app
     * @param Activity activity
     */

   public Application(AppState CurrentAppState, MainActivity Activity)
    {
        this.CurrentAppState=CurrentAppState;
        this.Activity=Activity;
    }

    /**
     * Sets CurrentAppSate to new AppState
     * @param AppState new AppState
     */
    public void setState(AppState AppState)
    {
        CurrentAppState=AppState;
    }

    /**
     * Calls method setContentView in MainActivity
     * @param layoutID ID of layout
     */
    public void setLayout(int layoutID )
    {
        Activity.setContentView(layoutID);
    }

    /**
     * Calls method onClick in MainActivity
     * @param view from View
     */
    public void onClick(View view)
    {
        Activity.onClick(view);
    }


}
