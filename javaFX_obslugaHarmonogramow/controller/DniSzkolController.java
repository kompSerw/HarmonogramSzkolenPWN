package controller;

import model.Trener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DniSzkolController {

    private ObservableList pokazTrenerow(Connection con) {
        List<Trener> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id, imie, nazwisko, inicjaly from Trenerzy");
            while (rs.next()){
                list.add(new Trener(rs.getInt("id"), rs.getString("imie"),
                        rs.getString("nazwisko"), rs.getString("inicjaly"),
                        rs.getString(""), rs.getInt("")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(list);
    }

}
