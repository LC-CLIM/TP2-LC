package livres;

import java.time.LocalDate;
import java.util.Objects;

public class OuvrageVideo extends Ouvrage {
    private double DUREE_MINUTES_DEFAUT = 10;
    private double TAILLE_MB_DEFAUT = 5;

    private double dureeMinutes;
    private double tailleMb;

    public double getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(double dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public double getTailleMb() {
        return tailleMb;
    }

    public void setTailleMb(double tailleMb) {
        this.tailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, double dureeMinutes, double tailleMb){
        super(titre, auteur, date, nombreExemplaires);
        this.dureeMinutes = dureeMinutes;
        this.tailleMb = tailleMb;
    }

    public OuvrageVideo(String titre, Auteur auteur) {
        super (titre, auteur);
        this.setDate(null);
        this.nombreExemplaires = NOMBRE_EXEMPLAIRE_DEFAUT;
        this.dureeMinutes = DUREE_MINUTES_DEFAUT;
        this.tailleMb = TAILLE_MB_DEFAUT;
    }

    @Override
    public String toString() {

        String affichageDAte = date != null ? date.toString() : "Non Disponible";

        return "[" + identificateur() + "] " + titre + " (" + auteur.getPrenom() + " "
                + auteur.getNom() + ")" + " - disponible le " + affichageDAte + " (" + nombreExemplaires + " ex.), Durée (en minutes) = " + dureeMinutes + ", taille (en Mb)" + tailleMb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OuvrageVideo)) return false;
        Ouvrage ouvrage = (Ouvrage) o;
        return Objects.equals(titre, ouvrage.titre) &&
                Objects.equals(auteur, ouvrage.auteur);
    }
}
