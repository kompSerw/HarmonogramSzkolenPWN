package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class MenuGlowneController {

    @FXML
    private ToggleButton fxMGSzkolenia;

    @FXML
    private ToggleButton fxMGTrenerzy;

    @FXML
    private ToggleButton fxMGKategorie;

    @FXML
    private ToggleButton fxMGKursy;

    @FXML
    private ToggleButton fxMGWyloguj;

    private static boolean widoczny;

    @FXML
    void onMGKategorie(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("Kategorie", "Kategorie");
    }

    @FXML
    void onMGKursy(ActionEvent event) {
        zamknijBierzaceIOtworzNoweOkno("Kursy", "Kursy");
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

        //ustawienie dymków podpowiedzi do przycisków na formatce okna
        fxMGSzkolenia.setTooltip(ustawToolTip(new Tooltip("Pokaż szkolenia")));
        fxMGKategorie.setTooltip(ustawToolTip(new Tooltip("Pokaż kategorie")));
        fxMGKursy.setTooltip(ustawToolTip(new Tooltip("Pokaż kursy")));
        fxMGTrenerzy.setTooltip(ustawToolTip(new Tooltip("Pokaż trenerów")));
        fxMGWyloguj.setTooltip(ustawToolTip(new Tooltip("Wyloguj i zamknij program")));



    }

    private Tooltip ustawToolTip(Tooltip tt) {
        tt.setStyle("-fx-font: normal bold 14 Langdon; "
                + "-fx-base: #AE3522; "
                + "-fx-text-fill: orange;");
        return tt;
    }


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
