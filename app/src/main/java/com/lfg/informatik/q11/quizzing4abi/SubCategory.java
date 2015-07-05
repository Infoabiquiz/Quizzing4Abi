package com.lfg.informatik.q11.quizzing4abi;

import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 02.07.2015.
 * This class represents a SubCategory of a Category.
 */

public class SubCategory
{
    private String subCategoryName;
    private List<Question> questions;

    /**
     * Contructor.
     * @param subCategoryName name of this SubCategory
     * @param questions       List of Questions
     */
    public SubCategory(String subCategoryName, List<Question> questions)
    {
        this.subCategoryName = subCategoryName;
        this.questions = questions;
    }

    /**
     * Returns the name of this SubCategory.
     * @return name of this SubCategory
     */
    public String getSubCategoryName()
    {
        return subCategoryName;
    }

    /**
     * Returns the list of questions as readonly.
     * @return list of Questions
     */
    public List<Question> getQuestions()
    {
        return Collections.unmodifiableList(questions);
    }
}
