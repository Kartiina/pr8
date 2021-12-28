module com.example.pr_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pr_8 to javafx.fxml;
    exports com.example.pr_8;
}