package com.lfg.informatik.q11.quizzing4abi.model_io;

import com.lfg.informatik.q11.quizzing4abi.Answer;
import com.lfg.informatik.q11.quizzing4abi.BuildConfig;
import com.lfg.informatik.q11.quizzing4abi.Question;
import com.lfg.informatik.q11.quizzing4abi.SubCategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chris on 03.07.2015.
 * This XMLHandler implementation processes the whole xml file and builds all
 * or only SubCategories from one Category.
 * It functions as a Builder object for the SubCategory, Question and Answer classes.
 */

public class SubCategoryBuilder implements XMLHandler
{
    private Stack<String> tagHierarchy;
    private List<SubCategory> builtSubCategories;
    private List<Question> tempQuestionList;
    private List<Answer> tempAnswerList;

    private String currentCategory;
    private String currentSubCategory;
    private String currentQuestion;
    private String currentAnswer;
    private boolean currentCorrectness;
    private int currentDifficulty;

    private String categoryName;
    private List<String> requiredSubCategories;

    /**
     * Constructor.
     * @param categoryName          name of the Category containing the required SubCategories
     * @param requiredSubCategories List of names of the required SubCategories or null for all
     */
    public SubCategoryBuilder(String categoryName, List<String> requiredSubCategories)
    {
        tagHierarchy = new Stack<>();
        builtSubCategories = new LinkedList<>();
        tempQuestionList = new LinkedList<>();
        tempAnswerList = new LinkedList<>();

        this.categoryName = categoryName;
        this.requiredSubCategories = requiredSubCategories;
    }

    /**
     * After the building process has finished, calling this method will return the List of built
     * SubCategories and transfer ownership to the caller.
     * @return List of built SubCategories
     */
    public List<SubCategory> takeBuiltSubCategories()
    {
        List<SubCategory> temp = new ArrayList<>(builtSubCategories);
        builtSubCategories = new LinkedList<>();
        tempQuestionList.clear();
        tempAnswerList.clear();
        return temp;
    }

    @Override
    /**
     * Has to be called at the occurrence of a each beginning tag.
     * @param tagName the name of the tag
     */
    public void tagBegin(String tagName)
    {
        tagHierarchy.push(tagName);
    }

    /**
     * Has to be called at the each ending tag.
     * Constructs a new SubC, Q or A based on the ending tag.
     * @param tagName name of the ending element
     */
    @Override
    public void tagEnd(String tagName)
    {
        if(BuildConfig.DEBUG && !tagHierarchy.peek().equals(tagName)) // tag names have to be the same
            throw new AssertionError("Assertion on tagName: " + tagName);

        tagHierarchy.pop();

        // Ignore all other Categories but the required one.
        if(!currentCategory.equals(categoryName))
            return;
        // Ignore non required SubCategories.
        else if(requiredSubCategories != null && !requiredSubCategories.contains(currentSubCategory))
            return;

        if(tagName.equals("SubCategory"))
        {
            builtSubCategories.add(new SubCategory(currentSubCategory, tempQuestionList));
            tempQuestionList = new LinkedList<>();
        }
        else if(tagName.equals("Question"))
        {
            tempQuestionList.add(new Question(currentQuestion, tempAnswerList, currentDifficulty));
            tempAnswerList = new LinkedList<>();
        }
        else if(tagName.equals("Answer"))
        {
            tempAnswerList.add(new Answer(currentCorrectness, currentAnswer));
        }
    }

    /**
     * Has to be called for each attribute.
     * Fills the "current" fields with the appropriate content.
     * @param attributeName name of the attribute or null/"" for a text node
     * @param content       content of the attribute
     */
    @Override
    public void attribute(String attributeName, String content)
    {
        if(tagHierarchy.peek().equals("Category"))
        {
            if (attributeName.equals("Text"))
                currentCategory = content;
        }

        // Ignore all other Categories but the required one.
        if(!currentCategory.equals(categoryName))
            return;

        if(tagHierarchy.peek().equals("SubCategory"))
        {
            if (attributeName.equals("Text"))
                currentSubCategory = content;
        }

        // Ignore non required SubCategories.
        if(requiredSubCategories != null && !requiredSubCategories.contains(currentSubCategory))
            return;

        if(tagHierarchy.peek().equals("Question"))
        {
            if (attributeName.equals("Text"))
                currentQuestion = content;
            else if(attributeName.equals("Difficulty"))
            {
                switch (content)
                {
                    case "leicht":
                        currentDifficulty = 1;
                        break;
                    case "mittel":
                        currentDifficulty = 2;
                        break;
                    case "schwer":
                        currentDifficulty = 3;
                        break;
                }
            }
        }
        else if(tagHierarchy.peek().equals("Answer"))
        {
            if (attributeName.equals("Correct"))
            {
                if (content.equals("true"))
                    currentCorrectness = true;
                else if (content.equals("false"))
                    currentCorrectness = false;
                else
                    throw new AssertionError("Correct Tag: invalid value!");
            }
            else if (attributeName.equals("Text"))
                currentAnswer = content;
        }
    }
}
