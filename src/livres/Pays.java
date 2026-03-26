package livres;

public class Pays {
    private String codePays;
    private String nom;

    public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        ValiderPays(codePays);
    }

    public Pays (String codePays, String nom){
        ValiderPays(codePays);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private void ValiderPays(String codePays) {
        if (IsValidPays(codePays)) {
            this.codePays = codePays;
        } else {
            System.out.println("Code de pays invalide.");
            this.codePays = "ERR";
        }
    }

    private boolean IsValidPays(String codePays){
        return codePays.length() == 3 && codePays.toUpperCase().equals(codePays);
    }

    @Override
    public String toString() {
        return codePays + ":" + nom;
    }
}
