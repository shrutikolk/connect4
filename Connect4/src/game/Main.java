/**
 * Class name: Main
 * @version 1.8.0_221
 * @author ShrutiSinha 
 * @date 20 Sept 2019
 * 
 * Description:
 * Connect Four is a two-player connection game in which the players first
 * choose a color and then take turns dropping colored discs from the top into 
 * a seven-column, six-row vertically suspended grid. The pieces fall straight 
 * down, occupying the next available space within the column. The objective of
 * the game is to be the first to form a horizontal, vertical, or diagonal line
 * of four of one's own discs. Connect Four is a solved game. The first player 
 * can always win by playing the right moves.
 * 
 **/

package game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show(); 
    }
	
    private MenuBar createMenu() {
        Menu fileMenu = new Menu ("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> controller.resetGame());
	    
        MenuItem resetMenuItem = new MenuItem("Reset");
        resetMenuItem.setOnAction(event -> controller.resetGame());
	    
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem exitMenuItem = new MenuItem("Exit");
	    
        exitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
	    
        fileMenu.getItems().addAll(newMenuItem,resetMenuItem,separator,exitMenuItem);
	    
        Menu helpMenu = new Menu ("Help");
        MenuItem aboutMenuItem = new MenuItem("About App");	    
        aboutMenuItem.setOnAction(event -> aboutApp());
	    
        new SeparatorMenuItem();
	    
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> about());
	    
        helpMenu.getItems().addAll(aboutMenuItem,aboutMe);
	    
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
	    
        return menuBar;
    }
	
    private void aboutApp() {
        Alert alertbox = new Alert(Alert.AlertType.INFORMATION);
        alertbox.setTitle("About the App");
        alertbox.setHeaderText("Connect4");
        alertbox.setContentText("Connect Four is a two-player connection game in which the players first "
        + "choose a color and then take turns dropping colored discs from the top into a "+
        "seven-column, six-row vertically suspended grid. The pieces fall straight down, "
        +"occupying the next available space within the column. The objective of the game is"+
        " to be the first to form a horizontal, vertical, or diagonal line of four of one's"
        +" own discs. Connect Four is a solved game. The first player can always win by "
        +"playing the right moves.");
        alertbox.show();
    }

    private void about() {
    	Alert alertbox = new Alert(Alert.AlertType.INFORMATION);
    	alertbox.setTitle("About the Developer");
    	alertbox.setHeaderText("Shruti Sinha");
    	alertbox.setContentText("I am Shruit sinha and this is my first JavaFX based Game.");
    	alertbox.show();
    }
	
    public void stop() throws Exception {
        super.stop();
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}
