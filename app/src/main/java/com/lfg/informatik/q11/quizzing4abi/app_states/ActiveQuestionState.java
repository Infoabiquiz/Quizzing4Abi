package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lfg.informatik.q11.quizzing4abi.Answer;
import com.lfg.informatik.q11.quizzing4abi.AnsweredQuestion;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.GameData;
import com.lfg.informatik.q11.quizzing4abi.Question;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.List;

/**
 * Created by Chris on 30.06.2015.
 * The state of an active question.
 */

public class ActiveQuestionState extends GameState
{
    // TODO: Review
    private GameData gameData;
    private Question currentQuestion;

    /**
     * Constructor.
     * @param application a valid Application
     */
    public ActiveQuestionState(Application application, GameData gameData)
    {
        super(application);

        this.gameData = gameData;

        currentQuestion = gameData.getRandomUnansweredQuestion();

        application.setLayout(R.layout.active_question);

        ((TextView)application.getViewByID(R.id.active_question_question))
                .setText(currentQuestion.getQuestionText());


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
            case R.id.active_question_answer1:
            {
                Answer answer = currentQuestion.getAnswers().get(0);
                if(answer.isCorrect())
                {
                    ((Button)view).setBackgroundColor(Color.GREEN);
                }
                else
                {
                    ((Button)view).setBackgroundColor(Color.RED);
                    // Color the right one orange.
                }

                gameData.addAnsweredQuestions(new AnsweredQuestion(currentQuestion, true, 0));

                // Wait for user

                // application.setState(new ActiveQuestionState(application, gameData));

                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer2:
            {
                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer3:
            {
                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer4:
            {
                // TODO: Add functionality
                break;
            }

        }
    }
}
