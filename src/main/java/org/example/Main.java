

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Dupont", "Jean");

        while (true) {
            System.out.println("\n===============================");
            System.out.println("Menu principal :");
            System.out.println("1. Ajouter un ouvrier");
            System.out.println("2. Afficher la liste des ouvriers");
            System.out.println("3. Rechercher un ouvrier");
            System.out.println("4. Effectuer un travail");
            System.out.println("5. Supprimer un ouvrier");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();  // Consomme la ligne après la saisie de l'option

            switch (choix) {
                case 1:
                    // Ajouter un ouvrier
                    System.out.println("Choisissez le type d'ouvrier à ajouter :");
                    System.out.println("1. Electricien");
                    System.out.println("2. Maçon");
                    System.out.println("3. Peintre");
                    int typeOuvrier = scanner.nextInt();
                    scanner.nextLine();  // Consomme la nouvelle ligne

                    System.out.print("Nom de l'ouvrier : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom de l'ouvrier : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Années d'expérience : ");
                    int anneesExperience = scanner.nextInt();
                    scanner.nextLine();  // Consomme la nouvelle ligne

                    Ouvrier ouvrier = null;

                    if (typeOuvrier == 1) {
                        System.out.print("Domaine d'électricité : ");
                        String domaine = scanner.nextLine();
                        System.out.print("Certifié (true/false) : ");
                        boolean certifie = scanner.nextBoolean();
                        ouvrier = new Electricien(nom, prenom, anneesExperience, domaine, certifie);
                    } else if (typeOuvrier == 2) {
                        System.out.print("Spécialisation : ");
                        String specialisation = scanner.nextLine();
                        ouvrier = new Maçon(nom, prenom, anneesExperience, specialisation);
                    } else if (typeOuvrier == 3) {
                        System.out.print("Type de bâtiment : ");
                        String typeBatiment = scanner.nextLine();
                        System.out.print("Certifié (true/false) : ");
                        boolean certification = scanner.nextBoolean();
                        scanner.nextLine();  // Consomme la nouvelle ligne
                        ouvrier = new Peintre(nom, prenom, anneesExperience, typeBatiment, certification);
                    }

                    if (ouvrier != null) {
                        admin.ajouterOuvrier(ouvrier);
                    }
                    break;

                case 2:
                    // Afficher la liste des ouvriers
                    admin.afficherOuvriers();
                    break;

                case 3:
                    // Rechercher un ouvrier
                    System.out.print("Entrez le nom de l'ouvrier à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    admin.rechercherOuvrier(nomRecherche);
                    break;

                case 4:
                    // Effectuer un travail
                    System.out.print("Entrez le nom de l'ouvrier pour effectuer un travail : ");
                    String nomTravail = scanner.nextLine();
                    Ouvrier ouvrierTravail = admin.rechercherOuvrier(nomTravail);
                    if (ouvrierTravail != null) {
                        ouvrierTravail.effectuerTravail();
                    }
                    break;

                case 5:
                    // Supprimer un ouvrier
                    System.out.print("Entrez le nom de l'ouvrier à supprimer : ");
                    String nomSuppression = scanner.nextLine();
                    Ouvrier ouvrierASupprimer = admin.rechercherOuvrier(nomSuppression);
                    if (ouvrierASupprimer != null) {
                        admin.supprimerOuvrier(ouvrierASupprimer);
                    }
                    break;

                case 6:
                    // Quitter
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }
}
