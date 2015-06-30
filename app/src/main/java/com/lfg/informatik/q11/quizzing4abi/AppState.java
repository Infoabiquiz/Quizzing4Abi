package com.lfg.informatik.q11.quizzing4abi;

import android.view.View;

/**
 * Created by Chris on 30.06.2015.
 * Base class for all app states. The State pattern is applied.
 */

public class AppState
{
    private Application application;

    public AppState(Application application)
    {
        this.application = application;
    }

    public void onClick(View view)
    {

    }
}