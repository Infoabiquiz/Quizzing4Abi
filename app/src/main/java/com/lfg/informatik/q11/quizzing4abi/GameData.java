package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dominik 05.07.2015. Rewritten by Chris.
 * Saves all game relevant information and provides access and an add functionality to it.
 */

public class GameData
{
    private List<Category> categories;
    private List<Question> questionPool;
    private List<AnsweredQuestion> answeredQuestions;

    /**
     * Constructor.
     * Saves the passed Categories and constructs the question pool.
     * @param categories List of Categories to choose Questions from
     */
    public GameData(List<Category> categories)
    {
        this.categories =  categories;
        questionPool = new LinkedList<>();

        for(Category category : categories)
        {
            questionPool.addAll(category.getQuestionPool());
        }

        answeredQuestions = new LinkedList<>();
    }

    /**
     * Returns a random Question out of the question-pool
     * and removes it from the pool.
     * @return the random unanswered Question or null if no Questions are remaining
     */
    public Question getRandomUnansweredQuestion()
    {
        if(questionPool.isEmpty())
            return null;

        return questionPool.remove(new Random().nextInt(questionPool.size()));
    }

    /**
     * Returns the Category and SubCategory name of that SubCategory the question is part of.
     * In the format: "CategoryName - SubCategoryName".
     * @param question the question to search the name for
     * @return the Cat and subCat name of that Question or "" if matches found
     */
    public String getCategoryNameOf(Question question)
    {
        for(Category category : categories)
        {
            for(SubCategory subCategory : category.getSubCategories())
            {
                if(subCategory.getQuestions().contains(question))
                {
                    return category.getCategoryName() + " - "
                            + subCategory.getSubCategoryName();
                }
            }
        }

        return "";
    }

    /**
     * Adds an AnsweredQuestion to the answeredQuestion history.
     * @param answeredQuestion the just answered question
     */
    public void addAnsweredQuestions(AnsweredQuestion answeredQuestion)
    {
        answeredQuestions.add(answeredQuestion);
    }

    /**
     * Returns the list of Categories as read only.
     * @return the list of Categories
     */
    public List<Category> getCategories()
    {
        return Collections.unmodifiableList(categories);
    }

    /**
     * Returns the list of AnsweredQuestions as read only.
     * @return the list of AnsweredQuestions
     */
    public List<AnsweredQuestion> getAnsweredQuestions()
    {
        return Collections.unmodifiableList(answeredQuestions);
    }
}
