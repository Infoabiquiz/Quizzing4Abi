package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.CQA_Loader;
import com.lfg.informatik.q11.quizzing4abi.Category;
import com.lfg.informatik.q11.quizzing4abi.GameData;
import com.lfg.informatik.q11.quizzing4abi.R;
import com.lfg.informatik.q11.quizzing4abi.SelectableCategory;
import com.lfg.informatik.q11.quizzing4abi.SubCategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 01.07.2015.
 * The second state if a new Game is started. It shows the available SubCategories for the
 * chosen Categories, from which the user chooses from.
 */

public class GameProperties2State extends GameState implements View.OnClickListener
{
    private List<SelectableCategory> selectableSubCategories;

    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameProperties2State(Application application, List<String> chosenCategories)
    {
        super(application);

        application.setLayout(R.layout.game_properties2);

        selectableSubCategories = new LinkedList<>();

        for(String categoryName : chosenCategories)
        {
            List<String> subCategoryNames = CQA_Loader.getAllSubCategoryNames(categoryName);
            if(subCategoryNames == null)
            {
                application.setState(new MainMenuState(application));
                return;
            }

            LinearLayout buttonList = (LinearLayout)application
                    .getViewByID(R.id.game_properties2_list);

            // For each SubCategory, add a button to the view
            // and create the SelectableCategory list.
            for(String subCategoryName : subCategoryNames)
            {
                Button button = application.createNewButton();
                button.setText(categoryName + " - " + subCategoryName);
                button.setOnClickListener(this);

                buttonList.addView(button, LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                selectableSubCategories.add(new SelectableCategory(categoryName,
                        subCategoryName, button));
            }
        }
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.game_properties2_menu:
            {
                application.setState(new MainMenuState(application));
                return;
            }
            case R.id.game_properties2_ok:
            {
                List<Category> categories = new LinkedList<>();

                String currentCategory = "";
                List<String> chosenSubCategories = new ArrayList<>();

                // TODO: Make a function for this
                //// Load all required Categories:
                // for each selectable button
                for(SelectableCategory selectableSubCategory : selectableSubCategories)
                {
                    // if the button is selected
                    if((boolean)selectableSubCategory.getCorrespondingButton().getTag())
                    {
                        // more than 1 subCategory of a Category chosen
                        if(currentCategory.equals(selectableSubCategory.getCategoryName()))
                        {
                            chosenSubCategories.add(selectableSubCategory.getSubCategoryName());
                        }
                        else // new Category begins
                        {
                            // process the SubCategories for the current Category
                            if(chosenSubCategories.size() > 0)
                            {
                                List<SubCategory> subCategories = CQA_Loader
                                        .loadSubCategories(currentCategory, chosenSubCategories);
                                categories.add(new Category(currentCategory, subCategories));
                                chosenSubCategories.clear();
                            }

                            // set the current Category and add the current subCategory
                            currentCategory = selectableSubCategory.getCategoryName();
                            chosenSubCategories.add(selectableSubCategory.getSubCategoryName());
                        }
                    }
                }
                // process the SubCategories for the last Category
                if(chosenSubCategories.size() > 0)
                {
                    List<SubCategory> subCategories = CQA_Loader
                            .loadSubCategories(currentCategory, chosenSubCategories);
                    categories.add(new Category(currentCategory, subCategories));
                    chosenSubCategories.clear();
                }

                application.setState(new ActiveQuestionState(application,
                        new GameData(categories)));
                return;
            }
        }

        // Color and tag the clicked button to mark it as chosen or not chosen.
        for(SelectableCategory selectableSubCategory : selectableSubCategories)
        {
            Button button = selectableSubCategory.getCorrespondingButton();
            if(button == view)
            {
                if(button.getTag() == null || !(boolean)button.getTag())
                {
                    button.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
                    button.setTag(true);
                }
                else
                {
                    button.getBackground().clearColorFilter();
                    button.setTag(false);
                }

                return;
            }
        }
    }
}
