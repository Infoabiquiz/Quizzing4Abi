package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;
import com.lfg.informatik.q11.quizzing4abi.SettingsManager;

/**
 * Created by Dominik and Tung on 02.07.2015.
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

        application.setLayout(R.layout.settings);

        application.getViewByID(R.id.settings_pickcolor_blue)
                .setBackgroundColor(Color.BLUE);
        application.getViewByID(R.id.settings_pickcolor_cyan)
                .setBackgroundColor(Color.CYAN);
        application.getViewByID(R.id.settings_pickcolor_green)
                .setBackgroundColor(Color.GREEN);
        application.getViewByID(R.id.settings_pickcolor_yellow)
                .setBackgroundColor(Color.YELLOW);
        application.getViewByID(R.id.settings_pickcolor_red)
                .setBackgroundColor(Color.RED);
        application.getViewByID(R.id.settings_pickcolor_white)
                .setBackgroundColor(Color.WHITE);
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.settings_menu:
            {
                application.setState(new MainMenuState(application));
                break;
            }
            case R.id.settings_pickcolor_blue:
            {
                SettingsManager.setBackgroundColor(Color.BLUE);
                application.updateBackgroundColor();
                break;
            }
            case R.id.settings_pickcolor_cyan:
            {
                SettingsManager.setBackgroundColor(Color.CYAN);
                application.updateBackgroundColor();
                break;
            }
            case R.id.settings_pickcolor_white:
            {
                SettingsManager.setBackgroundColor(Color.WHITE);
                application.updateBackgroundColor();
                break;
            }
            case R.id.settings_pickcolor_red:
            {
                SettingsManager.setBackgroundColor(Color.RED);
                application.updateBackgroundColor();
                break;
            }
            case R.id.settings_pickcolor_green:
            {
                SettingsManager.setBackgroundColor(Color.GREEN);
                application.updateBackgroundColor();
                break;
            }
            case R.id.settings_pickcolor_yellow:
            {
                SettingsManager.setBackgroundColor(Color.YELLOW);
                application.updateBackgroundColor();
                break;
            }
        }
    }
}