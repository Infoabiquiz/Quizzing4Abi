package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.*;
import java.io.IOException;
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
        XMLParser xmlParser = new XMLParser();
        saxParseXMLFile(raw + "question_data.xml", xmlParser);

        for(String category : xmlParser.categories)
            System.out.println("Category: " + category);
        for(String question : xmlParser.questions)
            System.out.println("Question: " + question);
        for(String answer : xmlParser.answers)
            System.out.println("Answer: " + answer);
        for(boolean correct : xmlParser.answerCorrectness)
            System.out.println("Correct: " + correct);
    }

    /**
     * Reads the xml file specified by fileName with SAXParser and forwards
     * tag and attribute occurrences to the XMLParser.
     */
    public static void saxParseXMLFile(String fileName, XMLParser xmlParser)
            throws ParserConfigurationException, SAXException, IOException
    {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(xmlParser);
        saxParser.parse(fileName, saxDocumentHandler);
    }
}
