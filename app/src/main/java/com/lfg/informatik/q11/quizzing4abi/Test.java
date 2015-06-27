package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Chris on 26.06.2015.
 * for testing purposes...
 */

import org.xml.sax.*;
import java.io.IOException;
import javax.xml.parsers.*;

public class Test
{
    public final static String raw = "app\\src\\main\\res\\raw\\";

    public static void showTestLayout(MainActivity mainActivity)
    {
        mainActivity.setContentView(R.layout.test_layout);
    }


    public static void main(String args[]) throws IOException, SAXException, ParserConfigurationException
    {
        saxParserTest(raw + "question_data.xml");
    }

    public static void saxParserTest(String fileName) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        SAXDocumentHandler exampleHandler = new SAXDocumentHandler();
        parser.parse(fileName, exampleHandler);
    }
}
