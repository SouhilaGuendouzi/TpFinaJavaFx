package sample;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.Instant;

public class Restaurant {
    private String nom;
    private ArrayList<Plat> plats = new ArrayList<Plat>();
    private ArrayList<Commande> commandes = new ArrayList<Commande>();
    private Caisse caisse = new Caisse();
    private static int s;
    private static ArrayList<String> S = new ArrayList<String>();


    // Getters & Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Plat> getPlats() {
        return plats;
    }


    public void setPlats(ArrayList<Plat> plats) {
        this.plats = plats;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    // Constructeurs

    public Restaurant() {
    }

    public Restaurant(String nom) {
        this.nom = nom;

    }

    public Restaurant(String nom, ArrayList<Plat> plats, ArrayList<Commande> commandes, Caisse caisse) {
        this.nom = nom;
        this.plats = plats;
        this.commandes = commandes;
        this.caisse = caisse;
    }

    ///////////////Exceptions Plat//////////////////////
    void Plat_Exist(Plat p) throws PlatExiste {
        int i = 0;
        boolean b = false;
        while (i < this.plats.size() && b == false) {
            if (this.plats.get(i).equals(p)) b = true;
            i++;
        }
        if (b == true) throw new PlatExiste();
    }

    /***********************************************/
    void ListPlat_vide() throws ListPlatsVide {
        if (this.plats.isEmpty()) throw new ListPlatsVide();
    }

    /*************************************************/
    Plat Plat_introuvable(int ref, String detail) throws PlatIntrouvable {
        boolean trouve = false;
        int i = 0;
        Plat p = null;
        while (i < plats.size() && trouve == false) {
            if (this.plats.get(i).reference == ref) {
                trouve = true;
                p = this.plats.get(i);
            }
            i++;
        }
        if (trouve == false) throw new PlatIntrouvable();
        else return p;

    }

    /*************************************************/

    // Méthodes Plat
    public void ajouter_plat(Plat p) {

        try {
            Plat_Exist(p);
            this.getPlats().add(p);

        } catch (PlatExiste platExiste) {
            System.out.println(platExiste.getMessage());
        }


    }

    public void modifier_détail_plat(int ref, String detail) {
        try {
            ListPlat_vide();

            Plat_introuvable(ref, detail).setDétail(detail);
        } catch (PlatIntrouvable e) {
            System.out.println(e.getMessage());
        } catch (ListPlatsVide p) {
            System.out.println(p.getMessage());
        }

    }

    public String afficher_plats() {
        String s = new String();
        try {
            ListPlat_vide();
            Iterator<Plat> it = plats.iterator();
            while (it.hasNext()) {
                //System.out.println(it.next().toString());
                s=s+it.next().toString()+"\n"+"\n";
            }


        } catch (ListPlatsVide listPlatsVide) {
            System.out.println(listPlatsVide.getMessage());
        }
        return s;
    }
    public Plat Chercher_Plat(int ref ) {
        boolean trouve = false;
        int i = 0;
        Plat p = null;
        while (i < plats.size() && !trouve) {
            if (this.plats.get(i).reference == ref) {
                trouve = true;
                p=this.plats.get(i);
            }
            i++; }
        return p;
    }
    /**************Exception Commande***************/
    void Commande_Existe(Commande c) throws  CommandeExiste{
        int i = 0;
        boolean b = false;
        while (i < this.commandes.size() && b == false) {
            if (this.commandes.get(i).equals(c)) b = true;
            i++;
        }
        if (b == true) throw new CommandeExiste();

    }/*****************************************/
    Commande Commande_introuvable(int  code) throws CommandeIntrouvable{
        Iterator<Commande> it = commandes.iterator();
        boolean trouve = false;
        Commande x=null;
        while (it.hasNext() && trouve==false) {
            x = it.next();
            if (x.getCode() == code) {
                trouve = true;
            }
        }
        if (trouve==false) throw new CommandeIntrouvable();
        else return  x;


    }
    /*********************/
    void Liste_Commande_vide() throws ListCommandeVide{
        if (this.commandes.isEmpty()) throw new ListCommandeVide();
    }
    void LIGNE_VIDE(Commande c) throws LigneVide{
        if (c.getLignes_commande().size()==0) throw new LigneVide();
    }


    // Methodes Commande

    public void ajouter_commande(Commande c) {

        try {      LIGNE_VIDE(c);
            Commande_Existe(c);
            this.commandes.add(c);// pour ajouter la ccommande dans la liste des commandes
            S.add(c.toString());
            s++;
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Commandes.txt"));
            o.writeObject(S);
            o.close();
            double x = 0;
            x = this.getCaisse().trouver_date(c.getDate());               // pour ajouter la commande dans la caisse (recette du jour)
            if (x > -1) {                                                     // si la date déja existe dans la liste des recettes on insert
                this.caisse.getRecettes().get((int) x - 1).getCommandes().add(c);
            } else {                                                           // sinon on ajoute la date dans la liste puis la commande
                Recette r = new Recette();
                r.setDate(c.getDate());
                r.getCommandes().add(c);
                this.caisse.getRecettes().add(r);
            }
        }
        catch (Exception e) {

            if (e instanceof LigneVide)
            {
                System.out.println(e.getMessage());
            }
            else if(e instanceof CommandeExiste) System.out.println(e.getMessage());
            else System.out.println(e.getMessage());


        }

    }



    public String afficher_commande(int code)  {
        try{ Liste_Commande_vide();
            return Commande_introuvable(code).toString();
        }
        catch(CommandeIntrouvable e)
        {
            return e.getMessage();
        }
        catch(ListCommandeVide e1)
        {
            return e1.getMessage();
        }

    }

    public void cloturer_commande(int code){
        try{ Liste_Commande_vide();
            Commande x=Commande_introuvable(code);
            x.setId_cloture(true);
            x.setTotal(x.total());
        }
        catch(CommandeIntrouvable e)
        {
            System.out.println(e.getMessage());
        }
        catch(ListCommandeVide e1)
        {
            System.out.println(e1.getMessage());
        }
    }

    // Méthodes Caisse

    public ArrayList<Commande> afficher_recette(int y, int m, int d){
        ArrayList<Commande> r=new ArrayList<Commande>();
        LocalDate date = LocalDate.of(y,m,d);
        double x= this.caisse.trouver_date(date);
        if(x==-1){
            System.out.println("aucune recette pour cette date");
        }else{
          r=this.caisse.getRecettes().get((int)x-1).getCommandes();
        }
        return r;
    }
    Ligne Plat_Commande(Commande c)
    {
        int max=c.getLignes_commande().get(0).getQuantité();
        Plat pMax=c.getLignes_commande().get(0).getPlat();
        for (int i=1;i<c.getLignes_commande().size();i++)
        {
            if (c.getLignes_commande().get(i).getPlat().equals(pMax)) max=max+c.getLignes_commande().get(i).getQuantité();
            else if (c.getLignes_commande().get(i).getQuantité()>max)
            {
                max=c.getLignes_commande().get(i).getQuantité();
                pMax=c.getLignes_commande().get(i).getPlat();
            }
        }

        Ligne l=new Ligne(pMax,max);
        return l;
    }
    Ligne Plat_Recette(Recette r)
    {
        int max=Plat_Commande(r.getCommandes().get(0)).getQuantité();
        Plat pMax=Plat_Commande(r.getCommandes().get(0)).getPlat();
        for (int i=1;i<r.getCommandes().size();i++)
        {
            if (Plat_Commande(r.getCommandes().get(i)).getPlat().equals(pMax)) max+=Plat_Commande(r.getCommandes().get(i)).getQuantité();
            else if (Plat_Commande(r.getCommandes().get(i)).getQuantité()>max) {
                max=Plat_Commande(r.getCommandes().get(i)).getQuantité();
                pMax=Plat_Commande(r.getCommandes().get(i)).getPlat();
            }
        }

        Ligne l=new Ligne(pMax,max);
        return l;
    }


    public String afficher_plat_plus_commandé(){
        int max =Plat_Recette(this.caisse.getRecettes().get(0)).getQuantité();
        Plat pMax=Plat_Recette(this.caisse.getRecettes().get(0)).getPlat();
        for (int i=1;i<this.caisse.getRecettes().size();i++)
        {
            if (Plat_Recette(this.caisse.getRecettes().get(i)).getPlat().equals(pMax)) max+=Plat_Recette(this.caisse.getRecettes().get(i)).getQuantité();
            else if (Plat_Recette(this.caisse.getRecettes().get(i)).getQuantité()>max)
            {
                max=Plat_Recette(this.caisse.getRecettes().get(i)).getQuantité();
                pMax=Plat_Recette(this.caisse.getRecettes().get(i)).getPlat();
            }
        }
        return (pMax.getNom()+" "+pMax.détail);

    }

    //Autres
    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + "\n" +
                "plats=" + plats + "\n"+
                "commandes=" + commandes + "\n"+
                "caisse=" + caisse ;
    }


}



