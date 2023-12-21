import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String nom;
    private String prenom;
    private String matricule;
    private int age;
    private Date dateNaissance;

    // Variable statique pour stocker le numéro d'identification
    private static int numeroIdentification = 1;

    // Constructeur
    public Person(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.matricule = generateMatricule();
        this.age = calculateAge();
    }

    // Méthode pour générer automatiquement le matricule unique
    private String generateMatricule() {
        String matricule = "" + prenom.charAt(0) + nom.charAt(0) + String.format("%04d", numeroIdentification);
        numeroIdentification++;
        return matricule;
    }

    // Méthode pour calculer l'âge en années
    private int calculateAge() {
        Date currentDate = new Date();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        int anneeNaissance = Integer.parseInt(yearFormat.format(dateNaissance));
        int anneeActuelle = Integer.parseInt(yearFormat.format(currentDate));
        return anneeActuelle - anneeNaissance;
    }

    // Méthode pour récupérer le matricule
    public String getMatricule() {
        return matricule;
    }

    // Méthode pour récupérer l'âge
    public int getAge() {
        return age;
    }

    // Méthode pour comparer deux instances de Person
    public boolean equals(Person otherPerson) {
        // Comparaison basée sur le matricule
        return this.matricule.equals(otherPerson.getMatricule());
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        Date dateNaissanceJohnDoe = new Date(90, 0, 1); // 1er janvier 1990
        Person johnDoe = new Person("Doe", "John", dateNaissanceJohnDoe);

        // Affichage des informations
        System.out.println("Matricule de John Doe : " + johnDoe.getMatricule());
        System.out.println("Âge de John Doe : " + johnDoe.getAge() + " ans");
    }
}
