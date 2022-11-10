package com.example.project2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DriverController {
    @FXML
    private Label labelText;

    @FXML
    protected void onAddUser() {
//        labelText.setText("Adds user");
    }
    @FXML
    protected void onAddGroup()
    {

    }
    @FXML
    protected void onOpenUserView()
    {

    }
    @FXML
    protected void onShowUserTotal()
    {
        labelText.setText("Show user total");
    }
    @FXML
    protected void onShowGroupTotal()
    {
        labelText.setText("Show group total");
    }
    @FXML
    protected void onShowMessageTotal()
    {
        labelText.setText("Show message total");
    }
    @FXML
    protected void onShowPositivePercentage()
    {
        labelText.setText("Show positive percentage");
    }
}