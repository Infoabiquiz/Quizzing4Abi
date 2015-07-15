package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lfg.informatik.q11.quizzing4abi.AnsweredQuestion;
import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.GameData;
import com.lfg.informatik.q11.quizzing4abi.Question;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Chris on 30.06.2015.
 * The state of an active question.
 */

public class ActiveQuestionState extends GameState
{
    private static int maxAskedQuestions = 5;

    private GameData gameData;

    private Question currentQuestion;
    private Map<Button, Boolean> buttonCorrectness;

    /**
     * Constructor.
     * @param application a valid Application
     */
    public ActiveQuestionState(Application application, GameData gameData)
    {
        super(application);

        this.gameData = gameData;

        currentQuestion = gameData.getRandomUnansweredQuestion();
        if(currentQuestion == null)
        {
            application.setState(new GameResultsState(application));
        }

        application.setLayout(R.layout.active_question);

        // Mark each button right or false, so it is easier to evaluate the chosen answer.
        buttonCorrectness = new LinkedHashMap<>();
        buttonCorrectness.put((Button)application.getViewByID(R.id.active_question_answer1),
                currentQuestion.getAnswers().get(0).isCorrect());
        buttonCorrectness.put((Button)application.getViewByID(R.id.active_question_answer2),
                currentQuestion.getAnswers().get(1).isCorrect());
        buttonCorrectness.put((Button)application.getViewByID(R.id.active_question_answer3),
                currentQuestion.getAnswers().get(2).isCorrect());

        // Set the Question text.
        ((TextView)application.getViewByID(R.id.active_question_question))
                .setText(currentQuestion.getQuestionText());

        // Set the Answer texts.
        int i = 0;
        for(Button button : buttonCorrectness.keySet())
        {
            button.setText(currentQuestion.getAnswers().get(i).getAnswersText());
            ++i;
        }

        // Set Category and SubCategory name.
        ((TextView)application.getViewByID(R.id.active_question_category))
                .setText(gameData.getCategoryNameOf(currentQuestion));

        // TODO: Set difficulty
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        // TODO: Question "Was sind rekursive Methoden" is buggy (no true)
        // - Feld mit 10 Elemtenten falsch

        switch(view.getId())
        {
            case R.id.active_question_answer1:
            {
                handleChosenAnswer((Button)view, 0);
                break;
            }
            case R.id.active_question_answer2:
            {
                handleChosenAnswer((Button)view, 1);
                break;
            }
            case R.id.active_question_answer3:
            {
                handleChosenAnswer((Button)view, 2);
                break;
            }
            case R.id.active_question_continue:
            {
                // End game if max Asked Questions are reached.
                if(gameData.getAnsweredQuestions().size() >= maxAskedQuestions)
                    application.setState(new GameResultsState(application));
                else
                    application.setState(new ActiveQuestionState(application, gameData));
                break;
            }
            case R.id.active_question_menu:
            {
                // TODO: Show game results screen before
                application.setState(new MainMenuState(application));
                break;
            }
        }
    }

    /**
     * Gets called if the user chooses any Answer (presses the button).
     * Colors the buttons and adds the currentQuestion to the answered Questions.
     * @param chosenAnswer the pressed button
     * @param answerIndex the index of this button (starting with 0)
     */
    private void handleChosenAnswer(Button chosenAnswer, int answerIndex)
    {
        if(currentQuestion == null)
            return;

        boolean correctAnswered = currentQuestion.getAnswers().get(answerIndex).isCorrect();
        colorButtons(chosenAnswer, correctAnswered);
        // TODO: Add duration
        gameData.addAnsweredQuestions(new AnsweredQuestion(currentQuestion,
                correctAnswered, 0));

        currentQuestion = null;
        application.getViewByID(R.id.active_question_continue).setVisibility(View.VISIBLE);
    }

    /**
     * Colors the answer buttons in this way:
     * -correctly answered = answered button gets colored green
     * -wrongly answered = answered button gets colored red
     *                     and the correct button gets colored yellow
     * @param pressedButton the answer button pressed by the user
     * @param correctAnswered true if answered correctly
     */
    private void colorButtons(Button pressedButton, boolean correctAnswered)
    {
        if(correctAnswered)
        {
            pressedButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            pressedButton.setBackgroundColor(Color.RED);
            for(Button button : buttonCorrectness.keySet())
            {
                if(buttonCorrectness.get(button))
                    button.setBackgroundColor(Color.YELLOW);
            }
        }
    }
}
