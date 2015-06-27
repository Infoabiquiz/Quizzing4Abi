package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Chris on 27.06.2015.
 * This class takes callbacks of a SAXParser and forwards them to the XMLParser by using the Strategy pattern.
 */

public class SAXDocumentHandler extends DefaultHandler
{
    public static XMLParser xmlParser = null; // Strategy pattern

    @Override
    // Called at the beginning of an element.
    // xmlParser must not be null!
    public void startElement(String uri,        // irrelevant
                             String localName,  // irrelevant
                             String qName,      // TagName
                             Attributes attributes) throws SAXException
    {
        xmlParser.tagBegin(qName);

        for (int i = 0; i < attributes.getLength(); ++i)
        {
            String attributeName = attributes.getQName(i);
            String content = attributes.getValue(i);

            xmlParser.attribute(attributeName, content);
        }
    }

    @Override
    // Called at the end of an element. ( e.g. </end> )
    // xmlParser must not be null!
    public void endElement(String uri,
                           String localName,
                           String qName) // tagName
            throws SAXException
    {
        xmlParser.tagEnd(qName);
    }
}
