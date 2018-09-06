package view;

import controller.RecipeController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.pojo.Food;

public class DeleteButtonCell extends TableCell<Food, Boolean> {

    private HBox hBox = new HBox();
    private int tableIconImageSize = 16;

    protected DeleteButtonCell() {
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        ImageView deleteImageView = new ImageView(new Image("icon/delete.png"));
        deleteImageView.setFitHeight(tableIconImageSize);
        deleteImageView.setFitWidth(tableIconImageSize);

        Button deleteButton = new Button("");
        deleteButton.setGraphic(deleteImageView);
        deleteButton.setPrefSize(25, 25);
        deleteButton.setTooltip(new Tooltip("Supprimer l'aliment de la recette"));
        deleteButton.setOnAction(event -> RecipeController.getInstance().deleteFoodFromRecipe((Food) getTableRow().getItem()));
        hBox.getChildren().add(deleteButton);
    }

    /**
     * Méthode ajoutant un bouton seulement si la ligne n'est pas vide.
     */
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(hBox);
        } else {
            setGraphic(null);
        }
    }

}