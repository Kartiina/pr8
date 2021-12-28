package com.example.pr_8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {
    private Stage primaryStage;
//    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Meow!");

//        initRootLayout();

        showPetsOverview();
    }
//    public void initRootLayout() {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
//            rootLayout = (BorderPane) fxmlLoader.load();
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(scene);
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void showPetsOverview() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("hello.fxml"));
            AnchorPane petsOverview = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(petsOverview);
//            rootLayout.setCenter(petsOverview);
            HelloController controller = fxmlLoader.getController();
            controller.setMainApp(this);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ObservableList<Pet> petsData = FXCollections.observableArrayList();
    public Stage getPrimaryStage() {
        return primaryStage;
    }
//        HelloController controller = fxmlLoader.getController();
//        stage.setTitle("Meow!");
//        stage.setWidth(700);
//        stage.setHeight(610);
//        stage.getIcons().add(new Image("file:resources/images/fish.png"));
    //Label helloWorldLabel = new Label("Hello world!");
//        helloWorldLabel.setAlignment(Pos.CENTER);
//        stage.setScene(primaryScene);
//        stage.show();
    //static public List<Pet> pets = new ArrayList<>();
    public MainApp(){
        petsData.add(new Pet("Bonya", "Cat"));
        petsData.add(new Pet("Push'ok", "Cat"));
        petsData.add(new Pet("Archi", "Dog"));
    }
    public ObservableList<Pet> getPetsData() {
        return petsData;
    }


    public static void main(String[] args) {
        launch(args);
    }
}