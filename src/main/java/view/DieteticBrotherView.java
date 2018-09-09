package view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import controller.RecipeController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.DieteticBrotherModel;
import model.pojo.Food;
import model.pojo.Recipe;
import observer.Observer;
import utils.Utils;
import view.cell.AddButtonCell;
import view.cell.DeleteButtonCell;
import view.cell.QuantityCell;

public class DieteticBrotherView extends Stage implements Observer {

    private Parent root;
    private Scene scene;
    private DieteticBrotherModel model;
    private URL fxmlURL;
    private static final int PROTEINE_TO_CAL = 4;
    private static final int GLUCIDE_TO_CAL = 4;
    private static final int LIPIDE_TO_CAL = 9;

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
        searchTextField.textProperty()
                .addListener((observable, oldValue, newValue) -> RecipeController.getInstance().searchTextFieldModified(newValue));

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
        myRecipeFoodNameColumn.setMinWidth(100);
        myRecipeFoodNameColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        myRecipeFoodNameColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        TableColumn<Food, Double> myRecipeProteineColumn = new TableColumn<>("Protéine");
        myRecipeProteineColumn.setCellValueFactory(new PropertyValueFactory<>("proteineAmount"));
        myRecipeProteineColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Food, Double> myRecipeGlucideColumn = new TableColumn<>("Glucide");
        myRecipeGlucideColumn.setCellValueFactory(new PropertyValueFactory<>("glucideAmount"));
        myRecipeGlucideColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Food, Double> myRecipeLipideColumn = new TableColumn<>("Lipide");
        myRecipeLipideColumn.setCellValueFactory(new PropertyValueFactory<>("lipideAmount"));
        myRecipeLipideColumn.setStyle("-fx-alignment: CENTER;");

        TableColumn<Food, Boolean> myRecipeQuantityColumn = new TableColumn<>("Quantité");
        myRecipeQuantityColumn.setMinWidth(200);
        myRecipeQuantityColumn.setSortable(false);
        myRecipeQuantityColumn.setCellValueFactory(food -> new SimpleBooleanProperty(food.getValue() != null));
        myRecipeQuantityColumn.setCellFactory(food -> new QuantityCell(model));

        TableColumn<Food, Boolean> myRecipeDeleteFoodColumn = new TableColumn<>("Supprimer");
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
        Map<Food, Integer> foodMap = recipe.getFoodMap();

        TableView<Food> myRecipeTableview = (TableView<Food>) root.lookup("#myRecipeTableview");
        myRecipeTableview.setItems(FXCollections.observableArrayList(foodMap.keySet()));
        myRecipeTableview.refresh();

        Double proteineTotal = 0.0;
        Double glucideTotal = 0.0;
        Double lipideTotal = 0.0;
        for (Map.Entry<Food, Integer> food : foodMap.entrySet()) {
            proteineTotal += food.getKey().getProteineAmount();
            glucideTotal += food.getKey().getGlucideAmount();
            lipideTotal += food.getKey().getLipideAmount();
        }

        Integer percentProteine = 0;
        Integer percentGlucide = 0;
        Integer percentLipide = 0;
        
        double proteinesKcal = Utils.round(proteineTotal * PROTEINE_TO_CAL, 3);
        double glucidesKcal = Utils.round(glucideTotal * GLUCIDE_TO_CAL, 3);
        double lipidesKcal = Utils.round(lipideTotal * LIPIDE_TO_CAL, 3);
        
        double totalKcal = proteinesKcal + glucidesKcal + lipidesKcal;
        
        if (totalKcal > 0) {
            percentProteine = new Double(Utils.round(proteinesKcal / totalKcal * 100, 0)).intValue();
            percentGlucide = new Double(Utils.round(lipidesKcal / totalKcal * 100, 0)).intValue();
            percentLipide = new Double(Utils.round(lipidesKcal / totalKcal * 100, 0)).intValue();
        }

        Label totalProteinesLabel = (Label) root.lookup("#totalProteinesLabel");
        totalProteinesLabel.setTextAlignment(TextAlignment.CENTER);
        totalProteinesLabel.setText("Protéines\n" + Utils.round(proteineTotal, 1) + "g\n" + proteinesKcal + "kcal\n" + percentProteine + "%");
        Label totalGlucidesLabel = (Label) root.lookup("#totalGlucidesLabel");
        totalGlucidesLabel.setTextAlignment(TextAlignment.CENTER);
        totalGlucidesLabel.setText("Glucides\n" + Utils.round(glucideTotal, 1) + "g\n" + glucidesKcal + "kcal\n" + percentGlucide + "%");
        Label totalLipidesLabel = (Label) root.lookup("#totalLipidesLabel");
        totalLipidesLabel.setTextAlignment(TextAlignment.CENTER);
        totalLipidesLabel.setText("Lipides\n" + Utils.round(lipideTotal, 1) + "g\n" + lipidesKcal + "kcal\n" + percentLipide + "%");
        Label totalKcalLabel = (Label) root.lookup("#totalKcalLabel");
        totalKcalLabel.setTextAlignment(TextAlignment.CENTER);
        totalKcalLabel.setText("Total\n" + Utils.round(proteinesKcal + glucidesKcal + lipidesKcal, 1) + "kcal\n");
    }

}
