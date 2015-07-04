package com.lfg.informatik.q11.quizzing4abi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
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

public class XMLWriter // TODO: Finish class
{
    private static Document doc;
    private static Stack<Element> nodeStack;

    public static void main(String args[])
            throws ParserConfigurationException, TransformerException
    {
        init();

        elementBegin("Settings");

        elementBegin("BackgroundColor");

        setAttribute(null, "Cyan");

        elementEnd(); // TODO: Make this function calls omissible

        elementEnd();

        save("app\\src\\main\\res\\raw\\settings.xml");
    }

    public static void init() throws ParserConfigurationException
    {
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        doc = docBuilder.newDocument();
        nodeStack = new Stack<>();
    }

    public static void elementBegin(String elementName)
    {
        nodeStack.push(doc.createElement(elementName));
    }

    public static void elementEnd()
    {
        Element element = nodeStack.pop();

        if(!nodeStack.empty())
            nodeStack.peek().appendChild(element);
        else
            doc.appendChild(element);
    }

    public static void setAttribute(String attributeName, String content)
    {
        if(attributeName == null || attributeName.isEmpty())
            nodeStack.peek().appendChild(doc.createTextNode(content));
        else
            nodeStack.peek().setAttribute(attributeName, content);
    }

    public static void save(String filename) throws TransformerException
    {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        doc.setXmlStandalone(true);

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));

        transformer.transform(source, result);
    }
}
