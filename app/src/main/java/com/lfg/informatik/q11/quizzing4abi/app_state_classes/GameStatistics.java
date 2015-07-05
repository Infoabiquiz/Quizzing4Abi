package com.lfg.informatik.q11.quizzing4abi.app_state_classes;

import android.view.View;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.R;

/**
 * Created by Adrian on 05.07.2015.
 */
public class GameStatistics {



    public GameStatistics(Application application)
    {
        super(application);

        application.setLayout(R.layout.statistics);
    }

    @Override
    public void onClick(View view) {}



}

