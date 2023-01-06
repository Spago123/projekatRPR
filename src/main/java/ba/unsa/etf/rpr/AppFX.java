package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class AppFX extends Application {

    static Map<String, String> pageNames = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResource("application.properties.pageTitles").openStream());
        pageNames.put("loginPage", p.getProperty("loginPage"));
        pageNames.put("patientHome", p.getProperty("patientHome"));
        pageNames.put("doctorHome", p.getProperty("doctorHome"));
        pageNames.put("editPatient", p.getProperty("editPatient"));
        pageNames.put("addDiagnosis", p.getProperty("addDiagnosis"));
        pageNames.put("viewHistory", p.getProperty("viewHistory"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/patientHome.fxml"));
        //HomeController homeController = new HomeController();
        //fxmlLoader.setController(homeController);
        Parent root = fxmlLoader.load();
        Stage stage = null;
        primaryStage.setTitle("Quote-maker");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static String getPageTitle(String key){
        return pageNames.get(key);
    }
}
