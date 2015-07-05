package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Dominik 05.07.2015.
 *
 */

public class Gamedata
{
    private List<Category> questionPool;
    private List<Question> answeredQusetsions;
    private Random randomGenerator;

    /**
     * Contructor.
     * @param questionPool List of questions
     * @param answeredQusetsions       List of answered Questions
     */
    public Gamedata(List<Category> questionPool, List<Question> answeredQusetsions)
    {
        this.questionPool =  questionPool;
        this.answeredQusetsions = answeredQusetsions;
        randomGenerator = new Random();
    }

    /**
     *
     *
     */
    public Question getRandomUnansweredQuestion()
    {
        int index = randomGenerator.nextInt(questionPool.size());
        Category item = questionPool.get(index);

        List<SubCategory> subcat = item.getSubCategories();
        int subcatIndex = randomGenerator.nextInt(subcat.size());
        SubCategory sub = subcat.get(subcatIndex);

        List<Question>  quest = sub.getQuestions();
        int questIndex = randomGenerator.nextInt(quest.size());
        Question randomQuestion = quest.get(questIndex);
        if (this.compare(randomQuestion)){
            this.addAnsweredQuestions(randomQuestion);
            return randomQuestion;

        }
        else {
            return(this.getRandomUnansweredQuestion());
        }
    }

    /**
     *
     *
     */
    public void addAnsweredQuestions( Question givenQuestions)
    {
        answeredQusetsions.add(givenQuestions) ;
    }

    public boolean compare(Question comapreQuestion){

        boolean answered= false;
        for (Question temp:  answeredQusetsions)
        {
            if (temp == comapreQuestion){
                answered= false;
            }
            else{
                answered =  true;
            }
        }
        return answered;
    }
}
