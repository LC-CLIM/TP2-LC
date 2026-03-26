package tests;

import java.time.LocalDate;
import java.util.List;

import livres.Ouvrage;
import livres.Auteur;
import livres.Pays;
import livres.Serie;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {
    Pays canada = new Pays("CAN", "Canada");
    Pays etatsunis = new Pays("USA", "États-Unis");
    Pays suisse = new Pays("CFH", "Suisse"); //CFH = Confederatio Helvetica
    Pays france = new Pays("FRA", "France");
    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie();
        test.testPays();
    }

    private void testPays() {
        System.out.println("------Test pays------");
        System.out.println("Tests d'erreur");
        Pays paysErreur1 = new Pays("non", "URSS");
        System.out.println(paysErreur1);
        Pays paysErreur2 = new Pays("FAUX", "Rome");
        System.out.println(paysErreur2);
        Pays paysTestMexique = new Pays("MEX", "Mexique");
        System.out.println("Tests de création et utilisation de pays:\n" + paysTestMexique);
        Auteur auteurTestPays = new Auteur("Prenom", "Nom", paysTestMexique);
        System.out.println(auteurTestPays);
    }

    public void testSerie() {
        System.out.println("------Test série------");
        Auteur frank = new Auteur("Frank", "Herbert", etatsunis);
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Auteur john = new Auteur("John", "Smith", etatsunis);
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), 10);
        Ouvrage dune = new Ouvrage("Dune", frank, Ouvrage.Format.PAPIER, LocalDate.ofYearDay(1965, 274), 1000);
        Serie serieTest = new Serie("TEST");
        System.out.println("Série vide: " + serieTest);
        serieTest.ajouterOuvrage(dune);
        serieTest.ajouterOuvrage(livreA);
        serieTest.ajouterOuvrage(livre2);
        System.out.println("Série après trois ajouts: " + serieTest);
        serieTest.enleverOuvrage(livreA);
        System.out.println("Série après une rétraction: " + serieTest);
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Auteur john = new Auteur("John", "Smith", etatsunis);

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", canada));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", france));
        System.out.println("Livres de Jacques: " + resultat);
    }


}

