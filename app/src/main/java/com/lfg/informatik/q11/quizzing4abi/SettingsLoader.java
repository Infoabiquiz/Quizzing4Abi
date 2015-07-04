package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 29.06.2015.
 * This XMLHandler implementation loads the settings.
 */

public class SettingsLoader implements XMLHandler
{
    private String currentTag;
    private String backgroundColor;

    /**
     * After the loading process has finished, this method returns the background color.
     * @return background color as String
     */
    public String getBackgroundColor()
    {
        return backgroundColor;
    }

    /**
     * Has to be called at the occurrence of each beginning tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagBegin(String tagName)
    {
        currentTag = tagName;
    }

    /**
     * Has to be called for each ending tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagEnd(String tagName)
    {

    }

    /**
     * Has to be called for each attribute.
     * @param attributeName name of the attribute or null/"" for a text node
     * @param content       content of the attribute
     */
    @Override
    public void attribute(String attributeName, String content)
    {
        if(currentTag.equals("BackgroundColor"))
            backgroundColor = content;
    }
}
