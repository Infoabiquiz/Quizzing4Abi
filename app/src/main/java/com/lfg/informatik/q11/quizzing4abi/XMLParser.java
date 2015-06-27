package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chris on 27.06.2015.
 * This is the actual parser that deals with the xml document.
 * It functions as a Builder object for the Category, Question and Answer classes.
 * For every tag in the xml file there has the be one start and one end tag!
 */

public class XMLParser
{
    public ArrayList<String> categories;
    public ArrayList<String> questions;
    public ArrayList<String> answers;
    public ArrayList<Boolean> answerCorrectness;

    private Stack<String> tagHierarchy;

    public ArrayList<Category> builtCategories;

    private boolean tempCorrectness;
    private ArrayList<Answer> tempAnswerList;
    private ArrayList<Question> tempQuestionList;
    private ArrayList<Category> tempCategoryList;

    /**
     * Constructor.
     */
    XMLParser()
    {
        categories = new ArrayList<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        answerCorrectness = new ArrayList<>();

        tagHierarchy = new Stack<>();

        tempAnswerList = new ArrayList<>();
        tempQuestionList = new ArrayList<>();
        tempCategoryList = new ArrayList<>();
    }

    /**
     * Gets called at each begin of a new element.
     * @param tagName name of the starting element
     */
    public void tagBegin(String tagName)
    {
        tagHierarchy.push(tagName);
    }

    /**
     * Gets called at each end of an element.
     * @param tagName name of the ending element
     */
    public void tagEnd(String tagName)
    {
        if(BuildConfig.DEBUG && !tagHierarchy.peek().equals(tagName)) // tag Names have to be the same
            throw new AssertionError("Assertion on tagName: " + tagName);

        tagHierarchy.pop();

        if(tagName.equals("Data"))
        {
            builtCategories = tempCategoryList;
            tempCategoryList = null;
        }
    }

    /**
     * Gets called for each attribute.
     * @param attributeName name of the attribute
     * @param content content of the attribute
     */
    public void attribute(String attributeName, String content)
    {
        switch(tagHierarchy.peek())
        {
            case "Category":
            {
                if (attributeName.equals("Text"))
                {
                    categories.add(content);
                    tempCategoryList.add(new Category(content, tempQuestionList));
                    tempQuestionList.clear();
                }
                break;
            }
            case "Question":
            {
                if (attributeName.equals("Text"))
                {
                    questions.add(content);
                    tempQuestionList.add(new Question(content, tempAnswerList));
                    tempAnswerList.clear();
                }
                break;
            }
            case "Answer":
            {
                if (attributeName.equals("Correct"))
                {
                    if (content.equals("true"))
                    {
                        answerCorrectness.add(true);
                        tempCorrectness = true;
                    }
                    else if (content.equals("false"))
                    {
                        answerCorrectness.add(false);
                        tempCorrectness = false;
                    }
                    else
                        throw new AssertionError("Correct Tag: invalid value!");
                }
                else if (attributeName.equals("Text"))
                {
                    answers.add(content);
                    tempAnswerList.add(new Answer(tempCorrectness, content));
                }
                break;
            }
        }
    }
}
