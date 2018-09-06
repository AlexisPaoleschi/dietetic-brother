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

    private final HBox hBox = new HBox();
    private final int tableIconImageSize = 16;

    public DeleteButtonCell() {
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        ImageView addImageView = new ImageView(new Image("icon/delete.png"));
        addImageView.setFitHeight(tableIconImageSize);
        addImageView.setFitWidth(tableIconImageSize);

        Button addButton = new Button("");
        addButton.setGraphic(addImageView);
        addButton.setPrefSize(25, 30);
        addButton.setTooltip(new Tooltip("Supprimer l'aliment de la recette"));
        addButton.setOnAction(event -> RecipeController.getInstance().deleteFoodFromRecipe((Food) getTableRow().getItem()));
        hBox.getChildren().add(addButton);
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