module com.gi2.cobas6000fx {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires java.sql;

    opens com.gi2.cobas6000fx to javafx.fxml;
    exports com.gi2.cobas6000fx;
}
