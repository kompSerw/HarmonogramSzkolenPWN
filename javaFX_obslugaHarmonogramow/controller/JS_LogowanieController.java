package controller;


import daoMySQL.DaoToMySQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static controller.MenuGlowneController.pokazPrzyciski;
import static controller.MenuGlowneController.ukryjPrzyciski;

public class JS_LogowanieController {

    @FXML
    private TextArea fxTxtLogowanie;

    @FXML
    private PasswordField fxTxtHaslo;

    @FXML
    private Button fxButZaloguj;

    @FXML
    void onButZaloguj(ActionEvent event) throws SQLException {
        DaoToMySQL dao = new DaoToMySQL();
        PreparedStatement st = dao.getCon().prepareStatement("SELECT mentor FROM Trenerzy WHERE inicjaly = ? AND haslo = ?");
        st.setString(1,fxTxtLogowanie.getText());
        st.setString(2, fxTxtHaslo.getText());
        st.execute();
        ResultSet rs = st.getResultSet();
        if (rs.next()) {
            Stage s = (Stage)fxButZaloguj.getScene().getWindow();
            s.close();
            // Jeżeli Trenerzy.mentor == 1 oznacza trenera (bez uprawnień), to dodaj ukryj przyciski
            if (rs.getInt(1) == 1) {
                ukryjPrzyciski();
            } else {
                pokazPrzyciski();
            }
            StageController sc = new StageController("menuGlowne", "Menu główne");
        } else {
            System.out.println("Błędna para login/hasło");
        }
    }


}

