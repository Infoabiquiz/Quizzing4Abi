package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Chris on 27.06.2015.
 * This Loader represents a Facade object, that manages the parsing and building
 * process of the Categories, Questions and Answers.
 */

public class CQA_Loader
{
    // TODO: Facade as Singleton or static?
    // TODO: Find a better way for passing in the question_data filename.

    /**
     * This function loads all or just the required Categories.
     * @param filename           name of the xml file containing the question data
     * @param requiredCategories list of specific required Categories or null
     * @return List of loaded Categories
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public List<Category> loadCategories(String filename, List<String> requiredCategories)
            throws IOException, SAXException, ParserConfigurationException
    {
        CategoryBuilder categoryBuilder = new CategoryBuilder(requiredCategories);
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryBuilder);

        saxDocumentHandler.parse(filename);

        return categoryBuilder.takeBuiltCategories();
    }

    /**
     * Loads and returns all names of the available Categories.
     * @param filename name of the xml file containing the question data
     * @return List of all available Category names
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public List<String> getAllCategoryNames(String filename)
            throws IOException, SAXException, ParserConfigurationException
    {
        CategoryNameLoader categoryNameLoader = new CategoryNameLoader();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(categoryNameLoader);

        saxDocumentHandler.parse(filename);

        return categoryNameLoader.takeLoadedCategoryNames();
    }
}
