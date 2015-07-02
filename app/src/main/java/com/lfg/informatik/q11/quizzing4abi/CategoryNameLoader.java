package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 29.06.2015.
 * This XMLHandler implementation finds all available Category names and
 * saves them in a List.
 */

public class CategoryNameLoader implements XMLHandler
{
    private List<String> categoryNames;
    private String currentTag;

    public CategoryNameLoader()
    {
        categoryNames = new ArrayList<>();
    }

    /**
     * After the load process has finished, calling this method will return the List of
     * the Categories names and transfer ownership to the caller.
     * @return List of loaded Category names
     */
    public List<String> takeLoadedCategoryNames()
    {
        List<String> temp = categoryNames;
        categoryNames = new ArrayList<>();
        return temp;
    }

    /**
     * Has to be called at the occurrence of a each beginning tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagBegin(String tagName)
    {
        currentTag = tagName;
    }

    /**
     * Has to be called at the each ending tag.
     * @param tagName the name of the tag
     */
    @Override
    public void tagEnd(String tagName)
    {
        //return null;
    }

    /**
     * Has to be called for each attribute.
     * @param attributeName name of the attribute
     * @param content       content of the attribute
     */
    @Override
    public void attribute(String attributeName, String content)
    {
        if(currentTag.equals("Category") && attributeName.equals("Text"))
        {
            if(!categoryNames.contains(content))
                categoryNames.add(content);
        }
    }
}
