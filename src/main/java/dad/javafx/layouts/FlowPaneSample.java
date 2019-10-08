package dad.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane root = new FlowPane();
		root.setAlignment(Pos.BOTTOM_RIGHT);
		root.setHgap(5);
		root.setVgap(5);
		root.setPadding(new Insets(5));
		
		for( int i = 0; i < 50; i++ ) {
			Button bt = new Button("Boton" + i);
			bt.setPrefWidth(120);
			root.getChildren().add(bt);
		}
		
		Scene scene = new Scene(root, 512, 512);

		primaryStage.setTitle("Flow sample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
