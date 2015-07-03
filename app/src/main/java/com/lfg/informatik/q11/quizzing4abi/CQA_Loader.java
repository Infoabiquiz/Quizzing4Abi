package com.lfg.informatik.q11.quizzing4abi;

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
    private static final String questionDataFilename = "app\\src\\main\\res\\raw\\question_data.xml";

    /**
     * Loads all or just required Categories.
     * @param requiredCategories list of names of specific required Categories or null
     * @return List of loaded Categories
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    static public List<Category> loadCategories(List<String> requiredCategories)
            throws IOException, SAXException, ParserConfigurationException
    {
        CategoryBuilder categoryBuilder = new CategoryBuilder(requiredCategories);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryBuilder);

        saxDocumentHandler.parse(questionDataFilename);

        return categoryBuilder.takeBuiltCategories();
    }

    /**
     * Loads all or just required SubCategories of one Category.
     * @param categoryName          name of the Category containing the SubCategories
     * @param requiredSubCategories list of names of required SubCategories or null
     * @return List of loaded SubCategories
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    static public List<SubCategory> loadSubCategories(String categoryName,
                                                      List<String> requiredSubCategories)
            throws IOException, SAXException, ParserConfigurationException
    {
        SubCategoryBuilder subCategoryBuilder = new SubCategoryBuilder(categoryName, requiredSubCategories);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(subCategoryBuilder);

        saxDocumentHandler.parse(questionDataFilename);

        return subCategoryBuilder.takeBuiltSubCategories();
    }

    /**
     * Loads and returns all names of the available Categories.
     * @return List of all available Category names
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    static public List<String> getAllCategoryNames()
            throws IOException, SAXException, ParserConfigurationException
    {
        CategoryNameLoader categoryNameLoader = new CategoryNameLoader();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryNameLoader);

        saxDocumentHandler.parse(questionDataFilename);

        return categoryNameLoader.takeLoadedCategoryNames();
    }

    /**
     * Loads and returns all names of the available SubCategories of one Category.
     * @param categoryName name of the Category containing the required SubCategories
     * @return List of all available SubCategory names
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    static public List<String> getAllSubCategoryNames(String categoryName)
            throws IOException, SAXException, ParserConfigurationException
    {
        SubCategoryNameLoader subCategoryNameLoader = new SubCategoryNameLoader(categoryName);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(subCategoryNameLoader);

        saxDocumentHandler.parse(questionDataFilename);

        return subCategoryNameLoader.takeLoadedSubCategoryNames();
    }
}