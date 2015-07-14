package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.CQA_Loader;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.List;

/**
 * Created by Chris on 01.07.2015.
 * The second state if a new Game is started. It shows the available SubCategories for the
 * chosen Categories, from which the user chooses from.
 */

public class GameProperties2State extends GameState
{
    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameProperties2State(Application application, List<String> chosenCategories)
    {
        super(application);

        application.setLayout(R.layout.game_properties2);

        for(String categoryName : chosenCategories)
        {
            List<String> subCategories = CQA_Loader.getAllSubCategoryNames(categoryName);
            if(subCategories == null)
            {
                application.setState(new MainMenuState(application));
                return;
            }

            for(String subCategoryName : subCategories)
            {
                ListView listView = (ListView)application.getViewByID(R.id.game_properties2_list);
                Button button = application.createNewButton();
                button.setText(categoryName + " - " + subCategoryName);
                listView.addFooterView(button);

                // TODO: New class for temporary saving the category names and the buttons
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
        // TODO: Add functionality
        switch(view.getId())
        {
            case R.id.game_properties2_menu:
            {
                application.setState(new MainMenuState(application));
                //return
                break;
            }
    }
}
