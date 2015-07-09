package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.view.View;

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
    private Question question;
    private AnsweredQuestion answeredquestion;
    private List<Answer> answer;
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;
    private Answer answer4;
    private GameData gamedata;
    /**
     * Constructor.
     * @param application a valid Application
     */

    public ActiveQuestionState(Application application, List<Answer> answer)
    {
        super(application);
        this.answer=answer;
        application.setLayout(R.layout.active_question);
        question=gamedata.getRandomUnansweredQuestion();
        answer = question.getAnswers();
        answer1 = answer.get(0);
        answer2 = answer.get(1);
        answer3 = answer.get(2);
        answer4 = answer.get(3);

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

                if (answer1.isCorrect())
                        {
                            view R.id.active_question_answer1.setbackgroundcolor(Color.GREEN);

                        }
                else
                        {
                            view R.id.active_question_answer1.setbackgroundcolor (Color.RED);
                        }
                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer2:
            {
                if (answer2.isCorrect())
                {
                    view R.id.active_question_answer2.setbackgroundcolor((Color.GREEN);

                }
                else
                {
                    view R.id.active_question_answer2.setbackgroundcolor(Color.RED);}
                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer3:
            {
                if (answer3.isCorrect())
                {
                    view R.id.active_question_answer3.setbackgroundcolor (Color.GREEN);

                }
                else
                {
                    view R.id.active_question_answer3.setbackgroundcolor (Color.RED);}
                // TODO: Add functionality
                break;
            }
            case R.id.active_question_answer4:
            {
                if (answer4.isCorrect())
                {
                    view R.id.active_question_answer4.setbackgroundcolor (Color.GREEN);

                }
                else
                {
                    view R.id.active_question_answer4.setbackgroundcolor (Color.RED);}
                // TODO: Add functionality
                break;
            }

        }
    }
}
