package udea.edu.co.logica;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import udea.edu.co.logica.modelo.PrincipalController;


public class Main extends Application {
	
	private Stage escenarioPrincipal;
	private BorderPane contenedorPrincipal;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		this.escenarioPrincipal = primaryStage;
		primaryStage.initStyle( StageStyle.UNDECORATED );//ventana sin bordes
		inicializarRaiz();
		cargarEscenaPrincipal();
		
		
	}
	
	public void inicializarRaiz(){ // cargar el root donde ira contenido todo.
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vistas/Root.fxml"));
			contenedorPrincipal = (BorderPane) loader.load();
			
			PrincipalController controladorPrincipal = loader.getController();
			controladorPrincipal.setPrincipal(this);
			
			// Cargar la escena y mostrarla
			Scene scena = new Scene(contenedorPrincipal);
			escenarioPrincipal.setScene(scena);
			escenarioPrincipal.show();
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	// Cargar la escena principal.
	public void cargarEscenaPrincipal(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("vistas/Presentacion.fxml"));
			AnchorPane presentacion = (AnchorPane) loader.load();
			
			PrincipalController controlador = loader.getController();
			controlador.setPrincipal(this);
			
			contenedorPrincipal.setCenter(presentacion);
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
