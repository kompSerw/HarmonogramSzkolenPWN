package controller;

import daoMySQL.DaoToMySQL;
import model.KategoriaTematyczna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KategorieController {

    public KategorieController() {
    }

    DaoToMySQL dao = new DaoToMySQL();

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


