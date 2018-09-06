package launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import model.DieteticBrotherModel;
import view.DieteticBrotherView;

public class DieteticBrotherMain extends Application {

    public DieteticBrotherMain() {
        super();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DieteticBrotherModel model = new DieteticBrotherModel();
        new DieteticBrotherView(model);
    }

}