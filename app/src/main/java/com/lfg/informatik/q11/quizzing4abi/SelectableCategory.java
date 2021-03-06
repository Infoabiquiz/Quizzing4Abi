package com.lfg.informatik.q11.quizzing4abi;

import android.widget.Button;

/**
 * Created by Chris on 14.07.2015.
 * Structure for temporarily saving the buttons in the game properties selection screen
 * and the corresponding Category (and subCategory names).
 */

public class SelectableCategory
{
    private String categoryName;
    private String subCategoryName;
    private Button correspondingButton;

    /**
     * Constructor.
     * @param categoryName the category name
     * @param subCategoryName the subCategory name
     * @param correspondingButton the button which shows the names
     */
    public SelectableCategory(String categoryName, String subCategoryName,
                              Button correspondingButton)
    {
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
        this.correspondingButton = correspondingButton;
    }

    /**
     * Constructor for saving only the category name.
     * @param categoryName the category name
     * @param correspondingButton the button which shows the name
     */
    public SelectableCategory(String categoryName, Button correspondingButton)
    {
        this.categoryName = categoryName;
        this.correspondingButton = correspondingButton;
    }

    /**
     * @return the Category name
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    /**
     * @return the name of the SubCategory
     */
    public String getSubCategoryName()
    {
        return subCategoryName;
    }

    /**
     * @return the button showing the category name(s)
     */
    public Button getCorrespondingButton()
    {
        return correspondingButton;
    }
}
