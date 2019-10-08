package dad.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BorderPanel extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane norte = new Pane();
		norte.setPrefHeight(25);
		norte.setStyle("-fx-background-color:red");
		
		Pane sur = new Pane();
		sur.setPrefHeight(25);
		sur.setStyle("-fx-background-color:orange");
		
		Pane este = new Pane();
		este.setPrefWidth(25);
		este.setStyle("-fx-background-color:blue");
		
		Pane oeste = new Pane();
		oeste.setPrefWidth(25);
		oeste.setStyle("-fx-background-color:cyan");
		
		Pane centro = new Pane();
		centro.setStyle("-fx-background-color:green");

		// Ejemplo de uso de border panel.
		
		BorderPane root = new BorderPane();
	//	root.setPadding(new Insets(5,20,0,47));
		
		root.setTop(norte);
		root.setBottom(sur);
		root.setLeft(oeste);
		root.setRight(este);
		root.setCenter(centro);
		
		BorderPane.setAlignment(oeste, Pos.CENTER);
		BorderPane.setAlignment(este, Pos.CENTER);
		BorderPane.setAlignment(norte, Pos.CENTER);
		BorderPane.setAlignment(sur, Pos.CENTER);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("Border sample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}

}
