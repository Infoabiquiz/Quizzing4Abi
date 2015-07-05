package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Chris on 30.06.2015.
 * The state of an active question.
 */

public class ActiveQuestionState extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public ActiveQuestionState(Application application)
    {
        super(application);

        application.setLayout(R.layout.active_question);
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {

    }
}
