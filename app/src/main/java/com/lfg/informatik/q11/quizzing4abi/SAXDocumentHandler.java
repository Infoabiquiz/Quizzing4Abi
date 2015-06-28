package com.lfg.informatik.q11.quizzing4abi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Chris on 27.06.2015.
 * This class takes callbacks of a SAXParser and forwards them to the CQA_Loader by using the Strategy pattern.
 */

public class SAXDocumentHandler extends DefaultHandler
{
    public final CQA_Loader cqa_Loader; // Strategy pattern

    /**
     * Constructor.
     * @param cqa_Loader a valid CQA_Loader
     */
    SAXDocumentHandler(CQA_Loader cqa_Loader)
    {
        this.cqa_Loader = cqa_Loader;
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
        cqa_Loader.tagBegin(qName);

        for (int i = 0; i < attributes.getLength(); ++i)
        {
            String attributeName = attributes.getQName(i);
            String content = attributes.getValue(i);

            cqa_Loader.attribute(attributeName, content);
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
        cqa_Loader.tagEnd(qName);
    }
}
