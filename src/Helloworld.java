
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Rectangle2D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.Objects;


public class Helloworld extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        Image img=new Image("Desert.png");
        root.getChildren().add(new ImageView(img));
        Scene scene1 = new Scene(root, 800, 600);
        stage.setTitle("Menu Principal");
        stage.setScene(scene1);

        Label bonjour = new Label("Runner Desert");

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

    public void openGame() {
        Image img1=new Image("desert.png");
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene2 = new Scene(gameRoot, 800, 400);
        gameStage.setTitle("Page de jeu");
        Button buttonBack = new Button("Start");
        gameStage.setScene(scene2);
        Label gameLabel = new Label("Contenu du jeu ici");
        gameRoot.getChildren().add(gameLabel);
        gameRoot.getChildren().add(new ImageView(img1));
        gameStage.show();
        Button CloseButton=new Button("Close");
        gameRoot.getChildren().add(CloseButton);
        CloseButton.setOnAction(e->openGame());

        Group cameraGroup = new Group();
        ImageView Hero = new ImageView(new Image("heros.png"));
        cameraGroup.getChildren().add(Hero);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> moveCamera()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        gameRoot.getChildren().add(cameraGroup);

        gameStage.setScene(scene2);
        gameStage.show();









    }









    private void openHelp() {
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene3 = new Scene(gameRoot, 800, 400);
        gameStage.setTitle("Aide");
        gameStage.setScene(scene3);

        Image img1=new Image("heros.png");
        gameRoot.getChildren().add(new ImageView(img1));

        Label HelpLabel = new Label("Aide pour jouer au jeu");
        gameRoot.getChildren().add(HelpLabel);
        gameStage.show();
    }






    private void openCredit() {
        Stage gameStage = new Stage();
        StackPane gameRoot = new StackPane();
        Scene scene3 = new Scene(gameRoot, 800, 400);
        gameStage.setTitle("Crédit");
        gameStage.setScene(scene3);

        Label HelpLabel = new Label("Ce jeu à été développer par Manuel GABON de l'ENSEA");
        gameRoot.getChildren().add(HelpLabel);
        gameStage.show();

    }
    private Group cameraGroup;
    Group root = new Group();
    Scene scene = new Scene(root, 800, 600);


    private void handleKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                cameraGroup.setTranslateY(cameraGroup.getTranslateY() - CAMERA_MOVE_DISTANCE);
                break;
            case DOWN:
                cameraGroup.setTranslateY(cameraGroup.getTranslateY() + CAMERA_MOVE_DISTANCE);
                break;
            case LEFT:
                cameraGroup.setTranslateX(cameraGroup.getTranslateX() - CAMERA_MOVE_DISTANCE);
                break;
            case RIGHT:
                cameraGroup.setTranslateX(cameraGroup.getTranslateX() + CAMERA_MOVE_DISTANCE);
                break;
        }
    }
    private void moveCamera() {
        cameraGroup.setTranslateX(cameraGroup.getTranslateX() - CAMERA_MOVE_DISTANCE);}
    private final int CAMERA_MOVE_DISTANCE = 5;

    public static void main(String[] args) {
        launch(args);
    }
}


