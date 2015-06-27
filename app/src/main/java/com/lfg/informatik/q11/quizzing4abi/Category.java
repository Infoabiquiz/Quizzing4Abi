package com.lfg.informatik.q11.quizzing4abi;
import java.util.ArrayList;

/**
 * Created by Adrian on 27.06.2015.
 */
public class Category {
    String questionCategory;
    ArrayList<Question> questions;

public Category (String questionCategory,ArrayList<Question> questions )
{
    this.questionCategory=questionCategory;
    this.questions=questions;
}

    /**
     *
     * @return
     */

    String getCategoryName()
    {
        return questionCategory;
    }

    /**
     *Returns the questions
     * @return list of questions
     */

    ArrayList<Question> getQuestions()
    {
        return questions;
    }


}
