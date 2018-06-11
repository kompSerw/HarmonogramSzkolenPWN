package controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import daoMySQL.DaoToMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LogowanieController {

    private Stage stageLogowanie;

    @FXML
    private TextField fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;

    @FXML
    private Button fxButZaloguj;

    @FXML
    private Pane fxPaneLog;

    @FXML
    void onButZaloguj(ActionEvent event) throws SQLException {
        DaoToMySQL dao = new DaoToMySQL();
            PreparedStatement st = dao.getCon().prepareStatement("select inicjaly,haslo from Trenerzy where inicjaly = ?");
            st.setString(1,fxTxtLogowanie.getText().toUpperCase());
            st.execute();
            ResultSet rs = st.getResultSet();
            if(rs.next()) {
                if (rs.getString("haslo").equals(fxTxtHaslo.getText())){
                    StageController sc = new StageController("menuGlowne", "Menu główne");
                    sc.getListaStage().get("logowanie").close();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Błedny login lub hasło, czy chcesz zalogować się ponownie ?");
                    alert.setTitle("Bład logowania");
                    alert.showAndWait();
                };
            }
    }
    }

