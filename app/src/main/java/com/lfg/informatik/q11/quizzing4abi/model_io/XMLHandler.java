package com.lfg.informatik.q11.quizzing4abi.model_io;

/**
 * Created by Chris on 29.06.2015.
 * This interface provides basic functions for reading an xml file.
 * The actual parsing takes place in another class, which then can forward the events
 * to this handler.
 */

public interface XMLHandler
{
    /**
     * Has to be called at the occurrence of a each beginning tag.
     * @param tagName the name of the tag
     */
    void tagBegin(String tagName);

    /**
     * Has to be called at the each ending tag.
     * @param tagName the name of the tag
     */
    void tagEnd(String tagName);

    /**
     * Has to be called for each attribute.
     * @param attributeName name of the attribute or null/"" for a text node
     * @param content       content of the attribute
     */
    void attribute(String attributeName, String content);
}
