package com.bertilware.vault.controllers;

import com.bertilware.vault.VaultCommonHandlers;
import com.bertilware.vault.VaultManager;
import com.bertilware.vault.VaultDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AboutDialogController {
    @FXML
    private VBox rootVBox;
    @FXML
    private HBox titleHBox;
    @FXML
    private Button minimizeButton;
    @FXML
    private Button exitButton;
    @FXML
    private Hyperlink homepageLink;
    @FXML
    private Button okButton;

    public void initialize() {
        rootVBox.setStyle(VaultManager.getTheme());

        // Make the window movable.
        titleHBox.setOnMousePressed(VaultCommonHandlers.grabWindow());
        titleHBox.setOnMouseDragged(VaultCommonHandlers.moveWindow());

        // Make the two title bar buttons work.
        minimizeButton.setOnAction(actionEvent -> getStage().setIconified(true));
        exitButton.setOnAction(actionEvent -> getStage().close());

        // Copy the homepage link to the clipboard when clicked.
        homepageLink.setOnAction(actionEvent -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString("https://bertilware.com");
            clipboard.setContent(content);
            VaultDialog.createOkDialog("Link copied to clipboard.");
        });

        okButton.setOnAction(actionEvent -> getStage().close());
    }

    private Stage getStage() {
        return (Stage) titleHBox.getScene().getWindow();
    }
}
