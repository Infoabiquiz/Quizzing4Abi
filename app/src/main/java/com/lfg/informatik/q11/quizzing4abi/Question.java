package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;

/**
 * Created by Chris on 27.06.2015.
 */

public class Question
{
    private final String questionText;
    private final ArrayList<Answer> answers;

    public Question(String questionText, ArrayList<Answer> answers)
    {
        this.questionText = questionText;
        this.answers = answers;
    }

    String getQuestionText()
    {
        return questionText;
    }

    ArrayList<Answer> getAnswers()
    {
        return answers;
    }
}
