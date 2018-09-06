package observer;

import java.util.List;

import model.pojo.Food;
import model.pojo.Recipe;

/**
 * Interface Observable du design pattern Observateur. <br>
 * <br>
 * Copyright : Copyright (c) 2015 <br>
 * <br>
 * Société : CLS (Collecte Localisation Satellites).
 *
 * @author Apside
 * @version $Revision: 1.0 $ - $Date: 16 Mars 2015 00:00:00 $
 */
public interface Observable {

    /**
     * Méthode d'ajout d'observateur.
     *
     * @param obs : observateur
     */
    public void addObserver(Observer obs);

    /**
     * Méthode de suppression des observateurs.
     */
    public void removeObserver();

    public void foodListChangeNotifyObserver(List<Food> foodList);

    public void recipeChangeNotifyObserver(Recipe recipe);
}