package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import android.widget.TextView;

import com.lfg.informatik.q11.quizzing4abi.AnsweredQuestion;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.GameStatistics;
import com.lfg.informatik.q11.quizzing4abi.R;
import com.lfg.informatik.q11.quizzing4abi.StatisticsManager;

import java.util.Date;
import java.util.List;

/**
 * Created by Adrian on 05.07.2015.
 * The last game state, in which the game results are presented.
 */

public class GameResultsState extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     * @param answeredQuestions the questions that have been answered in this game (!= null)
     */
    public GameResultsState(Application application, List<AnsweredQuestion> answeredQuestions)
    {
        super(application);

        application.setLayout(R.layout.game_results);

        if(answeredQuestions == null)
            throw new IllegalArgumentException("AnsweredQuestionList must not be null!");

        long gameDuration = 0;
        int numberRightAnswers = 0;
        int totalDifficulty = 0;
        for(AnsweredQuestion answeredQuestion : answeredQuestions)
        {
            gameDuration += answeredQuestion.getDuration();
            if(answeredQuestion.isCorrectAnswered())
                ++numberRightAnswers;
            totalDifficulty += answeredQuestion.getQuestion().getDifficulty();
        }

        ((TextView)application.getViewByID(R.id.game_results_display_seconds_played))
                .setText(Long.toString(gameDuration));

        float correctnessRate = (float)numberRightAnswers / (float)answeredQuestions.size();

        ((TextView)application.getViewByID(R.id.game_results_display_correctnesrate))
                .setText(Float.toString(correctnessRate));

        float averageDifficulty = (float)totalDifficulty / (float)answeredQuestions.size();

        GameStatistics gameStatistics = new GameStatistics(new Date(), gameDuration,
                correctnessRate, averageDifficulty);
        // TODO StatisticsManager.addGameStatistics(gameStatistics);
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.game_results_menu:
            {
                application.setState(new MainMenuState(application));
                break;
            }
        }
    }
}

