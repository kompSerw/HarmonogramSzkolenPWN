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
            // Poprawka - trzeba w tym miejscu sprawdzić czy dany trener jest trenerem czy też powinien mieć wyższe uprawnienia (kolumna Trenerzy.mentor)
            // Jeżeli jest tylko trenerem to trzeba odpalić poniższą metodę statyczną:
            // MenuGlowneController.ukryjPrzyciski();
            // Jeżeli jest mentorem lub wklepywaczem to trzeba użyć poniższej metody statycznej:
            // MenuGlowneController.pokazPrzyciski();
            PreparedStatement st = dao.getCon().prepareStatement("select inicjaly,haslo from Trenerzy where inicjaly = ?");
            st.setString(1,fxTxtLogowanie.getText().toUpperCase());
            st.execute();
            ResultSet rs = st.getResultSet();
            // wyrzucany jest błąd, bo najpierw trzeba pobrać rekord ( rs.next() )
            // jeżeli wstawisz tą komendę w if'a to dodatkowo będziesz sprawdzał czy zaczytał się rekord
            if(rs.next()) {
                //if (rs.getString("haslo").equals(fxTxtHaslo.getText())){
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


            // Po zalgowaniu proponuję zamknąc to okno i otworzyć Menu główne przez
            // StageController sc = new StageController("menuGlowne", "Menu główne");
    }
    }

