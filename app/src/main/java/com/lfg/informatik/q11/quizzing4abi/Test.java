package com.lfg.informatik.q11.quizzing4abi;

import android.graphics.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris on 26.06.2015.
 * for testing purposes...
 */

public class Test
{
    /**
     * Test main
     */
    public static void main(String args[])
    {
        testCQA();
    }

    /**
     * Tested a way to convert Date to String.
     */
    public static void testDateFormatting()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
        String dateAsString = simpleDateFormat.format(date);

        System.out.println("Current date: " + dateAsString);

        try
        {
            date = simpleDateFormat.parse(dateAsString);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Tests the loading process of the CQA_Loader
     */
    public static void testCQA()
    {
        List<String> requiredCategories = new ArrayList<>();
        requiredCategories.add("Informatik");
        List<Category> categories = CQA_Loader.loadCategories(requiredCategories);

        traverseBuiltCategories(categories);

        System.out.println("\n");

        List<String> categoryNames = CQA_Loader.getAllCategoryNames();
        assert categoryNames != null;
        for(String name : categoryNames)
            System.out.println("CategoryName: " + name);

        List<String> requiredSubCategories = new ArrayList<>();
        requiredSubCategories.add("Q11/1");

        List<SubCategory> subCategories = CQA_Loader.loadSubCategories("Informatik",
                requiredSubCategories);

        assert subCategories != null;
        for(SubCategory subCategory : subCategories)
            System.out.println("SubCategory of Informatik: " + subCategory.getSubCategoryName());
    }

    public static void testWriter()
    {
        SettingsManager.setBackgroundColor(Color.CYAN);

        System.out.println("Background Color: " + SettingsManager.getBackgroundColor());

        SettingsManager.setBackgroundColor(Color.WHITE);

        System.out.println("Background Color: " + SettingsManager.getBackgroundColor());
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
