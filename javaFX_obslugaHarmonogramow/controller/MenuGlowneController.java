package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuGlowneController {

    @FXML
    private Button fxMGSzkolenia;

    @FXML
    private Button fxMGTrenerzy;

    @FXML
    private Button fxMGKategorie;

    @FXML
    private Button fxMGKursy;

    @FXML
    private Button fxMGWyloguj;

    @FXML
    void onMGKategorie(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("TestKategorie", "Kategorie");
    }

    @FXML
    void onMGKursy(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("TestKursy", "Kursy");
    }

    @FXML
    void onMGSzkolenia(ActionEvent event) {

        zamknijBierzaceIOtworzNoweOkno("szkolenia", "Szkolenia");
    }

    @FXML
    void onMGTerenerzy(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("trenerzy", "Trenerzy");
    }

    @FXML
    void onMGWyloguj(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("logowanie", "Logowanie");
    }

    @FXML
    void initialize() {
        assert fxMGSzkolenia != null : "fx:id=\"fxMGSzkolenia\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGTrenerzy != null : "fx:id=\"fxMGTrenerzy\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGKategorie != null : "fx:id=\"fxMGKategorie\" was not injected: check your FXML file 'menuGlowne.fxml'.";
        assert fxMGKursy != null : "fx:id=\"fxMGKursy\" was not injected: check your FXML file 'menuGlowne.fxml'.";

//        fxMGKategorie.setVisible(widoczny);
//        fxMGTrenerzy.setVisible(widoczny);
//        fxMGKursy.setVisible(widoczny);

//        fxMGKategorie.setDisable(false);
//        fxMGTrenerzy.setDisable(false);
//        fxMGKursy.setDisable(false);

    }

    private static boolean widoczny;


    public static void ukryjPrzyciski() {
       widoczny = false;
    }

    public static void pokazPrzyciski() {
        widoczny = true;
    }

    private void zamknijBierzaceIOtworzNoweOkno(String fxmlNazwa, String tytul) {
//        Stage s = (Stage)fxMGWyloguj.getScene().getWindow();
//        s.close();
        StageController sc = new StageController(fxmlNazwa, tytul);

    }

}
