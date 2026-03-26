package livres;

import java.time.LocalDate;
import java.util.Objects;

public class OuvragePapier extends Ouvrage {
    private final int NOMBRE_PAGES_DEFAUT = 100;
    private int nombrePages;

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public OuvragePapier(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, int nombrePages) {
        super(titre, auteur, date, nombreExemplaires);
        this.nombrePages = nombrePages;
    }

    public OuvragePapier(String titre, Auteur auteur) {
        super (titre, auteur);
        this.setDate(null);
        this.nombreExemplaires = NOMBRE_EXEMPLAIRE_DEFAUT;
        this.nombrePages = NOMBRE_PAGES_DEFAUT;
    }

    @Override
    public String toString() {

        String affichageDAte = date != null ? date.toString() : "Non Disponible";

        return "[" + identificateur() + "] " + titre + " (" + auteur.getPrenom() + " "
                + auteur.getNom() + ")" + " - disponible le " + affichageDAte + " (" + nombreExemplaires + " ex.), Nombre de pages = " +nombrePages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OuvragePapier)) return false;
        Ouvrage ouvrage = (Ouvrage) o;
        return Objects.equals(titre, ouvrage.titre) &&
                Objects.equals(auteur, ouvrage.auteur);
    }
}
