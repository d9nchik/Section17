package com.d9nich.exercise11;

import com.d9nich.exercise10.DivideOfHugeFile;
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

public class SplitFiles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        pane.setTop(new Text("If you split a file named temp.txt into 3 smaller files,\n" +
                "the three smaller files are temp.txt.1, temp.txt.2, temp.txt.3."));

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
        primaryStage.setTitle("Exercise 11");
        primaryStage.show();

        start.setOnAction(e -> {
            String[] output = {filePath.getText(), numberOfSmallerFiles.getText()};
            DivideOfHugeFile.main(output);
        });
    }
}
