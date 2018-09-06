package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import controller.RecipeController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DieteticBrotherModel;
import model.pojo.Food;
import model.pojo.Recipe;
import observer.Observer;

public class DieteticBrotherView extends Stage implements Observer {
    private Parent root;
    private Scene scene;
    private DieteticBrotherModel model;
    private URL fxmlURL;

    public DieteticBrotherView(DieteticBrotherModel model) {
        super();
        try {
            this.model = model;
            this.model.addObserver(this);

            this.setTitle("Dietetic Brother");
            this.setResizable(true);

            this.fxmlURL = getClass().getClassLoader().getResource("fxml/dietetic-brother.fxml");
            if (fxmlURL == null) {
                System.exit(0);
            }
            this.root = FXMLLoader.load(this.fxmlURL);

            this.scene = new Scene(this.root);
            this.setScene(this.scene);

            RecipeController controller = RecipeController.getInstance();
            controller.setModel(model);
            controller.setRoot(root);

            this.setOnCloseRequest(event -> System.exit(0));
            this.show();

            this.initializeView();
            this.model.updateAll();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void initializeView() {
        /* Champ de recherche */
        TextField searchTextField = (TextField) root.lookup("#searchTextField");
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> RecipeController.getInstance().searchTextFieldModified(newValue));

        /* Table des aliments disponibles */
        TableView<Food> availableFoodTableview = (TableView<Food>) root.lookup("#availableFoodTableview");

        TableColumn<Food, String> availableFoodNameColumn = new TableColumn<>("Aliment");
        availableFoodNameColumn.setMinWidth(100);
        availableFoodNameColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        availableFoodNameColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Boolean> availableFoodAddColumn = new TableColumn<>("Ajouter");
        availableFoodAddColumn.setSortable(false);
        availableFoodAddColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));
        availableFoodAddColumn.setCellFactory(food -> new AddButtonCell());

        availableFoodTableview.getColumns().setAll(availableFoodNameColumn, availableFoodAddColumn);

        /* Table de la recette */
        TableView<Food> myRecipeTableview = (TableView<Food>) root.lookup("#myRecipeTableview");

        TableColumn<Food, String> myRecipeFoodNameColumn = new TableColumn<>("Aliment");
        myRecipeFoodNameColumn.setMinWidth(150);
        myRecipeFoodNameColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        myRecipeFoodNameColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Double> myRecipeProteineColumn = new TableColumn<>("Protéine");
        myRecipeProteineColumn.setCellValueFactory(new PropertyValueFactory<>("proteineAmount"));
        myRecipeProteineColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Double> myRecipeGlucideColumn = new TableColumn<>("Glucide");
        myRecipeGlucideColumn.setCellValueFactory(new PropertyValueFactory<>("glucideAmount"));
        myRecipeGlucideColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Double> myRecipeLipideColumn = new TableColumn<>("Lipide");
        myRecipeLipideColumn.setCellValueFactory(new PropertyValueFactory<>("lipideAmount"));
        myRecipeLipideColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Boolean> myRecipeQuantityColumn = new TableColumn<>("Quantité");
        myRecipeQuantityColumn.setMinWidth(150);
        myRecipeQuantityColumn.setSortable(false);
        myRecipeQuantityColumn.setCellValueFactory(food -> new SimpleBooleanProperty(food.getValue() != null));
        myRecipeQuantityColumn.setCellFactory(food -> new QuantityCell(model, myRecipeTableview));

        TableColumn<Food, Boolean> myRecipeDeleteFoodColumn = new TableColumn<>("Supprimer");
        myRecipeQuantityColumn.setMinWidth(100);
        myRecipeDeleteFoodColumn.setSortable(false);
        myRecipeDeleteFoodColumn.setCellValueFactory(food -> new SimpleBooleanProperty(food.getValue() != null));
        myRecipeDeleteFoodColumn.setCellFactory(food -> new DeleteButtonCell());

        myRecipeTableview.getColumns().setAll(myRecipeFoodNameColumn,
                myRecipeProteineColumn,
                myRecipeGlucideColumn,
                myRecipeLipideColumn,
                myRecipeQuantityColumn,
                myRecipeDeleteFoodColumn);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updateFoodList(List<Food> foodList) {
        TableView<Food> availableFoodTableview = (TableView<Food>) root.lookup("#availableFoodTableview");
        availableFoodTableview.setItems(FXCollections.observableArrayList(foodList));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void updateRecipe(Recipe recipe) {
        TableView<Food> myRecipeTableview = (TableView<Food>) root.lookup("#myRecipeTableview");
        myRecipeTableview.setItems(FXCollections.observableArrayList(recipe.getFoodMap().keySet()));
        myRecipeTableview.refresh();
    }

}
