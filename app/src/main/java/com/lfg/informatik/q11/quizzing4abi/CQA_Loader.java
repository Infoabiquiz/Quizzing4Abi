package com.lfg.informatik.q11.quizzing4abi;

import com.lfg.informatik.q11.quizzing4abi.model_io.CategoryBuilder;
import com.lfg.informatik.q11.quizzing4abi.model_io.CategoryNameLoader;
import com.lfg.informatik.q11.quizzing4abi.model_io.SAXDocumentHandler;
import com.lfg.informatik.q11.quizzing4abi.model_io.SubCategoryBuilder;
import com.lfg.informatik.q11.quizzing4abi.model_io.SubCategoryNameLoader;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Chris on 27.06.2015.
 * This Loader represents a Facade object, that manages the parsing and building
 * process of the Categories, SubCategories, Questions and Answers.
 */

public class CQA_Loader
{
    private static final String questionDataFilename =
            "app\\src\\main\\res\\raw\\question_data.xml";

    /**
     * Loads all or just required Categories.
     * @param requiredCategories list of names of specific required Categories or null
     * @return List of loaded Categories or null if loading failed
     */
    static public List<Category> loadCategories(List<String> requiredCategories)
    {
        CategoryBuilder categoryBuilder = new CategoryBuilder(requiredCategories);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryBuilder);

        try
        {
            saxDocumentHandler.parse(questionDataFilename);
        }
        catch (SAXException | IOException | ParserConfigurationException e)
        {
            ExceptionHandler.showAlertDialog("Loading Categories failed. Error: "
            + e.getMessage());

            return null;
        }

        return categoryBuilder.takeBuiltCategories();
    }

    /**
     * Loads all or just required SubCategories of one Category.
     * @param categoryName          name of the Category containing the SubCategories
     * @param requiredSubCategories list of names of required SubCategories or null
     * @return List of loaded SubCategories or null if loading failed
     */
    static public List<SubCategory> loadSubCategories(String categoryName,
                                                      List<String> requiredSubCategories)
    {
        SubCategoryBuilder subCategoryBuilder = new SubCategoryBuilder(categoryName,
                requiredSubCategories);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(subCategoryBuilder);

        try
        {
            saxDocumentHandler.parse(questionDataFilename);
        }
        catch (SAXException | IOException | ParserConfigurationException e)
        {
            ExceptionHandler.showAlertDialog("Loading SubCategories failed. Error: "
                    + e.getMessage());

            return null;
        }

        return subCategoryBuilder.takeBuiltSubCategories();
    }

    /**
     * Loads and returns all names of the available Categories.
     * @return List of all available Category names or null if loading failed
     */
    static public List<String> getAllCategoryNames()
    {
        CategoryNameLoader categoryNameLoader = new CategoryNameLoader();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryNameLoader);

        try
        {
            saxDocumentHandler.parse(questionDataFilename);
        }
        catch (SAXException | IOException | ParserConfigurationException e)
        {
            ExceptionHandler.showAlertDialog("Loading CategoryNames failed. Error: "
                    + e.getMessage());

            return null;
        }

        return categoryNameLoader.takeLoadedCategoryNames();
    }

    /**
     * Loads and returns all names of the available SubCategories of one Category.
     * @param categoryName name of the Category containing the required SubCategories
     * @return List of all available SubCategory names or null if loading failed
     */
    static public List<String> getAllSubCategoryNames(String categoryName)
    {
        SubCategoryNameLoader subCategoryNameLoader = new SubCategoryNameLoader(categoryName);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(subCategoryNameLoader);

        try
        {
            saxDocumentHandler.parse(questionDataFilename);
        }
        catch (SAXException | IOException | ParserConfigurationException e)
        {
            ExceptionHandler.showAlertDialog("Loading SubCategoryNames failed. Error: "
                    + e.getMessage());

            return null;
        }

        return subCategoryNameLoader.takeLoadedSubCategoryNames();
    }
}