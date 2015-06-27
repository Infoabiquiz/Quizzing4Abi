package com.lfg.informatik.q11.quizzing4abi;

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
    // TODO: Convert this class to a Builder for the required C,Q and A.
    public List<String> categories;
    public List<String> questions;
    public List<String> answers;

    private Stack<String> tagHierarchy;

    XMLParser()
    {
        categories = new LinkedList<>();
        questions = new LinkedList<>();
        answers = new LinkedList<>();

        tagHierarchy = new Stack<>();
    }

    public void tagBegin(String tagName)
    {
        tagHierarchy.push(tagName);
    }

    public void tagEnd(String tagName)
    {
        if(BuildConfig.DEBUG && !tagHierarchy.peek().equals(tagName)) // tag Names have to be the same
            throw new AssertionError("Assertion on tagName: " + tagName);
        tagHierarchy.pop();
    }

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
    }
}
