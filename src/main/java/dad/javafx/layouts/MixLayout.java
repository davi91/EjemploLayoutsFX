package dad.javafx.layouts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MixLayout extends Application {

	final String fileName = "Lorem.txt";
	
	// Un TextArea para que ocupe todo el espacio
	private TextArea loremText; 
	private Button cargarBt, vaciarBt;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		loremText = new TextArea();
		loremText.setEditable(false);
		
		cargarBt = new Button("Cargar");
		cargarBt.setDefaultButton(true);
		cargarBt.setOnAction( e -> onLoadAction(e) );
		
		vaciarBt = new Button("Vaciar");
		vaciarBt.setOnAction( e -> onEmptyAction(e) );
		
		FlowPane flow = new FlowPane();
		flow.setAlignment(Pos.BOTTOM_RIGHT);
		flow.getChildren().addAll(cargarBt, vaciarBt);
		flow.setHgap(5);
		flow.setPadding(new Insets(5, 0, 0, 0));
		
		BorderPane border = new BorderPane();
		border.setCenter(loremText);
		border.setBottom(flow);
		border.setPadding(new Insets(10));
		
		Scene scene = new Scene(border, 600, 300);
		
		primaryStage.setTitle("Mix sample");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void onEmptyAction(ActionEvent e) {
		loremText.setText("");
	}

	private void onLoadAction(ActionEvent e) {
		
		FileReader file = null;
		BufferedReader buff = null;
		
		try {
			
			 file = new FileReader(fileName);
			 buff = new BufferedReader(file);
			
			 String str;
			 StringBuilder finalText = new StringBuilder();
			 while( (str = buff.readLine()) != null ) { // Lo leemos linea por linea  y lo volcamos en el TextArea
				 finalText.append(str + "\n"); // Cuidado con los saltos de linea, no te los lee
			 }
			 
			 loremText.setText(finalText.toString());

		} catch (FileNotFoundException e1) {
		} catch (IOException e1) {
			System.err.println("Error al cargar o leer el fichero " + fileName);
		} finally {
			
			try {
				if( buff != null ) {
					buff.close();
				}
				
				if( file != null ) {
					file.close();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}
