package com.lfg.informatik.q11.quizzing4abi.model_io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.OutputStream;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Chris on 04.07.2015.
 * With this class you can generate and save an xml file.
 * Build the document by calling the elementBegin / -End function for each element
 * and the setAttribute function for each attribute of an element.
 */

public class XMLWriter
{
    private Document doc;
    private Stack<Element> nodeStack;

    /**
     * Constructor.
     * @throws ParserConfigurationException
     */
    public XMLWriter() throws ParserConfigurationException
    {
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        doc = docBuilder.newDocument();
        nodeStack = new Stack<>();
    }

    /**
     * Call this function at the beginning of each element.
     * @param elementName name of the element/tag
     */
    public void elementBegin(String elementName)
    {
        nodeStack.push(doc.createElement(elementName));
    }

    /**
     * Call this function at the closing tag of each element.
     * You can omit to call this function for the very last closing tags,
     * if no new elements begin or attributes are set.
     * Example:
     * ...
     * elementEnd // has to be called due to following begin or attribute function calls
     * ...
     * elementBegin/setAttribute
     * elementEnd // can be omitted
     * elementEnd // can be omitted
     */
    public void elementEnd()
    {
        Element element = nodeStack.pop();

        if(!nodeStack.empty())
            nodeStack.peek().appendChild(element);
        else
            doc.appendChild(element);
    }

    /**
     * Call this function for each attribute or text node.
     * @param attributeName name of the attribute or null/"" for a text node
     * @param content content of the attribute or the text node
     */
    public void setAttribute(String attributeName, String content)
    {
        if(attributeName == null || attributeName.isEmpty())
            nodeStack.peek().appendChild(doc.createTextNode(content));
        else
            nodeStack.peek().setAttribute(attributeName, content);
    }

    /**
     * Saves the generated document to the xml file specified by the output stream.
     * @param outputStream output stream of the target xml file
     * @throws TransformerException
     */
    public void saveTo(OutputStream outputStream) throws TransformerException
    {
        generateLastClosingTags();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        doc.setXmlStandalone(true);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(outputStream);

        transformer.transform(source, result);
    }

    /**
     * Generates the omitted closing tags, if any.
     * Thereby the xml document gets finished and can be saved.
     */
    private void generateLastClosingTags()
    {
        while(!nodeStack.isEmpty())
        {
            elementEnd();
        }
    }
}
