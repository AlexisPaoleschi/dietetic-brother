package launcher;

import model.DieteticBrotherModel;
import model.pojo.Food;

public class DieteticBrotherMain {

    public static void main(String[] args) {
        DieteticBrotherModel model = new DieteticBrotherModel();

        Food viande = new Food(0, "Viande", 50.0, 25.0, 15.0);
        model.addAvailableFood(viande);
    }
}
