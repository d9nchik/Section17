package com.d9nich.exercise13;

import com.d9nich.exercise12.CombinerOfFile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JoinFiles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        pane.setTop(new Text("If the base file is named temp.txt with three pieces,\n" +
                "temp.txt.1, temp.txt.2 and temp.txt.3 are combined into temp.txt."));

        GridPane field = new GridPane();
        field.setPadding(new Insets(10, 10, 10, 10));
        pane.setCenter(field);
        field.setVgap(10);
        field.setHgap(5);
        field.setAlignment(Pos.CENTER_LEFT);
        field.add(new Text("Enter a file: "), 0, 0);
        TextField filePath = new TextField();
        field.add(filePath, 1, 0);
        field.add(new Text("Specify the number of smaller files"), 0, 1);
        TextField numberOfSmallerFiles = new TextField();
        field.add(numberOfSmallerFiles, 1, 1);

        Button start = new Button("Start");
        HBox button = new HBox(start);
        button.setAlignment(Pos.CENTER);
        pane.setBottom(button);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 13");
        primaryStage.show();

        start.setOnAction(e -> {
            int numberOfFiles = Integer.parseInt(numberOfSmallerFiles.getText());
            String[] output = new String[numberOfFiles + 1];
            for (int i = 0; i < numberOfFiles; i++)
                output[i] = filePath.getText() + "." + (i + 1);
            output[numberOfFiles] = filePath.getText();
            CombinerOfFile.main(output);
        });
    }
}
