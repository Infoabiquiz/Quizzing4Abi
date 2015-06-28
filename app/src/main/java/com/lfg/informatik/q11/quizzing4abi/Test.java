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
        CQA_Loader cqa_Loader = new CQA_Loader();
        saxParseXMLFile(raw + "question_data.xml", cqa_Loader);

        for(String category : cqa_Loader.categories)
            System.out.println("Category: " + category);
        for(String question : cqa_Loader.questions)
            System.out.println("Question: " + question);
        for(String answer : cqa_Loader.answers)
            System.out.println("Answer: " + answer);
        for(boolean correct : cqa_Loader.answerCorrectness)
            System.out.println("Correct: " + correct);
    }

    /**
     * Reads the xml file specified by fileName with SAXParser and forwards
     * tag and attribute occurrences to the CQA_Loader.
     */
    public static void saxParseXMLFile(String fileName, CQA_Loader cqa_Loader)
            throws ParserConfigurationException, SAXException, IOException
    {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        SAXDocumentHandler saxDocumentHandler = new SAXDocumentHandler(cqa_Loader);
        saxParser.parse(fileName, saxDocumentHandler);
    }
}
