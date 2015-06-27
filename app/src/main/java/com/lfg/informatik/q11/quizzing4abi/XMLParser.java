package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chris on 27.06.2015.
 * This is the actual parser that deals with the xml document.
 * For every tag in the xml file there has the be one start and one end tag!
 */

public class XMLParser
{
    // TODO: Convert this class into a Builder for the required C,Q and A.
    public ArrayList<String> categories;
    public ArrayList<String> questions;
    public ArrayList<String> answers;
    public ArrayList<Boolean> answerCorrectness;

    private Stack<String> tagHierarchy;

    private LinkedList<Answer> tempAnswerList;
    private LinkedList<Question> tempQuestionList;
    private LinkedList<Category> tempCategoryList;

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

        tempAnswerList = new LinkedList<>();
        tempQuestionList = new LinkedList<>();
        tempCategoryList = new LinkedList<>();
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
    }

    /**
     * Gets called for each attribute.
     * @param attributeName name of the attribute
     * @param content content of the attribute
     */
    public void attribute(String attributeName, String content)
    {
        if(attributeName.equals("Text"))
        {
            if (tagHierarchy.peek().equals("Category"))
            {
                categories.add(content);
            }
            else if (tagHierarchy.peek().equals("Question"))
            {
                questions.add(content);
            }
            else if (tagHierarchy.peek().equals("Answer"))
            {
                answers.add(content);
            }
        }
        else if(attributeName.equals("Correct") && tagHierarchy.peek().equals("Answer"))
        {
            if(content.equals("true"))
                answerCorrectness.add(true);
            else if(content.equals("false"))
                answerCorrectness.add(false);
            else
                throw new AssertionError("Correct Tag: invalid value!");
        }
    }
}
