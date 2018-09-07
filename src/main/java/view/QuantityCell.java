package view;

import controller.RecipeController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.DieteticBrotherModel;
import model.pojo.Food;

public class QuantityCell extends TableCell<Food, Boolean> {

    private DieteticBrotherModel model;
    private HBox hBox = new HBox();
    private Label quantityLabel;
    private static final int tableIconImageSize = 16;
    private static final int quantityStep = 25;

    protected QuantityCell(DieteticBrotherModel model) {
        this.model = model;

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        quantityLabel = new Label();

        ImageView addImageView = new ImageView(new Image("icon/add.png"));
        addImageView.setFitHeight(tableIconImageSize);
        addImageView.setFitWidth(tableIconImageSize);

        Button addButton = new Button("");
        addButton.setGraphic(addImageView);
        addButton.setPrefSize(25, 25);
        addButton.setTooltip(new Tooltip("Ajouter 5 grammes à cet aliment"));
        addButton.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(), this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) + quantityStep));

        ImageView removeImageView = new ImageView(new Image("icon/remove.png"));
        removeImageView.setFitHeight(tableIconImageSize);
        removeImageView.setFitWidth(tableIconImageSize);

        Button removeButton = new Button("");
        removeButton.setGraphic(removeImageView);
        removeButton.setPrefSize(25, 25);
        removeButton.setTooltip(new Tooltip("Enlever 5 grammes à cet aliment"));
        removeButton.setOnAction(event -> RecipeController.getInstance()
                .updateFoodQuantity((Food) getTableRow().getItem(), this.model.getRecipe().getFoodMap().get(getTableRow().getItem()) - quantityStep));

        hBox.getChildren().addAll(quantityLabel, addButton, removeButton);
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