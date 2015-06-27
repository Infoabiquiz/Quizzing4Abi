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
    public final XMLParser xmlParser; // Strategy pattern

    /**
     * Constructor.
     * @param xmlParser a valid XMLParser
     */
    SAXDocumentHandler(XMLParser xmlParser)
    {
        this.xmlParser = xmlParser;
    }

    @Override
    /**
     * Called at the beginning of an element.
     * @param qName tagName
     */
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes)
            throws SAXException
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
    /**
     * Called at the end of an element. ( e.g. </end> )
     * @param qName tagName
     */
    public void endElement(String uri,
                           String localName,
                           String qName)
            throws SAXException
    {
        xmlParser.tagEnd(qName);
    }
}
