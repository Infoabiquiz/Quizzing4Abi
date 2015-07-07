package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Chris on 27.06.2015.
 * This class parses an xml file by taking callbacks of a SAXParser
 * and forwards them to a XMLHandler by using the Strategy pattern.
 * Note: Maximum text-node size currently 256 characters!
 */

public class SAXDocumentHandler extends DefaultHandler
{
    private XMLHandler xmlHandler;
    private StringBuffer stringBuffer;

    /**
     * Constructor.
     * @param xmlHandler a valid XMLHandler
     */
    SAXDocumentHandler(XMLHandler xmlHandler)
    {
        this.xmlHandler = xmlHandler;
    }

    /**
     * Starts parsing of the xml file, events are forwarded to the xmlHandler.
     * @param filename name of the xml file containing the question data
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException
     */
    public void parse(String filename)
            throws SAXException, ParserConfigurationException, IOException
    {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        saxParser.parse(filename, this);
    }

    /**
     * Called at the beginning of an element.
     * @param qName tagName
     * @throws SAXException
     */
    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes)
            throws SAXException
    {
        xmlHandler.tagBegin(qName);

        for (int i = 0; i < attributes.getLength(); ++i)
        {
            String attributeName = attributes.getQName(i);
            String content = attributes.getValue(i);

            xmlHandler.attribute(attributeName, content);
        }
    }

    /**
     * Called for each text node.
     * @param ch content
     * @throws SAXException
     */
    @Override
    public void characters (char ch[], int start, int length) throws SAXException
    {
        stringBuffer = new StringBuffer(256);
        stringBuffer.append(ch, start, length);
    }

    /**
     * Called at the end of an element. ( e.g. </end> )
     * @param qName tagName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri,
                           String localName,
                           String qName)
            throws SAXException
    {
        if(stringBuffer == null)
            xmlHandler.tagEnd(qName);
        else
        {
            xmlHandler.attribute(null, new String(stringBuffer));
            stringBuffer = null;
        }
    }
}
