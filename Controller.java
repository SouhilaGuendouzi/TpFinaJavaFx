package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;


public class Controller  {
        @FXML private TextField plat, detail1, prix, detail2, ref;
        @FXML TextArea affichage;
        Restaurant R1;

    void transmission(Restaurant R) {
        R1 = R;
        affichage.setText(R1.afficher_plats());
    }


    @FXML
    public void Ajouter() {

        try {
            if ((plat.getText().isEmpty()) || (detail1.getText().isEmpty()) || (prix.getText().isEmpty())) return;
            Integer n = new Integer(prix.getText());
            double s = n.doubleValue();
            Plat p = new Plat(plat.getText(), detail1.getText(), s);
            R1.ajouter_plat(p);
            plat.setText("");
            detail1.setText("");
            prix.setText("");
            affichage.setText(R1.afficher_plats());

        } catch (Exception e) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText(e.getMessage());
            dialogW.showAndWait();
        }
    }
    @FXML
    public void Modifier() {

            if ((ref.getText().isEmpty()) || (detail2.getText().isEmpty())) return;
            Integer n = new Integer(ref.getText());
            int s = n.intValue();
            R1.modifier_détail_plat(s, detail2.getText());
            affichage.setText(R1.afficher_plats());

    }

    @FXML
    public void Retour(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Acceuil.fxml"));
        Parent p = Loader.load();
        Scene s = new Scene(p);
        Acceuil c = Loader.getController();
        c.transmission(R1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }



}
