package view;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.DieteticBrotherModel;
import model.pojo.Food;

public class QuantitySpinnerCell extends TableCell<Food, Boolean> {

    private DieteticBrotherModel model;
    private final HBox hBox = new HBox();
    private Spinner<Integer> quantitySpinner;
    private SpinnerValueFactory<Integer> quantitySpinnerFactory;
    private final int tableIconImageSize = 16;

    public QuantitySpinnerCell(DieteticBrotherModel model) {
        this.model = model;

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        ImageView addImageView = new ImageView(new Image("icon/delete.png"));
        addImageView.setFitHeight(tableIconImageSize);
        addImageView.setFitWidth(tableIconImageSize);

        int initialValue = 0;
        int min = 0;
        int max = 1000000;
        int amountToStepBy = 5;
        quantitySpinnerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initialValue, amountToStepBy);
        quantitySpinner = new Spinner<>();
        quantitySpinner.setValueFactory(quantitySpinnerFactory);
        quantitySpinner.getEditor().textProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {
            String value = "";
            for (final Character character : newValue.toCharArray()) {
                if (Character.isDigit(character)) {
                    value += character;
                }
            }
            if (value.equals("") || Double.valueOf(value) < min || Double.valueOf(value) > max) {
                value = oldValue;
            }
            quantitySpinner.getEditor().setText(value);
            quantitySpinnerFactory.setValue(Integer.valueOf(value));
        });

        hBox.getChildren().add(quantitySpinner);
    }

    /**
     * Méthode ajoutant un bouton seulement si la ligne n'est pas vide.
     */
    @Override
    protected void updateItem(Boolean item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Food food = (Food) getTableRow().getItem();
            for (Food currentFood : model.getRecipe().getFoodMap().keySet()) {
                if (currentFood.getFoodId() == food.getFoodId()) {
                    quantitySpinner.getEditor().setText(Integer.toString(model.getRecipe().getFoodMap().get(currentFood)));
                    quantitySpinnerFactory.setValue(model.getRecipe().getFoodMap().get(currentFood));
                }
            }
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setGraphic(hBox);
        } else {
            setGraphic(null);
        }
    }

}