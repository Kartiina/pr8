package com.example.pr_8;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;

import java.time.LocalDate;

public class HelloController {
    @FXML
    private TableView<Pet> petsTable;
    @FXML
    private TableColumn<Pet, String> NameColumn;
    @FXML
    private TableColumn<Pet, String> TypeColumn;

    @FXML
    private TableColumn<Pet, String> DateOfVaccination;
    @FXML
    private TableColumn<Pet, String> TypeV;
    @FXML
    private TableColumn<Pet, String> NameV;

    @FXML
    private Label NameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label BirthDateLabel;



    private MainApp mainApp;
    public HelloController() {
    }

    @FXML
    private void initialize() {
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        showPetsDetails(null);
        petsTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPetsDetails(newValue));

        DateOfVaccination.setCellValueFactory(cellData -> cellData.getValue().vaccines.stream().forEach(x -> x.dateProperty());
        TypeV.setCellValueFactory(cellData -> cellData.getValue().vaccines.add());
        NameV.setCellValueFactory(cellData -> cellData.getValue().namevProperty());

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Добавление в таблицу данных из наблюдаемого списка
        petsTable.setItems(mainApp.getPetsData());

    }
    private void showPetsDetails(Pet pet){
        if (pet != null){
            NameLabel.setText(pet.getName());
            ageLabel.setText(Integer.toString(pet.getAge()));
            BirthDateLabel.setText(pet.getBhday().toString());
        } else {
            NameLabel.setText("");
            ageLabel.setText("");
            BirthDateLabel.setText("");
        }
    }
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
//
//    @FXML
//    protected void buttonClicked() {
//        Button button = new Button();
//        System.out.println("Hello LOX");
//    }

//    @FXML
//    protected void setOnAction() {
////        ObservableList<Pet> listOfPets = FXCollections.observableArrayList();
////        for (int i = 0; i < 5; i++){
////            listOfPets.add(new Pet());
////        }
//        ComboBox<Pet> petsComboBox = new ComboBox<Pet>();
//        ObservableList<Pet> ListOfPets = PetDAO.getPetList();
//        petsComboBox.setItems(ListOfPets);
//        petsComboBox.getSelectionModel().select(1);
//        FlowPane root = new FlowPane(30, 30, petsComboBox);
//        root.getChildren().add(new Label("Choose your fighter!"));
//        root.getChildren().add(petsComboBox);
//
//    }
}

//выборка
//http://java-online.ru/swing-jlist.xhtml