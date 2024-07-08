module com.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.demo to javafx.fxml;
    exports com.demo;
    exports com.demo.Controllers;
    exports com.demo.Controllers.Alunos;
    exports com.demo.Controllers.Professores;
    exports com.demo.Models;
    exports com.demo.Views;
}