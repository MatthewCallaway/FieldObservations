package com.mycompany.mccxb6gradecalculator;

import java.text.DecimalFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainApp extends Application {

    
    public String title = "Grade Calculator";
    public int width = 500;
    public int height = 400;
    
        
    public String fontStyle = "Times New Roman";
        
    @Override
    public void start(Stage stage) throws Exception {
       
        DecimalFormat df = new DecimalFormat("#.00"); 
        
        String fontStyle = "Times New Roman";
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); 
        
        root.setHgap(15); 
        root.setVgap(15); 
        root.setPadding(new Insets(0,0,15,0));
        VBox vboxForButton = new VBox(15); 
        Double buttonWidth = Double.MAX_VALUE;
        
            // Category 1
        
        Label categoryOneLabel = new Label("Category 1 (30%):");
        categoryOneLabel.setFont(Font.font(fontStyle, FontWeight.NORMAL, 14));
        categoryOneLabel.setPadding(new Insets(10, 0, 0, 15));
        root.add(categoryOneLabel, 0, 0);
        
        TextField score1 = new TextField(); 
        root.add(score1, 0, 1);
        score1.setPrefWidth(400);
            // Category 2
        
        Label categoryTwoLabel = new Label("Category 2 (70%):");
        categoryTwoLabel.setFont(Font.font(fontStyle, FontWeight.NORMAL, 14));
        categoryTwoLabel.setPadding(new Insets(10, 0, 0, 15));
        root.add(categoryTwoLabel, 0, 2);
        
        TextField score2 = new TextField();
        root.add(score2, 0, 3);
        score2.setPrefWidth(400);
        
            // Final Score
            
        Label finalLabel = new Label("My Final Score:");
        finalLabel.setFont(Font.font(fontStyle, FontWeight.NORMAL, 14));
        finalLabel.setPadding(new Insets(10, 0, 0, 15));
        root.add(finalLabel, 0, 4);
        
        TextField score3 = new TextField(); 
        root.add(score3, 0, 5);
        score3.setPrefWidth(400);
        
        
            // Maximize Button
        
        Button maxButton = new Button("Maximize");
        vboxForButton.getChildren().add(maxButton); 
        maxButton.setMaxWidth(buttonWidth);
        root.add(maxButton, 0, 6); 
        
         
        Text maxActionTarget = new Text();
        GridPane.setColumnIndex(maxActionTarget, 1); 
        GridPane.setRowIndex(maxActionTarget, 6); 
        root.getChildren().add(maxActionTarget); 
        
        maxButton.setOnAction((ActionEvent event) -> {
            score1.setText("100");
            score2.setText("100");
            
        });
         
            // Calculate Button
        
        Button calculateButton = new Button("Calculate");
        vboxForButton.getChildren().add(calculateButton);  
        calculateButton.setMaxWidth(buttonWidth);
        root.add(calculateButton, 0, 7); 
        
        
        calculateButton.setOnAction((ActionEvent event2) -> {
            double score1Double = Double.parseDouble(score1.getText()); 
            double score2Double = Double.parseDouble(score2.getText());
            double score3Double = score1Double * .3 + score2Double * .7;
         
            score3.setText("My final score should be " + score1Double + " * 0.3" + " + "+ score2Double + " * 0.7 = " + String.valueOf(df.format(score3Double)));
            
        });
        
            // Clear Button
       
        Button clearButton = new Button("Clear");
        vboxForButton.getChildren().add(clearButton);  
        clearButton.setMaxWidth(buttonWidth);
        root.add(clearButton, 0, 8); 
        
        clearButton.setOnAction((ActionEvent event3) -> {
            score1.setText("");
            score2.setText("");
            score3.setText("");
            
        });
        
            // Alert Button
        
        Button alertButton = new Button("Alert");
        vboxForButton.getChildren().add(alertButton);  
        alertButton.setMaxWidth(buttonWidth);
        root.add(alertButton, 0, 9); 
        
        alertButton.setOnAction((ActionEvent event4) -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText(score3.getText());

            alert.showAndWait();    
            
        });
        
        Scene scene = new Scene(root, width, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}