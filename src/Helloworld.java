
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


public class Helloworld extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Scene scene1 = new Scene(root, 600, 600);
        stage.setTitle("Menu Principal");
        stage.setScene(scene1);

        Label bonjour = new Label("Bonjour et bienvenu sur Super Mario");

        Button buttonStart = new Button("Start");
        buttonStart.setOnAction(e -> openGame());

        Button buttonAide = new Button("Aide");
        buttonAide.setOnAction(e -> openHelp());

        Button buttonCredit = new Button("Crédit");
        buttonCredit.setOnAction(e -> openCredit());



        root.getChildren().add(bonjour);
        root.getChildren().add(buttonStart);
        root.getChildren().add(buttonAide);
        root.getChildren().add(buttonCredit);

        stage.show();
    }

    private void openGame() {
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene2 = new Scene(gameRoot, 600, 600);
        gameStage.setTitle("Page de jeu");
        gameStage.setScene(scene2);

        Label gameLabel = new Label("Contenu du jeu ici");
        gameRoot.getChildren().add(gameLabel);

        gameStage.show();
    }

    private void openHelp() {
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene3 = new Scene(gameRoot, 600, 600);
        gameStage.setTitle("Aide");
        gameStage.setScene(scene3);

        Label HelpLabel = new Label("Aide pour jouer au jeu");
        gameRoot.getChildren().add(HelpLabel);

        gameStage.show();
    }



    private void openCredit() {
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene3 = new Scene(gameRoot, 600, 600);
        gameStage.setTitle("Crédit");
        gameStage.setScene(scene3);

        Label HelpLabel = new Label("Ce jeu à été développer par Manuel GABON de l'ENSEA");
        gameRoot.getChildren().add(HelpLabel);
        gameStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}