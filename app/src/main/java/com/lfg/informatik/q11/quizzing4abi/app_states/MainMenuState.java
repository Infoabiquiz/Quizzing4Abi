package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

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
        switch(view.getId())
        {
            case R.id.main_menu_play:
            {
                application.setState(new GameProperties1State(application));
            }
            case R.id.main_menu_scoreboard:
            {
                application.setState(new ScoreboardState(application));
                break;
            }
            case R.id.main_menu_settings:
            {
                application.setState(new SettingsState(application));
                break;
            }
            case R.id.main_menu_statistics:
            {
                application.setState(new StatisticsState(application));
                break;
            }
        }
    }
}