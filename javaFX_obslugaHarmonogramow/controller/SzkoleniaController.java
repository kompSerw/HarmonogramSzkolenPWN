package controller;

import java.net.URL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import daoMySQL.DaoToMySQL;
import model.Szkolenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SzkoleniaController {

    private DaoToMySQL connection = new DaoToMySQL();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<model.Szkolenie> fxTabviewSzkolenia;

    @FXML
    private TableColumn<Szkolenie, String> fxColNazwaSzkolenia;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataOd;

    @FXML
    private Button fxButDodajSzkolenie;

    @FXML
    private Button fxButUsunSzkolenie;

    @FXML
    private TableColumn<Szkolenie, Date> fxColDataDo;

    @FXML
    private DatePicker fxDatDataDo;

    @FXML
    private Button fxButEdytujSzkolenie;

    @FXML
    private DatePicker fxDatDataOd;

    @FXML
    private TableColumn<Szkolenie, String> fxColTypSzkolenia;

    @FXML
    private TableColumn<Szkolenie, String> fxColAkronim;

    @FXML
    private TextField fxTxtAkronim;

    @FXML
    private ComboBox<String> fxComNazwaKursu;

    @FXML
    private ComboBox<String> fxComTypSzkolenia;

    @FXML
    private Button fxButSlownikSzkolen;

    @FXML
    void onButDodajSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO fkedupl_pwngr.Szkolenia (akronim, data_od, data_do, typ_szkolen, Kursy_id) select ?, ?, ?, ?, id from Kursy where nazwa = ?;");
            ps.setString(1,fxTxtAkronim.getText());
            ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
            ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()));
            ps.setString(5, String.valueOf(fxComNazwaKursu.getValue()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populaTetableView();
    }

    @FXML
    void onButEdytujSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        Szkolenie szkolenie = fxTabviewSzkolenia.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE fkedupl_pwngr.Szkolenia SET akronim=?, data_od=?, data_do=?, typ_szkolen=?, Kursy_id=(select id from Kursy where nazwa = ?) WHERE akronim=?;");
            ps.setString(1,fxTxtAkronim.getText());
            try {
                ps.setDate(2, java.sql.Date.valueOf(fxDatDataOd.getValue()));
                ps.setDate(3, java.sql.Date.valueOf(fxDatDataDo.getValue()));
            }catch (NullPointerException nulle){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Wypełnij wszystkie pola przed edycją szkolenia!");
                alert.showAndWait();
            }
            ps.setString(4, String.valueOf(fxComTypSzkolenia.getValue()));
            ps.setString(5, String.valueOf(fxComNazwaKursu.getValue()));
            ps.setString(6, szkolenie.getAkronim());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Wypełnij wszytskie pola przed edycją szkolenia!");
            alert.showAndWait();
        }
        populaTetableView();
    }

    @FXML
    void onButUsunSzkolenie(MouseEvent event) {
        Connection con = connection.getCon();
        Szkolenie szkolenie = fxTabviewSzkolenia.getSelectionModel().getSelectedItem();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM fkedupl_pwngr.Szkolenia WHERE akronim=?");
            ps.setString(1,szkolenie.getAkronim());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populaTetableView();
    }

    @FXML
    void initialize() {
        populaTetableView();
        fxComTypSzkolenia.getItems().addAll("d","w");

        ObservableList<String> nazwa;
        ArrayList<String> nazwaSzkolen = new ArrayList<>();
        Connection con = connection.getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nazwa FROM Kursy GROUP BY nazwa;");
            while (rs.next()){
                nazwaSzkolen.add(rs.getString("nazwa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nazwa = FXCollections.observableArrayList(nazwaSzkolen);
        fxComNazwaKursu.getItems().addAll(nazwa);
    }

    private void populaTetableView() {
        ObservableList<Szkolenie> szkolenieView;
        Connection con = connection.getCon();
        ArrayList<Szkolenie> szkolenieLista = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT sz.akronim, sz.data_od, sz.data_do, sz.typ_szkolen, k.nazwa FROM Szkolenia as sz LEFT JOIN Kursy as k on sz.Kursy_id = k.id;");
            while (rs.next()){
                Szkolenie szkolenie = new Szkolenie();
                String akronim = rs.getString("akronim");
                Date data_od = rs.getDate("data_od");
                Date data_do = rs.getDate("data_do");
                String typ_szkolen = rs.getString("typ_szkolen");
                String nazwa = rs.getString("nazwa");
                szkolenie.setAkronim(akronim);
                szkolenie.setData_od(data_od);
                szkolenie.setData_do(data_do);
                szkolenie.setTyp_szkolen(typ_szkolen);
                szkolenie.setNazwa(nazwa);
                szkolenieLista.add(szkolenie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxTabviewSzkolenia.getItems().clear();
        szkolenieView = FXCollections.observableArrayList(szkolenieLista);
        fxColAkronim.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("akronim"));
        fxColDataOd.setCellValueFactory(new PropertyValueFactory<Szkolenie, Date>("data_od"));
        fxColDataDo.setCellValueFactory(new PropertyValueFactory<Szkolenie, Date>("data_do"));
        fxColTypSzkolenia.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("typ_szkolen"));
        fxColNazwaSzkolenia.setCellValueFactory(new PropertyValueFactory<Szkolenie, String>("nazwa"));
        fxTabviewSzkolenia.getItems().addAll(szkolenieView);
    }
}


