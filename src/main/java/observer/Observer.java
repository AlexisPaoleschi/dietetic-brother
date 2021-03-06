package observer;

import java.util.List;

import model.pojo.Food;
import model.pojo.Recipe;

/**
 * Interface Observer du design pattern Observateur. <br>
 * <br>
 * Copyright : Copyright (c) 2015 <br>
 * <br>
 * Société : CLS (Collecte Localisation Satellites).
 *
 * @author Apside
 * @version $Revision: 1.0 $ - $Date: 16 Mars 2015 00:00:00 $
 */
public interface Observer {

    public void updateFoodList(List<Food> foodList);

    public void updateRecipe(Recipe recipe);

}