package dad;

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{
	
	private Label introduceNumero;
	private TextField numero;
	private Button comprobar;
	Random rd = new Random();
	
    int numeroAleatorio = rd.nextInt(100)+1;
    int contador = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		//etiqueta
		introduceNumero = new Label("Introduce un número del 1 al 100:");
		
		//textField
		numero = new TextField();
		numero.setPromptText("Jaja");
		
		//boton
		comprobar = new Button("Comprobar");
		comprobar.setDefaultButton(true);
		comprobar.setOnAction(e -> clickComprobar(e));
		
		
		//panel
		VBox rootPanel = new VBox();
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.setSpacing(10);
		rootPanel.setFillWidth(false);
		rootPanel.getChildren().addAll(introduceNumero, numero, comprobar);
		
		Scene scene = new Scene(rootPanel, 320, 200);
		 
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();	
		
	}
	
	private void clickComprobar(ActionEvent e) {
		
		
		switch (adivinarNumero()) {
		case 1:
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setTitle("Error Dialog");
			alert3.setHeaderText("Error");
			alert3.setContentText("El número debe estar entre 1 y 100");
			alert3.showAndWait();
			break;
			
		case 2:
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Enhorabuena.");
			alert.showAndWait();
			break;
		case 3:
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setTitle("Warning Dialog");
			alert2.setHeaderText("¡Has fallado!");
			if (recogerNumero() < numeroAleatorio) {
				alert2.setContentText("El número que has introducido es menor.");
			} else {
				alert2.setContentText("El número que has introducido es mayor.");
			}
				alert2.showAndWait();
			}
		}
		
	
	private int adivinarNumero () {
		int error;
		if (recogerNumero()<1 || recogerNumero()>100) {
			error = 1;
		} else if (numeroAleatorio==recogerNumero()) {
			error = 2;
		} else {
			error = 3;
		}
		return error;
	}
	
	private int recogerNumero () {
		int dato = Integer.parseInt(numero.getText());
		return dato;	
	}
	
	
	public static void main (String[] args) {
		 launch(args);

	}
	
}
