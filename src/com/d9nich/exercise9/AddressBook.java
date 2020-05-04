package com.d9nich.exercise9;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressBook extends Application {

    private final TextField name = new TextField();
    private final TextField street = new TextField();
    private final TextField city = new TextField();
    private final TextField state = new TextField();
    private final TextField zip = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setSpacing(10);

        name.setPrefColumnCount(32);
        pane.getChildren().add(new HBox(new Label("Name "), name));

        street.setPrefColumnCount(32);
        pane.getChildren().add(new HBox(new Label("Street "), street));

        city.setPrefColumnCount(20);
        state.setPrefColumnCount(2);
        zip.setPrefColumnCount(5);
        pane.getChildren().add(new HBox(new Label("City\t"), city, new Label("State "), state,
                new Label("ZIP"), zip));

        Button add = new Button("Add");
        Button first = new Button("First");
        Button next = new Button("Next");
        Button previous = new Button("Previous");
        Button last = new Button("Last");
        Button update = new Button("Update");
        HBox buttons = new HBox(add, first, next, previous, last, update);
        buttons.setSpacing(5);
        buttons.setAlignment(Pos.CENTER);
        pane.getChildren().add(buttons);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 9");
        primaryStage.show();

        AddressBookFileWork addressBookFileWork = new AddressBookFileWork();
        setFields(addressBookFileWork.next());
        add.setOnAction(e -> addressBookFileWork.add(getContactOfPerson()));
        first.setOnAction(e -> setFields(addressBookFileWork.first()));
        next.setOnAction(e -> setFields(addressBookFileWork.next()));
        previous.setOnAction(e -> setFields(addressBookFileWork.previous()));
        last.setOnAction(e -> setFields(addressBookFileWork.last()));
        update.setOnAction(e -> addressBookFileWork.update(getContactOfPerson()));
    }

    private ContactOfPerson getContactOfPerson() {
        return new ContactOfPerson(name.getText(),
                street.getText(), city.getText(), state.getText(), zip.getText());
    }

    private void setFields(ContactOfPerson contactOfPerson) {
        name.setText(contactOfPerson.getName());
        street.setText(contactOfPerson.getStreet());
        city.setText(contactOfPerson.getCity());
        state.setText(contactOfPerson.getState());
        zip.setText(contactOfPerson.getZip());
    }
}
