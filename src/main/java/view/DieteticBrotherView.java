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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final NullPointerException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void initializeView() {
        /* Champ de recherche */
        TextField searchTextField = (TextField) root.lookup("#searchTextField");
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            RecipeController.getInstance().searchTextFieldModified(newValue);
        });

        /* Table des aliments disponibles */
        TableView<Food> availableFoodTableview = (TableView<Food>) root.lookup("#availableFoodTableview");

        TableColumn<Food, String> availableFoodNameColumn = new TableColumn<>("Aliment");
        availableFoodNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("foodName"));

        TableColumn<Food, Boolean> availableFoodAddColumn = new TableColumn<>("Ajouter");
        availableFoodAddColumn.setSortable(false);
        availableFoodAddColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));
        availableFoodAddColumn.setCellFactory(food -> new AddButtonCell());

        availableFoodTableview.getColumns().setAll(availableFoodNameColumn, availableFoodAddColumn);

        /* Table de la recette */
        TableView<Food> myRecipeTableview = (TableView<Food>) root.lookup("#myRecipeTableview");

        TableColumn<Food, String> myRecipeFoodNameColumn = new TableColumn<>("Aliment");
        myRecipeFoodNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("foodName"));

        TableColumn<Food, String> myRecipeProteineColumn = new TableColumn<>("Protéine");
        myRecipeProteineColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("proteineAmount"));

        TableColumn<Food, String> myRecipeGlucideColumn = new TableColumn<>("Glucide");
        myRecipeGlucideColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("glucideAmount"));

        TableColumn<Food, String> myRecipeLipideColumn = new TableColumn<>("Lipide");
        myRecipeLipideColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("lipideAmount"));

        TableColumn<Food, Boolean> myRecipeQuantityColumn = new TableColumn<>("Quantité");
        myRecipeQuantityColumn.setSortable(false);
        myRecipeQuantityColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));
        myRecipeQuantityColumn.setCellFactory(food -> new QuantitySpinnerCell(model));

        TableColumn<Food, Boolean> myRecipeDeleteFoodColumn = new TableColumn<>("Supprimer");
        myRecipeDeleteFoodColumn.setSortable(false);
        myRecipeDeleteFoodColumn.setCellValueFactory(features -> new SimpleBooleanProperty(features.getValue() != null));
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
    }

}
