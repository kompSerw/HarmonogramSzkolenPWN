package controller;

import daoMySQL.DaoToMySQL;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.KategoriaTematyczna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KategorieController {

    @FXML
    private TextField fxNazwaKursu;

    @FXML
    private Spinner<Integer> fxIleDni;

    @FXML
    private TableView<KategoriaTematyczna> fxTableView;

    @FXML
    private TableColumn<KategoriaTematyczna, String> fxTCNazwaKursu;

    @FXML
    private TableColumn<KategoriaTematyczna, Integer> fxTCKIloscDniursu;

    DaoToMySQL dao = new DaoToMySQL();

    @FXML
    void initialize() {
        int initialValue = 1;
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, initialValue);
        fxIleDni.setValueFactory(valueFactory);

    }

    public ArrayList<KategoriaTematyczna> pokazKategorie() {
        ArrayList<KategoriaTematyczna> list = new ArrayList<>();
        try {
            Statement st = dao.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from Kat_tematyczne");
            while(rs.next()){
                list.add(new KategoriaTematyczna(rs.getInt("id"),rs.getString("nazwa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

}


