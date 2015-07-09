package com.lfg.informatik.q11.quizzing4abi.model_io;

import com.lfg.informatik.q11.quizzing4abi.Answer;
import com.lfg.informatik.q11.quizzing4abi.BuildConfig;
import com.lfg.informatik.q11.quizzing4abi.Category;
import com.lfg.informatik.q11.quizzing4abi.Question;
import com.lfg.informatik.q11.quizzing4abi.SubCategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chris on 29.06.2015.
 * This XMLHandler implementation processes the whole xml file and builds all
 * or only the required Categories.
 * It functions as a Builder object for the Category, SubCategory, Question and Answer classes.
 */

public class CategoryBuilder implements XMLHandler
{
    private Stack<String> tagHierarchy;
    private List<Category> builtCategories;
    private List<SubCategory> tempSubCategories;
    private List<Question> tempQuestionList;
    private List<Answer> tempAnswerList;

    private String currentCategory;
    private String currentSubCategory;
    private String currentQuestion;
    private String currentAnswer;
    private boolean currentCorrectness;

    private List<String> requiredCategories;

    /**
     * Constructor.
     * @param requiredCategories List of names of the required Category or null for all
     */
    public CategoryBuilder(List<String> requiredCategories)
    {
        tagHierarchy = new Stack<>();
        builtCategories = new LinkedList<>();
        tempSubCategories = new LinkedList<>();
        tempQuestionList = new LinkedList<>();
        tempAnswerList = new LinkedList<>();

        this.requiredCategories = requiredCategories;
    }

    /**
     * After the building process has finished, calling this method will return the List of built
     * Categories and transfer ownership to the caller.
     * @return List of built Categories
     */
    public List<Category> takeBuiltCategories()
    {
        List<Category> temp = new ArrayList<>(builtCategories);
        builtCategories = new LinkedList<>();
        tempSubCategories.clear();
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
     * Constructs a new C, SubC, Q or A based on the ending tag.
     * @param tagName name of the ending element
     */
    @Override
    public void tagEnd(String tagName)
    {
        if(BuildConfig.DEBUG && !tagHierarchy.peek().equals(tagName)) // tag names have to be the same
            throw new AssertionError("Assertion on tagName: " + tagName);

        tagHierarchy.pop();

        // Ignore non required Categories, Question and Answers.
        if(requiredCategories != null && !requiredCategories.contains(currentCategory))
            return;

        if(tagName.equals("Category"))
        {
            builtCategories.add(new Category(currentCategory, tempSubCategories));
            tempSubCategories = new LinkedList<>();
        }
        else if(tagName.equals("SubCategory"))
        {
            tempSubCategories.add(new SubCategory(currentSubCategory, tempQuestionList));
            tempQuestionList = new LinkedList<>();
        }
        else if(tagName.equals("Question"))
        {
            tempQuestionList.add(new Question(currentQuestion, tempAnswerList));
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
        if(attributeName == null || attributeName.equals(""))
            return;

        if(tagHierarchy.peek().equals("Category"))
        {
            if (attributeName.equals("Text"))
                currentCategory = content;
        }

        // Ignore non required Categories, Question and Answers.
        if(requiredCategories != null && !requiredCategories.contains(currentCategory))
            return;

        if(tagHierarchy.peek().equals("SubCategory"))
        {
            if (attributeName.equals("Text"))
                currentSubCategory = content;
        }
        else if(tagHierarchy.peek().equals("Question"))
        {
            if (attributeName.equals("Text"))
                currentQuestion = content;
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
