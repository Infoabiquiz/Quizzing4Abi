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

    public static void showTestLayout(MainActivity mainActivity)
    {
        mainActivity.setContentView(R.layout.test_layout);
    }

    public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException
    {
        SAXDocumentHandler.xmlParser = new XMLParser();
        saxParseXMLFile(raw + "question_data.xml");

        for(String category : SAXDocumentHandler.xmlParser.categories)
            System.out.println("Category: " + category);
        for(String question : SAXDocumentHandler.xmlParser.questions)
            System.out.println("Question: " + question);
        for(String answer : SAXDocumentHandler.xmlParser.answers)
            System.out.println("Answer: " + answer);
    }

    public static void saxParseXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler();
        parser.parse(fileName, saxDocumentHandler);
    }
}
