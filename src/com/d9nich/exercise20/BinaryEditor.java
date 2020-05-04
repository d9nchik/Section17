package com.d9nich.exercise20;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

import static com.d9nich.exercise18.GetBytes.getBits;

public class BinaryEditor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static void setTextArea(TextField textField, TextArea textArea) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(textField.getText()))) {
            StringBuilder text = new StringBuilder();
            int v;
            while ((v = inputStream.read()) != -1)
                text.append(getBits(v));
            textArea.setText(text.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream error");
        }
    }

    private static void saveText(TextField textField, TextArea textArea) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(textField.getText()))) {
            String text = textArea.getText();
            for (int i = 0; i < text.length(); i += 8)
                outputStream.write(eightBitToInt(text.substring(i, Math.min((i + 8), text.length()))));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Stream error");
        }
    }

    private static int eightBitToInt(String eightBit) {
        if (eightBit.length() != 8)
            System.out.println("Not 8");
        int byteValue = 0;
        for (int i = 0; i < eightBit.length(); i++) {
            byteValue = byteValue * 2;
            if (eightBit.charAt(i) == '1')
                byteValue++;
        }
        return byteValue;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        TextField textField = new TextField();
        textField.setPrefColumnCount(32);
        pane.setTop(new HBox(new Label("Enter a file: "), textField));

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        pane.setCenter(textArea);

        Button changeSave = new Button("Save the change");
        HBox hBox = new HBox(changeSave);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 20");
        primaryStage.show();

        textField.setOnAction(e -> setTextArea(textField, textArea));
        changeSave.setOnAction(e -> saveText(textField, textArea));
    }
}
