package dad.javafx.layouts;

import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GridPaneSample extends Application {

	private TextField nombreText, apellidosText, dniText;
	private DatePicker fechaNac;
	private Label edadLabel;
	private TextField[] ibanText;
	private RadioButton hombreRadio, mujerRadio;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// Este pane es perfecto para crear formularios
		
		nombreText = new TextField();
		nombreText.setPromptText("Nombre del alumno");
		
		apellidosText = new TextField();
		apellidosText.setPromptText("Apellidos del alumnno");
		
		dniText = new TextField();
		dniText.setPromptText("DNI del alumno");
		
		fechaNac = new DatePicker();
		fechaNac.setPromptText("Fecha de nacimiento");
		
		edadLabel = new Label("X años");

		ibanText = new TextField[6];
		for( int i = 0; i < ibanText.length; i++ ) {
			ibanText[i] = new TextField();
			ibanText[i].setPrefColumnCount(4);
		}
		
		hombreRadio = new RadioButton("Hombre");
		mujerRadio = new RadioButton("Mujer");
		
		// En un sistema de filas y columnas
		GridPane root = new GridPane();
		root.setHgap(5);
		root.setVgap(5);
		root.setPadding(new Insets(5));
		root.setGridLinesVisible(true); // DEBUG
		// Añadimos fila por file( o columna por columna )
		root.addRow(0, new Label("Nombre:"), nombreText); 
		root.addRow(1, new Label("Apellidos:"), apellidosText);
		root.addRow(2, new Label("DNI:"), dniText);
		root.addRow(3, new Label("Fecha nacimiento:"), fechaNac);
		root.addRow(4, new Label("IBAN:"), new HBox(5, ibanText));
		root.addRow(5, new Label("Sexo:"), new HBox(5, hombreRadio, mujerRadio));
		root.add(edadLabel, 2, 3);
		
		// Restricciones de las columnas -> Tenemos dos columnas
		ColumnConstraints[] cols = {
				new ColumnConstraints(),
				new ColumnConstraints()
		};
		
		cols[0].setHalignment(HPos.RIGHT); // Las etiquetas pegadas a la derecha
		cols[1].setHgrow(Priority.ALWAYS); // Se expanda lo máximo posible
		cols[1].setFillWidth(false); // Que no se estiren los componentes
		cols[1].setHalignment(HPos.LEFT);
		
		// Para componentes concretos
		GridPane.setFillWidth(nombreText, true); // Para que estos dos se estiren todo lo que pueden
		GridPane.setFillWidth(apellidosText, true);
		
		// Para que nombre y apellidos ocupen 2 columnas
		GridPane.setColumnSpan(nombreText, 2);
		GridPane.setColumnSpan(apellidosText, 2);
		
		// Para evitar que se seleccionen los dos botones, creamos un grupo
		ToggleGroup sexoGroup = new ToggleGroup();
		sexoGroup.getToggles().addAll(hombreRadio,mujerRadio);
		
		root.getColumnConstraints().setAll(cols);
		
		fechaNac.valueProperty().addListener( (o, ov, nv) -> {
			Integer edad = Period.between(nv, LocalDate.now()).getYears();
			edadLabel.setText(edad + " años");
		});
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Grid sample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
