package com.lfg.informatik.q11.quizzing4abi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 29.06.2015.
 * This XMLHandler implementation finds all available SubCategory names for
 * a specific Category and saves them in a List.
 */

public class SubCategoryNameLoader implements XMLHandler
{
    private List<String> subCategoryNames;
    private String categoryName;
    private String currentCategory;
    private String currentTag;

    /**
     * Constructor.
     * @param categoryName name of the Category containing the required SubCategories
     */
    public SubCategoryNameLoader(String categoryName)
    {
        subCategoryNames = new LinkedList<>();
        this.categoryName = categoryName;
    }

    /**
     * After the loading process has finished, calling this method will return the List of
     * the SubCategories names and transfer ownership to the caller.
     * @return List of loaded SubCategory names
     */
    public List<String> takeLoadedSubCategoryNames()
    {
        List<String> temp = new ArrayList<>(subCategoryNames);
        subCategoryNames = new LinkedList<>();
        return temp;
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
     * @param attributeName name of the attribute
     * @param content       content of the attribute
     */
    @Override
    public void attribute(String attributeName, String content)
    {
        if(currentTag.equals("Category") && attributeName.equals("Text"))
        {
            currentCategory = content;
        }
        else if(currentTag.equals("SubCategory") && attributeName.equals("Text")
                && categoryName.equals(currentCategory))
        {
            if(!subCategoryNames.contains(content))
                subCategoryNames.add(content);
        }
    }
}
