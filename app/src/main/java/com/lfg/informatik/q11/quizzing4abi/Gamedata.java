package com.lfg.informatik.q11.quizzing4abi;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dominik 05.07.2015.
 * // TODO: Comment
 */

public class Gamedata
{
    private List<Category> questionPool;
    private List<AnsweredQuestion> answeredQuestions;
    private Random randomGenerator;

    /**
     * Constructor.
     * @param questionPool List of Categories to choose Questions from
     */
    public Gamedata(List<Category> questionPool)
    {
        this.questionPool =  questionPool;
        answeredQuestions = new LinkedList<>();
        randomGenerator = new Random();
    }

    // TODO: Comment
    public Question getRandomUnansweredQuestion()
    {
       // TODO: Check if there are any unanswered questions:
       // if(answeredQuestions.size() >= )

        while(true)
        {
            Category randomCategory =
                    questionPool.get(randomGenerator.nextInt(questionPool.size()));

            List<SubCategory> subCategories = randomCategory.getSubCategories();
            SubCategory randomSubCategory =
                    subCategories.get(randomGenerator.nextInt(subCategories.size()));

            List<Question> questions = randomSubCategory.getQuestions();
            Question randomQuestion = questions.get(randomGenerator.nextInt(questions.size()));

            boolean matchFound = false;
            for(AnsweredQuestion answeredQuestion : answeredQuestions)
            {
                if(answeredQuestion.getQuestion() == randomQuestion)
                {
                    matchFound = true;
                    break;
                }
            }

            if(!matchFound)
                return randomQuestion;
        }
    }

    // TODO: Comment
    public void addAnsweredQuestions(AnsweredQuestion answeredQuestion)
    {
        answeredQuestions.add(answeredQuestion);
    }
}
