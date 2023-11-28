import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Helloworld extends Application {

    private static final int CAMERA_MOVE_DISTANCE = 5;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        Scene mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        Label titleLabel = new Label("Runner Desert");
        Button buttonStart = new Button("Start");
        buttonStart.setOnAction(e -> openGame(primaryStage));

        Button buttonAide = new Button("Aide");
        buttonAide.setOnAction(e -> openHelp(primaryStage));

        Button buttonCredit = new Button("Crédit");
        buttonCredit.setOnAction(e -> openCredit(primaryStage));

        root.getChildren().addAll(titleLabel, buttonStart, buttonAide, buttonCredit);

        primaryStage.setTitle("Menu Principal");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void openGame(Stage primaryStage) {
        StackPane gameRoot = new StackPane();
        Scene gameScene = new Scene(gameRoot, WINDOW_WIDTH, WINDOW_HEIGHT);

        Label gameLabel = new Label("Contenu du jeu ici");
        Rectangle player = new Rectangle(70, 70);
        Image hero=new Image("course.png");
        var imagePattern = new ImagePattern(hero);
        player.setFill(imagePattern);




        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();






        ImageView imageView = new ImageView(hero);
        gameRoot.getChildren().addAll(gameLabel, player);

        Button Close = new Button("cancel button");
        Close.setCancelButton(true);



        Image img=new Image("Desert.png");
        gameRoot.getChildren().add(new ImageView(img));

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handleKeyPressed(event, player);
            }
        });

        primaryStage.setScene(gameScene);
        ImageView background = new ImageView(img);
        ImageView background2 = new ImageView(img);
        gameRoot.getChildren().addAll(background, background2);


        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(7), background);
        trans1.setFromX(0);
        trans1.setToX(-800);
        trans1.setInterpolator(Interpolator.LINEAR);
        trans1.setCycleCount(Animation.INDEFINITE);
        TranslateTransition trans2 = new TranslateTransition(Duration.seconds(7), background2);
        trans2.setFromX(800);
        trans2.setToX(0);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.setInterpolator(Interpolator.LINEAR);
        ParallelTransition parTrans = new ParallelTransition(trans1, trans2);
        parTrans.play();


        ImageView hero1 = new ImageView(hero);
        ImageView hero2 = new ImageView(hero);
        ImageView hero3 = new ImageView(hero);
        ImageView hero4 = new ImageView(hero);
        ImageView hero5 = new ImageView(hero);



    }

    private void handleKeyPressed(KeyEvent keyEvent, Rectangle player) {
        switch (keyEvent.getCode()) {
            case UP:
                player.setTranslateY(player.getTranslateY() - CAMERA_MOVE_DISTANCE);
                break;
            case DOWN:
                player.setTranslateY(player.getTranslateY() + CAMERA_MOVE_DISTANCE);
                break;
            case LEFT:
                player.setTranslateX(player.getTranslateX() - CAMERA_MOVE_DISTANCE);
                break;
            case RIGHT:
                player.setTranslateX(player.getTranslateX() + CAMERA_MOVE_DISTANCE);
                break;
        }
    }

    private void openHelp(Stage primaryStage) {
        StackPane helpRoot = new StackPane();
        Scene helpScene = new Scene(helpRoot, WINDOW_WIDTH, WINDOW_HEIGHT);

        Label helpLabel = new Label("Aide pour jouer au jeu");
        helpRoot.getChildren().add(helpLabel);

        primaryStage.setScene(helpScene);
    }

    private void openCredit(Stage primaryStage) {
        StackPane creditRoot = new StackPane();
        Scene creditScene = new Scene(creditRoot, WINDOW_WIDTH, WINDOW_HEIGHT);

        Label creditLabel = new Label("Ce jeu à été développé par Manuel GABON de l'ENSEA");
        creditRoot.getChildren().add(creditLabel);

        primaryStage.setScene(creditScene);



    }

    public static void main(String[] args) {
        launch(args);
    }
}
