package sample;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Acceuil  {

   @FXML Label NomRestaurant;
    Restaurant R1;

    void transmission(Restaurant R)
    {
        R1=R;
        NomRestaurant.setText(R1.getNom());
    }


    public void Menu(ActionEvent event) throws IOException
    {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("sample.fxml"));
        Parent p=Loader.load();
        Scene s= new Scene(p);
        Controller c=Loader.getController();
        c.transmission(R1);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();

    }
    public void Commandes(ActionEvent event) throws IOException
    {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("CommandeFx.fxml"));
        Parent p=Loader.load();
        Scene s= new Scene(p);
        CommandeFx c=Loader.getController();
        c.transmission(R1);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }
    public void Caisse(ActionEvent event) throws IOException
    {
        FXMLLoader Loader=new FXMLLoader();
        Loader.setLocation(getClass().getResource("CaisseFx.fxml"));
        Parent p=Loader.load();
        Scene s= new Scene(p);
        CaisseFx c=Loader.getController();
        c.transmission(R1);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(s);
        window.show();
    }


   public void Deconnexion(ActionEvent event) throws IOException{
       FXMLLoader Loader=new FXMLLoader();
       Loader.setLocation(getClass().getResource("Login.fxml"));
       Parent p=Loader.load();
       Scene s= new Scene(p);
       Login c=Loader.getController();
       c.transmission(R1);
       Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(s);
       window.show();
   }


}