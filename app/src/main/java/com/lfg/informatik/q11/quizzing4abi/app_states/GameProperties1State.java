package com.lfg.informatik.q11.quizzing4abi.app_states;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.lfg.informatik.q11.quizzing4abi.Application;
import com.lfg.informatik.q11.quizzing4abi.CQA_Loader;
import com.lfg.informatik.q11.quizzing4abi.Category;
import com.lfg.informatik.q11.quizzing4abi.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Dominik and Adrian on 01.07.2015.
 * The first state if a new Game is started. It shows the available Categories,
 * from which the user chooses from.
 */

public class GameProperties1State extends GameState
{

    private List<Category> categories;//Dolan plz
    List <Button> buttoncategory;
    /**
     * Constructor.
     * @param application a valid Application
     */
    public GameProperties1State(Application application)
    {
        super(application);

        application.setLayout(R.layout.game_properties1);
        List<String> allCategories = CQA_Loader.getAllCategoryNames();
        for(String categoryName : allCategories)
        {

            if(allCategories == null)
            {
                application.setState(new MainMenuState(application));
                return;
            }

            for(String CategoryName : allCategories)
            {
                ListView listView = (ListView)application.getViewByID(R.id.game_properties1_list);
                Button button = application.createNewButton();
                button.setText(categoryName);
                listView.addFooterView(button);

                // TODO: New class for temporary saving the category names and the buttons
            }
        }

        // TODO: Add buttons dynamically
    }

    /**
     * Handles user click events.
     * @param view the click source (e.g. button)
     */
    @Override
    public void onClick(View view)
    {
        // TODO: Add functionality
        switch(view.getId()) {
            case R.id.game_properties1_menu: {
                application.setState(new MainMenuState(application));
                //return
                break;
            }
        }
    }
}
