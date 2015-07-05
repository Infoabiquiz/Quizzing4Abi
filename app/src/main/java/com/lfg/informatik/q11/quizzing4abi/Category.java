package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;

/**
 * Created by Adrian on 27.06.2015.
 * This class represents a Category for the quiz (= school subject).
 * It contains the relevant SubCategories and Questions with the Answers.
 */

public class Category
{
    private String categoryName;
    private List<SubCategory> subCategories;

    /**
     * Constructor.
     * @param categoryName name of this category
     * @param subCategories        list of Questions
     */
    public Category(String categoryName, List<SubCategory> subCategories)
    {
        this.categoryName = categoryName;
        this.subCategories = subCategories;
    }

    /**
     * Returns the category name.
     * @return name of this Category
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * Returns the SubCategories as readonly.
     * @return the unmodifiable list of SubCategories
     */
    public List<SubCategory> getSubCategories()
    {
        return Collections.unmodifiableList(subCategories);
    }
}
