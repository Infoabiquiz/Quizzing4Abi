package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.CQA_Loader;
import com.lfg.informatik.q11.quizzing4abi.SelectableCategory;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris on 01.07.2015.
 * The first state if a new Game is started. It shows the available Categories,
 * from which the user chooses from.
 */

public class GameProperties1State extends GameState implements View.OnClickListener
{
    private List<SelectableCategory> selectableCategories;

    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameProperties1State(Application application)
    {
        super(application);

        application.setLayout(R.layout.game_properties1);

        List<String> allCategoryNames = CQA_Loader.getAllCategoryNames();
        if(allCategoryNames == null)
        {
            application.setState(new MainMenuState(application));
            return;
        }

        selectableCategories = new LinkedList<>();

        LinearLayout buttonList = (LinearLayout)application.getViewByID(R.id.game_properties1_list);

        // For each Category, add a button to the view and create the SelectableCategory list.
        for(String categoryName : allCategoryNames)
        {
            Button button = application.createNewButton();
            button.setText(categoryName);
            button.setOnClickListener(this);

            buttonList.addView(button, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            selectableCategories.add(new SelectableCategory(categoryName, button));
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
            case R.id.game_properties1_menu:
            {
                application.setState(new MainMenuState(application));
                return;
            }
            case R.id.game_properties1_ok:
            {
                List<String> chosenCategories = new ArrayList<>();
                for(SelectableCategory selectableCategory : selectableCategories)
                {
                    Object tag = selectableCategory.getCorrespondingButton().getTag();
                    if(tag != null && (Boolean)tag)
                        chosenCategories.add(selectableCategory.getCategoryName());
                }

                application.setState(new GameProperties2State(application, chosenCategories));
                return;
            }
        }

        // Color and tag the clicked button to mark it as chosen or not chosen.
        for(SelectableCategory selectableCategory : selectableCategories)
        {
            Button button = selectableCategory.getCorrespondingButton();
            if(button == view)
            {
                if(button.getTag() == null || !(Boolean)button.getTag())
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
