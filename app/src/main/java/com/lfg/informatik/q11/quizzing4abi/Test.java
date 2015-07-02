package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;

/**
 * Created by Chris on 26.06.2015.
 * for testing purposes...
 */

public class Test
{
    public final static String raw = "app\\src\\main\\res\\raw\\";

    /**
     * -> MainActivity::setContentView is public.
     */
    public static void showTestLayout(MainActivity mainActivity)
    {
        mainActivity.setContentView(R.layout.test_layout);
    }

    /**
     * Test main
     */
    public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException
    {
        List<String> requiredCategories = new ArrayList<>();
        requiredCategories.add("Informatik");
        List<Category> categories = CQA_Loader.loadCategories(requiredCategories);

        traverseBuiltCategories(categories);

        System.out.println("\n");

        List<String> categoryNames = CQA_Loader.getAllCategoryNames();
        for(String name : categoryNames)
            System.out.println("CategoryName: " + name);
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
                        System.out.println("Answer: " + answer.getAnswersText() + " Correct: " + answer.isCorrect());
                    }
                }
            }
        }
    }
}
