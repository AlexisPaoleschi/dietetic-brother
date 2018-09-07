package view;

import controller.RecipeController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import model.DieteticBrotherModel;
import model.pojo.Food;

public class QuantityCell extends TableCell<Food, Boolean> {

    private DieteticBrotherModel model;
    private HBox hBox = new HBox();
    private Label quantityLabel;
    private static final int quantityStep1 = 1;
    private static final int quantityStep25 = 25;

    protected QuantityCell(DieteticBrotherModel model) {
        this.model = model;

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        quantityLabel = new Label();

        Button add1Button = new Button("+1");
        add1Button.setTooltip(new Tooltip("Ajouter 1 gramme à cet aliment"));
        add1Button.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(),
                                    this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) + quantityStep1));

        Button add25Button = new Button("+25");
        add25Button.setTooltip(new Tooltip("Ajouter 25 grammes à cet aliment"));
        add25Button.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(),
                                    this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) + quantityStep25));

        Button remove1Button = new Button("-1");
        remove1Button.setTooltip(new Tooltip("Enlever 1 gramme à cet aliment"));
        remove1Button.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(),
                                    this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) - quantityStep1));

        Button remove25Button = new Button("-25");
        remove25Button.setTooltip(new Tooltip("Enlever 25 grammes à cet aliment"));
        remove25Button.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(),
                                    this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) - quantityStep25));

        hBox.getChildren().addAll(quantityLabel, add1Button, add25Button, remove1Button, remove25Button);
    }

    /**
     * Méthode ajoutant un bouton seulement si la ligne n'est pas vide.
     */
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Food food = (Food) getTableRow().getItem();
            if (food != null) {
                quantityLabel.setText(Integer.toString(this.model.getRecipe().getFoodMap().get(getTableRow().getItem())) + "g     \t");
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(hBox);
            }
        } else {
            setGraphic(null);
        }
    }

}