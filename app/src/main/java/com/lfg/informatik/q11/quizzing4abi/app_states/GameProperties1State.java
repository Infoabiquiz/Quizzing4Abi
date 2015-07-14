package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.CQA_Loader;
import com.lfg.informatik.q11.quizzing4abi.SelectableCategory;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dominik and Adrian on 01.07.2015.
 * The first state if a new Game is started. It shows the available Categories,
 * from which the user chooses from.
 */

public class GameProperties1State extends GameState
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

        // For each Category, add a button to the view and create the SelectableCategory list.
        for(String categoryName : allCategoryNames)
        {
            ListView listView = (ListView)application.getViewByID(R.id.game_properties1_list);
            Button button = application.createNewButton();
            button.setText(categoryName);
            listView.addFooterView(button);

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
        // TODO: Add functionality
        switch(view.getId())
        {
            case R.id.game_properties1_menu:
            {
                application.setState(new MainMenuState(application));
                break;
            }
        }
    }
}
