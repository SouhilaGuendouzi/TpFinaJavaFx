package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CommandeFx {
    int i=0;
    Restaurant R1;
    @FXML TextField r1,z1,code,NT,Mp;
    @FXML TextArea affiche;

    @FXML ListView list;

 ArrayList<Ligne> listLigne=new ArrayList<Ligne>();
    //ArrayList<Ligne> listLigneConstructeur;
    //ArrayList<Ligne> listLigneConstructeur=(ArrayList<Ligne>)listLigne.clone();


    void transmission(Restaurant R) {
        R1=R;

    }

    public void Ajouter()

    {    Commande c1;
        if  ( (NT.getText().isEmpty())||(Mp.getText().isEmpty())) {
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("Veuiller Préciser Le numéro de la table ,Le Mode de Paiment et la date ");
            dialogW.showAndWait();
        }
        else if (listLigne.size()==0){
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("A warning dialog-box");
            dialogW.setHeaderText(null); // No header
            dialogW.setContentText("Veuiller Préciser Les plats   ");
            dialogW.showAndWait();
        }
        else {
            Integer nt=new Integer(NT.getText());
            int Nt=nt.intValue();
            ArrayList<Ligne> listLigneConstructeur=(ArrayList<Ligne>)listLigne.clone();
            c1=new Commande(Nt,Mp.getText(),listLigneConstructeur);
            R1.ajouter_commande(c1);
            list.getItems().remove(0, listLigneConstructeur.size());
            int l=listLigneConstructeur.size();
            listLigne.removeAll(listLigne);
            i=0;
            NT.setText("");
            Mp.setText("");

            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            dialog.setTitle("An information dialog-box");
            dialog.setHeaderText("Le code De La Commande est");
            dialog.setContentText(String.valueOf(c1.getCode()));
            dialog.showAndWait();

        }
    }
    public void plus(){

        Ligne ligne=new Ligne();
       if  ( (r1.getText().isEmpty())||(z1.getText().isEmpty())) {
           Alert dialogW = new Alert(Alert.AlertType.WARNING);
           dialogW.setTitle("A warning dialog-box");
           dialogW.setHeaderText(null); // No header
           dialogW.setContentText("Veuiller Remplir La référence et la quantitée");
           dialogW.showAndWait();
       }
       else {
           Integer ref = new Integer(r1.getText());
           int ref1 = ref.intValue();
           if (R1.Chercher_Plat(ref1) == null) {
               Alert dialogW = new Alert(Alert.AlertType.ERROR);
               dialogW.setTitle("A warning dialog-box");
               dialogW.setHeaderText(null); // No header
               dialogW.setContentText("Le Plat n'existe Pas");
               dialogW.showAndWait();
           } else {
               i++;
               ligne.setPlat(R1.Chercher_Plat(ref1));
               Integer q = new Integer(z1.getText());
               int q1 = q.intValue();
               ligne.setQuantité(q1);
               listLigne.add(ligne);
               list.getItems().add(ligne.toString());
               if(i<listLigne.size()) listLigne.remove(0);
               r1.setText("");
               z1.setText("");

           }
       }


    }






    public void Retour(ActionEvent event ) throws IOException
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
    public void Afficher(){
        Integer c=new Integer(code.getText());
        int c1=c.intValue();
        affiche.setText(R1.afficher_commande(c1));

    }
    public void Clôturer(){
        Integer c=new Integer(code.getText());
        int c1=c.intValue();
        R1.cloturer_commande(c1);
        affiche.setText(R1.afficher_commande(c1));
    }
}
