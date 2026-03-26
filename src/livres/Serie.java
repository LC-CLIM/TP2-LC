package livres;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String nom;
    List<Ouvrage> listeOuvrages = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ouvrage> getListeOuvrages() {
        return listeOuvrages;
    }

    public void setListeOuvrages(List<Ouvrage> listeOuvrages) {
        this.listeOuvrages = listeOuvrages;
    }

    public void ajouterOuvrage(Ouvrage ouvrageAAjouter){
        listeOuvrages.add(ouvrageAAjouter);
    }

    public void enleverOuvrage(Ouvrage ouvreageAEnlever){
        listeOuvrages.remove(ouvreageAEnlever);
    }

    public Serie(String nom){
        this.nom = nom;
    }
}
