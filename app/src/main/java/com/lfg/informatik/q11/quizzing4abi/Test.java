package com.lfg.informatik.q11.quizzing4abi;

import android.app.AlertDialog;
import android.content.Context;

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
        exceptionAlertTest(null);
    }

    /**
     * Tests the loading process of the CQA_Loader
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void testCQA() throws ParserConfigurationException, SAXException, IOException
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

    public static void testWriter()
            throws ParserConfigurationException, TransformerException, IOException, SAXException
    {
        SettingsManager.setBackgroundColor("Cyan");

        System.out.println("Background Color: " + SettingsManager.getBackgroundColor());

        SettingsManager.setBackgroundColor("White");

        System.out.println("Background Color: " + SettingsManager.getBackgroundColor());
    }

    public static void exceptionAlertTest(Context context)
    {
        try
        {
            throw new IOException("Exception message test");
        }
        catch (IOException e)
        {
            ExceptionHandler.handleException(e);
        }
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
