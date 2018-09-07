package view;

import controller.RecipeController;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.DieteticBrotherModel;
import model.pojo.Food;

public class QuantityCell extends TableCell<Food, Boolean> {

    private DieteticBrotherModel model;
    private TableView<Food> myRecipeTableview;
    private HBox hBox = new HBox();
    private Label quantityLabel;
    private SpinnerValueFactory<Integer> quantitySpinnerFactory;
    private int tableIconImageSize = 16;

    protected QuantityCell(DieteticBrotherModel model, TableView<Food> myRecipeTableview) {
        this.model = model;
        this.myRecipeTableview = myRecipeTableview;

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        quantityLabel = new Label();

        ImageView addImageView = new ImageView(new Image("icon/add.png"));
        addImageView.setFitHeight(tableIconImageSize);
        addImageView.setFitWidth(tableIconImageSize);

        Button addButton = new Button("");
        addButton.setGraphic(addImageView);
        addButton.setPrefSize(25, 25);
        addButton.setTooltip(new Tooltip("Ajouter 5 grammes à  cet aliment"));
        addButton.setOnAction(event -> RecipeController.getInstance().updateFoodQuantity((Food) getTableRow().getItem(), model.getRecipe().getFoodMap().get(getTableRow().getItem()) + 25));

        ImageView removeImageView = new ImageView(new Image("icon/remove.png"));
        removeImageView.setFitHeight(tableIconImageSize);
        removeImageView.setFitWidth(tableIconImageSize);

        Button removeButton = new Button("");
        removeButton.setGraphic(removeImageView);
        removeButton.setPrefSize(25, 25);
        removeButton.setTooltip(new Tooltip("Enlever 5 grammes à  cet aliment"));
        removeButton.setOnAction(event -> RecipeController.getInstance().updateFoodQuantity((Food) getTableRow().getItem(), model.getRecipe().getFoodMap().get(getTableRow().getItem()) - 25));

        hBox.getChildren().addAll(quantityLabel, addButton, removeButton);
    }

    /**
     * MÃ©thode ajoutant un bouton seulement si la ligne n'est pas vide.
     */
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Food food = (Food) getTableRow().getItem();
            if (food != null) {
                quantityLabel.setText(Integer.toString(model.getRecipe().getFoodMap().get(getTableRow().getItem())) + "g     \t");
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(hBox);
            }
        } else {
            setGraphic(null);
        }
    }

}