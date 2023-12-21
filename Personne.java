import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Personne {
    // Variables d'instance de la classe Personne
    protected String nom;
    protected Date dateNaissance;
    protected double taille;

    // Constructeur de la classe Personne
    public Personne(String nom, Date dateNaissance, double taille) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.taille = taille;
    }

    // Méthode d'affichage polymorphique pour les objets Personne
    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Date de Naissance : " + dateNaissance);
        System.out.println("Taille : " + taille);
    }

    // Classe Employe qui hérite de Personne
    public static class Employe extends Personne {
        // Variables d'instance supplémentaires pour Employe
        private double salaire;
        private String poste;
        // Variable statique pour compter le nombre total d'employés créés
        private static int nombreTotalEmployes = 0;
        // Constante représentant le salaire minimum
        private static final double SALAIRE_MINIMUM = 1000.0;

        // Constructeur pour Employe prenant le nom et le salaire
        public Employe(String nom, double salaire) {
            super(nom, new Date(), 0); // La date de naissance est initialisée à la date actuelle
            this.salaire = salaire;
            nombreTotalEmployes++;
        }

        // Constructeur pour Employe prenant le nom, la date de naissance et le poste
        public Employe(String nom, Date dateNaissance, String poste) {
            super(nom, dateNaissance, 0);
            this.poste = poste;
            this.salaire = generateSalaire(); // Génère un salaire aléatoire
            nombreTotalEmployes++;
        }

        // Méthode pour générer un salaire aléatoire entre 1000 et 5000
        private double generateSalaire() {
            Random rand = new Random();
            return SALAIRE_MINIMUM + rand.nextDouble() * (5000 - SALAIRE_MINIMUM);
        }

        // Redéfinition de la méthode d'affichage pour Employe
        @Override
        public void afficher() {
            super.afficher(); // Appelle la méthode d'affichage de la classe mère (Personne)
            System.out.println("Salaire : " + salaire);
            System.out.println("Poste : " + poste);
        }

        // Redéfinition de la méthode toString pour Employe
        @Override
        public String toString() {
            return "Employe [Nom : " + nom + ", Salaire : " + salaire + "]";
        }

        // Méthode statique pour obtenir le nombre total d'employés créés
        public static int getNombreTotalEmployes() {
            return nombreTotalEmployes;
        }
    }

    public static void main(String[] args) {
        // Création d'une collection d'employés (ArrayList)
        ArrayList<Employe> employes = new ArrayList<>();

        // Création de plusieurs instances de la classe Employe
        Employe employe1 = new Employe("Employe1", 2000.0);
        Employe employe2 = new Employe("Employe2", new Date(), "Poste2");
        Employe employe3 = new Employe("Employe3", 3000.0);

        // Ajout des employés à la collection
        employes.add(employe1);
        employes.add(employe2);
        employes.add(employe3);

        // Affichage des employés avant le tri
        System.out.println("Employés avant le tri :");
        for (Employe e : employes) {
            System.out.println(e);
        }

        // Tri de la collection d'employés
        Collections.sort(employes, (e1, e2) -> e1.nom.compareTo(e2.nom));

        // Affichage des employés après le tri
        System.out.println("\nEmployés après le tri par nom :");
        for (Employe e : employes) {
            e.afficher();
            System.out.println();
        }

        // Affichage du nombre total d'employés créés
        System.out.println("\nNombre total d'employés créés : " + Employe.getNombreTotalEmployes());
    }
}
