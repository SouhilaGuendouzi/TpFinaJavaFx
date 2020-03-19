package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;

public class Login {
    @FXML TextField nom;
    @FXML PasswordField passe;
    Restaurant R1=new Restaurant("EsiSba");
    String Mot_D_passe="Groupe2";
    void transmission(Restaurant R)
    {
        R1=R;
    }

    @FXML void login (ActionEvent event) throws IOException

    {    if((nom.getText().isEmpty())||(passe.getText().isEmpty())) return ;
         if ((nom.getText().equals(R1.getNom()))&&(passe.getText().equals(Mot_D_passe))){
        FXMLLoader  Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("Acceuil.fxml"));
        Parent p=Loader.load();
        Scene s= new Scene(p);
        Acceuil c=Loader.getController();

        c.transmission(R1);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();}
        else if (!(nom.getText().equals(R1.getNom()))){
        Alert dialogE = new Alert(Alert.AlertType.ERROR);
        dialogE.setTitle("Connnexion");
        dialogE.setHeaderText("Nom d'Utilisateur");
        dialogE.setContentText("Le Nom d'utilisateur n'existe !");
        dialogE.showAndWait();
    } else if (!(passe.getText().equals(R1.getNom())))
         {
             Alert dialogE = new Alert(Alert.AlertType.ERROR);
             dialogE.setTitle("Connnexion");
             dialogE.setHeaderText("Mot de passe ");
             dialogE.setContentText("Mot de passe Incorrect !");
             dialogE.showAndWait();
         }

        /*void Ajouter(ActionEvent event) throws IOException {
        // R=new Restaurant(Re.getText());
       /* Parent p = FXMLLoader.load((getClass().getResource("sample.fxml")));
        Scene p1=new Scene(p);
        Stage p2=(Stage)((Node)event.getSource()).getScene().getWindow();
        p2.setScene(p1);
        p2.show();*/
       /*FXMLLoader  Loader=new FXMLLoader();
       Loader.setLocation(getClass().getResource("sample.fxml"));
       Parent p=Loader.load();
       Scene s= new Scene(p);
       Controller c=Loader.getController();
        Ac c1=Loader.getController();
        c1.e(R);
       c.Ini(R);
       Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(s);
       window.show();



    }*/


    }

}
