package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerException;

/**
 * Created by Chris on 26.06.2015.
 * for testing purposes...
 */

public class Test
{
    public final static String raw = "app\\src\\main\\res\\raw\\";

    /**
     * Test main
     */
    public static void main(String args[]) throws IOException, SAXException,
            ParserConfigurationException, TransformerException
    {
        testWriter();
    }

    // TODO: Catch all parser specific exceptions and find another way of error handling

    /**
     * Tests the loading process of the CQA_Loader
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    static void testCQA() throws ParserConfigurationException, SAXException, IOException
    {
        List<String> requiredCategories = new ArrayList<>();
        requiredCategories.add("Informatik");
        List<Category> categories = CQA_Loader.loadCategories(requiredCategories);

        traverseBuiltCategories(categories);

        System.out.println("\n");

        List<String> categoryNames = CQA_Loader.getAllCategoryNames();
        for(String name : categoryNames)
            System.out.println("CategoryName: " + name);

        List<String> requiredSubCategories = new ArrayList<>();
        requiredSubCategories.add("Q11/1");

        List<SubCategory> subCategories = CQA_Loader.loadSubCategories("Informatik",
                requiredSubCategories);

        for(SubCategory subCategory : subCategories)
            System.out.println("SubCategory of Informatik: " + subCategory.getSubCategoryName());
    }

    static void testWriter() throws ParserConfigurationException, TransformerException
    {
        XMLWriter xmlWriter = new XMLWriter();

        xmlWriter.elementBegin("Settings");

        xmlWriter.elementBegin("BackgroundColor");

        xmlWriter.setAttribute(null, "Cyan");

        xmlWriter.elementEnd(); // TODO: Make this function calls omissible

        xmlWriter.elementEnd();

        xmlWriter.saveTo("app\\src\\main\\res\\raw\\settings.xml");
    }

    /**
     * Traverses a list of Categories and outputs the content of the components.
     * @param categoryList list of Categories
     */
    public static void traverseBuiltCategories(List<Category> categoryList)
    {
        for(Category category : categoryList)
        {
            System.out.println("Category: " + category.getCategoryName());

            for(SubCategory subCategory : category.getSubCategories())
            {
                System.out.println("SubCategory: " + subCategory.getSubCategoryName());

                for (Question question : subCategory.getQuestions())
                {
                    System.out.println("Question: " + question.getQuestionText());

                    for (Answer answer : question.getAnswers())
                    {
                        System.out.println("Answer: " + answer.getAnswersText()
                                + " Correct: " + answer.isCorrect());
                    }
                }
            }
        }
    }
}
