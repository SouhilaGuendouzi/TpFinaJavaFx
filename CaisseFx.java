package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CaisseFx {
    @FXML DatePicker date;
    @FXML Label plat;
    @FXML ListView l1,l2,l3,l4,l5,l6;
    Restaurant R1;
    void transmission(Restaurant R)
    {
        R1=R;
    }

 public void Afficher1()
 { try {String s=new String();
     for (int i = 0; i < R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).size(); i++) {
      l1.getItems().add( R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getCode());
      l2.getItems().add( R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getNum_table());
      l3.getItems().add( R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getMode_paiement());
      l5.getItems().add( R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).total());
      l6.getItems().add( R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).isId_cloture());
      for (int j=0;j< R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getLignes_commande().size();j++)
      {

          s=s+"\t"+R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getLignes_commande().get(j).getPlat().getNom()+"\t"+R1.afficher_recette(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth()).get(i).getLignes_commande().get(j).getQuantité();
      }
      l4.getItems().add(s);


     }
 }
 catch(Exception e)
 {
     Alert dialogE = new Alert(Alert.AlertType.ERROR);
     dialogE.setTitle("An error dialog-box");
     dialogE.setHeaderText("Erreur :");
     dialogE.setContentText(" Aucune recette pour cette date");
     dialogE.showAndWait();
 }

 }


 public void Afficher2()
 {
     plat.setText(R1.afficher_plat_plus_commandé());
 }
    public void Retour(ActionEvent event) throws IOException
 {
     {
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
}
