package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Chris on 27.06.2015.
 * This is the actual loader class that deals with the xml document.
 * It functions as a Builder object for the Category, Question and Answer classes.
 * Note: For every tag in the xml file there has the be one start and one end tag!
 */

public class CQA_Loader
{
    private Stack<String> tagHierarchy;
    private List<Category> builtCategories;
    private List<Question> tempQuestionList;
    private List<Answer> tempAnswerList;
    private String currentCategory;
    private String currentQuestion;
    private String currentAnswer;
    private boolean currentCorrectness;

    /**
     * Constructor.
     */
    CQA_Loader()
    {
        tagHierarchy = new Stack<>();
        builtCategories = new ArrayList<>();
        tempAnswerList = new ArrayList<>();
        tempQuestionList = new ArrayList<>();
    }

    /**
     * This function starts the actual build process.
     * It uses the SAX Parser to traverse the xml file.
     * @param filename name of the xml file
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void parseXMLFile(String filename)
            throws IOException, SAXException, ParserConfigurationException
    {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(this);
        saxParser.parse(filename, saxDocumentHandler);
    }

    /**
     * After the build process has finished, calling this method will return the List of built
     * Categories and transfer ownership to the caller.
     * @return List of built Categories
     */
    public List<Category> takeBuiltCategories()
    {
        List<Category> temp = builtCategories;
        builtCategories = new ArrayList<>();
        return temp;
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
     * Constructs a new C,Q or A based on the ending tag.
     * @param tagName name of the ending element
     */
    public void tagEnd(String tagName)
    {
        if(BuildConfig.DEBUG && !tagHierarchy.peek().equals(tagName)) // tag names have to be the same
            throw new AssertionError("Assertion on tagName: " + tagName);

        tagHierarchy.pop();

        if(tagName.equals("Category"))
        {
            builtCategories.add(new Category(currentCategory, tempQuestionList));
            tempQuestionList = new ArrayList<>();
        }
        else if(tagName.equals("Question"))
        {
            tempQuestionList.add(new Question(currentQuestion, tempAnswerList));
            tempAnswerList = new ArrayList<>();
        }
        else if(tagName.equals("Answer"))
        {
            tempAnswerList.add(new Answer(currentCorrectness, currentAnswer));
        }
    }

    /**
     * Gets called for each attribute.
     * Fills the "current" fields with the appropriate content.
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
                    currentCategory = content;
                break;
            }
            case "Question":
            {
                if (attributeName.equals("Text"))
                    currentQuestion = content;
                break;
            }
            case "Answer":
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
                break;
            }
        }
    }
}
