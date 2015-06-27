package com.lfg.informatik.q11.quizzing4abi;

/**
 * Created by Chris on 27.06.2015.
 * This class is an example test handler of a SAXParser.
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDocumentHandler extends DefaultHandler
{
    @Override
    // Called at the end of the xml document.
    public void startDocument() throws SAXException
    {
        System.out.println("Document start");
    }

    @Override
    // Called at the end of the xml document.
    public void endDocument() throws SAXException
    {
        System.out.println("Document end");
    }

    @Override
    // Called at the beginning of an element.
    public void startElement(String uri,        // irrelevant
                             String localName,  // irrelevant
                             String qName,      // TagName
                             Attributes attributes)
            throws SAXException
    {
        String text = attributes.getValue("Text");
        System.out.println("TagName: " + qName + " Text: " + text);
    }

    @Override
    // Called at the end of an element. ( e.g. </end> )
    public void endElement(String uri,
                           String localName,
                           String qName)
            throws SAXException
    {
        System.out.println("End TagName: " + qName);
    }
}
