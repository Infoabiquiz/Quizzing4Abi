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
    private List<AnsweredQuestions> answeredQusetsions;
    private Random randomGenerator;

    /**
     * Contructor.
     * @param questionspool List of questions
     * @param answeredQuestions       List of answered Questions
     */
    public Gamedata(List<Category> questionPool, List<AnsweredQuestions> answeredQusetsions)
    {
        this.List<Category> questionPool =  questionPool;
        this.List<AnsweredQuestions> answeredQusetsions = List<AnsweredQuestions> answeredQusetsions;
        randomGenerator = new Random();
    }

    /**
     *
     *
     */
    public getRandomUnansweredQuestion()
    {
        int index = randomGenerator.nextInt(questionPool.size());
        Category item = questionPool.get(index);

        List<SubCategory> subcat = item.getSubCategories();
        int subcatIndex = randomGenerator.nextInt(subcat.size());
        SubCategory sub = subcat.get(subcatIndex);

        List<Question>  quest = sub.getQuestions();
        int questIndex = randomGenerator.nextInt(quest.size()));
        Question randomQuestion = quest.get(questIndex);
        if (AnsweredQuestion.compare(randomQuestion)){
            this.addAnsweredQuestions(randomQuestions);
            return randomQuestion;
        }
        else {
            this.getrandomquestion();
        }

    /**
     *
     *
     */
    public addAnsweredQuestions(answeredQuestions)()
    {

    }
}
