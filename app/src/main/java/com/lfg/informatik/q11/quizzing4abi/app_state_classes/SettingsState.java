package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;
import com.lfg.informatik.q11.quizzing4abi.SettingsManager;

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

        application.setLayout(R.layout.settings);
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        // TODO: Add functionality

        switch(view.getId())
        {
            case R.id.settings_pickcolor_blue:
            {
                SettingsManager.setBackgroundColor(Color.BLUE);
                break;
            }
            case R.id.settings_pickcolor_cyan:
            {
                SettingsManager.setBackgroundColor(Color.CYAN);
                break;
            }
            case R.id.settings_pickcolor_white:
            {
                SettingsManager.setBackgroundColor(Color.WHITE);
                break;
            }
            case R.id.settings_pickcolor_red:
            {
                SettingsManager.setBackgroundColor(Color.RED);
                break;
            }
            case R.id.settings_pickcolor_green:
            {
                SettingsManager.setBackgroundColor(Color.GREEN);
                break;
            }
            case R.id.settings_pickcolor_yellow:
            {
                SettingsManager.setBackgroundColor(Color.YELLOW);
                break;
            }
        }
    }
}