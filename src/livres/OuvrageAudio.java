package livres;

import java.time.LocalDate;
import java.util.Objects;

public class OuvrageAudio extends Ouvrage {
    public enum Format {
        NUMERIQUE, ANALOGIQUE
    }
    Format type;

    public Format getType() {
        return type;
    }

    public void setType(Format type) {
        this.type = type;
    }

    public OuvrageAudio(String titre, Auteur auteur, LocalDate date, int nombreExemplaires, Format type){
        super(titre, auteur, date, nombreExemplaires);
        this.type = type;

    }

    public OuvrageAudio(String titre, Auteur auteur, Format type){
        super(titre, auteur);
        this.nombreExemplaires = NOMBRE_EXEMPLAIRE_DEFAUT;
        this.type = type;

    }

    @Override
    public String toString() {

        String affichageDAte = date != null ? date.toString() : "Non Disponible";

        return "[" + identificateur() + "] " + titre + " (" + auteur.getPrenom() + " "
                + auteur.getNom() + ")" + " - disponible le " + affichageDAte + " (" + nombreExemplaires + " ex.), Type = " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OuvrageAudio)) return false;
        Ouvrage ouvrage = (Ouvrage) o;
        return Objects.equals(titre, ouvrage.titre) &&
                Objects.equals(auteur, ouvrage.auteur);
    }
}
