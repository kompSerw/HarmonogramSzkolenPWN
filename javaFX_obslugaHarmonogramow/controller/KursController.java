package controller;

import daoMySQL.DaoToMySQL;
import model.Kurs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KursController {

    public KursController() {
    }

    DaoToMySQL dao = new DaoToMySQL();

    public ArrayList<Kurs> pokazKursy() {
        ArrayList<Kurs> lista = new ArrayList<>();
        try {
            Statement st = dao.getCon().createStatement();
            ResultSet rs = st.executeQuery("select * from Kursy");
            while(rs.next()){
                lista.add(new Kurs(rs.getInt("id"),rs.getString("nazwa"),rs.getInt("ile_dni")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}




