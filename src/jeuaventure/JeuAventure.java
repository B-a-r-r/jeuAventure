/**
 *
 * @author clbarriere
 */

package jeuaventure;

import java.util.Random;
import java.util.Scanner;

public class JeuAventure {
     

    public static void main(String[] args) throws Exception {
        jeuAventure_menuPrincipal();
    }


    /**
     * Rôle : lance l'affichage du menu principal, demande à l'utilisateur à quel jeu il veut jouer et le lance. Si 
     *        l'utilisateur choisi de quitter l'application, lance l'affichage du message de fin.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuAventure_menuPrincipal() {
        int partiesGagnees = 0;
        int partiesJouees = 0;
        int jeu;

        do {
            jeuAventure_afficheMenu();
            System.out.println("Sélectionnez un des jeux ci-dessus :");
            jeu = jeuAventure_saisirNombreIntervalle(1, 5);

            switch (jeu) {
                case 1 :
                    if (jeuDevin_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 2 :
                    if (jeuSuite_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 3 :
                    if (jeuCourse_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                case 4 :
                    if (jeuTrain_principal()) {
                        partiesGagnees++;
                    }
                    partiesJouees++;
                    break;
                }
        } while (jeu!=5);

        jeuAventure_afficheMessageDeFin(partiesJouees, partiesGagnees);  
    }


    /**
     * Rôle : affiche le menu d'acceuil des minis jeux.
     * Pramètre : aucun
     * Return : aucun 
     */
    static void jeuAventure_afficheMenu() {
        System.out.println("\n           \\\\\\||||||////\n"
                + "            \\\\  ~ ~  //\n"
                + "             (  @ @  )\n"
                + "    ______ oOOo-(_)-oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (1) le devin " + "\n"
                + "\t (2) trouver la suite " + "\n"
                + "\t (3) la course en ligne " + "\n"
                + "\t (4) le train " + "\n"
                + "\t (5) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)\n");
    }


    /** 
     * Rôle : affiche un message de fin avec le nombre de parties jouées et de parties gagnées, ainsi que "VICTOIRE
     *        si l'utilisateur a au moins gagné autant de parties qu'il en a joué, "GAME OVER" sinon.
     * Paramètres : deux entiers, partiesJouees et partieGagnees.
     * Return : aucun
     */
    static void jeuAventure_afficheMessageDeFin(int partiesJouees, int partieGagnees) {
        String resultat;

        if (partieGagnees < partiesJouees) {
            resultat = "GAME OVER";
        } else {
            resultat = "VICTOIRE";
        }

        System.out.println("   .____________________.\n" +
                            "   |.------------------.|\n" +
                            "   ||                  ||\n" +
                            "   ||    " + resultat + "      ||\n" +
                            "   ||Parties jouées: " + partiesJouees + " ||\n" +
                            "   ||                  ||\n" +
                            "   ||Parties gagnées: " + partieGagnees + "||\n" +
                            "   ||__________________||\n" +
                            "   /.-.-.-.-.-.-.-.-.-.-\\\n" +
                            "  /.-.-.-.-.-.-.-.-.-.-.-\\\n" +
                            " /.-.-.-.-.-.-.-.-.-.-.-.-\\\n" +
                            "/______/__________\\___o____\\    \n" +
                            "\\__________________________"
                                    + "/");
    }



    /**
     * Rôle : demande à l'utilisateur de choisir un niveau de difficulté et renvoie la saisie.
     * Paramètre : aucun
     * Return : l'entier sélectionné.
     */
    static int jeuAventure_saisirNiveauDifficulte() {
        System.out.println("Veuillez sélectionner un niveau de difficulté entre : 1 et 3");
        return jeuAventure_saisirNombreIntervalle(1,3);
    }


    /**
     * Rôle : permet à l'utilisateur de saisir un entier, le renvoie seulement si celui ci se trouve dans l'intervalle [min;max].
     * Paramètres : min et max, les entiers bornes de l'intervalle.
     * Return : l'entier saisi, si il est valide.
     */
    static int jeuAventure_saisirNombreIntervalle(int min, int max) {
        int n;
        do {
            System.out.println("Saisir un nombre entre " + min + " et " + max + " :");
            n = jeuAventure_saisirNombre();
        } while (n<min || max<n);
        return n;
    }


    /**
     * Rôle : récupère un entier saisi par l'utilisateur.
     * Paramètre : aucun
     * Return : l'entier saisi.
     */
    static int jeuAventure_saisirNombre() {
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        return res;
    }


    /** 
     * Rôle : récupère un caractère saisi par l'utilisateur.
     * Paramètre : aucun
     * Return : le caractère saisi.
     */
    static char jeuAventure_saisirCaractere() {
        Scanner scanner = new Scanner(System.in);
        char res = scanner.nextLine().charAt(0);
        return res;
    }
    
    /** 
     * Rôle : tire un nombre entre min et max (inclus).
     * Paramètre : aucun
     * Return : l'entier tiré.
     */
    static int jeuAventure_entierAleatoire(int min, int max) {
        Random random = new Random();
        int res = random.nextInt(min,max+1);
        return res;
    }

    // JEU 1 : DEVIN
    
    /**
     * Rôle : affiche les règle du jeu du devin.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuDevin_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu du devin ! \nNiveaux de difficulté disponible : \n"
        + "1 : 5 coups pour trouver un nombre entre 0 et 10. \n"
        + "2 : 10 coups pour trouver un nombre entre 0 et 50. \n"
        + "3 : 10 coups pour trouver un nombre entre 0 et 100. \n");
    }


    /**
     * Rôle : fonction princiaple du jeu du devin, lance l'affichage des règles,  et lance le jeu selon le niveau de 
     *        difficulté saisi par l'utilisateur.
     * Paramètre : aucun
     * Return : un booléen, true si le niveau est réussi, false sinon.
     */
    static boolean jeuDevin_principal() {
        jeuDevin_afficheRegles();
        
        int difficulte = jeuAventure_saisirNiveauDifficulte();
        int valeur;

        switch (difficulte) {
            case 1 :
                valeur = jeuAventure_entierAleatoire(0,10);
                break;
            case 2 :
                valeur = jeuAventure_entierAleatoire(0,50);
                break;
            default :
                valeur = jeuAventure_entierAleatoire(0,100);
        }

        boolean resultat = jeuDevin_joueurChercheValeur(jeuDevin_nbMax(difficulte), jeuDevin_nbCoupsMax(difficulte), valeur);
        if (resultat) {
            System.out.println("\nC'est gagné !");
        } else {
            System.out.println("\nDommage, c'est perdu. Tu n'as pas trouvé le nombre " + valeur + " à temps.");
        }
        return resultat;
    }


    /**
     * Rôle : démarre une session de jeu. L'utilisateur doit trouver le nombre mystère passé en paramètre, a droit à un nombre de coups 
     *        aussi passé en paramètre et est aiguillé quant à la limite entre 0 et laquelle doivent se trouver ses propositions, elle 
     *        aussi passée en paramètre. Indique également si le nombre à trouver est plus ou moins grand que la proposition de l'utilisateur.
     *        BONUS: si l'utilisateur fait une proposition incohérente par rapport aux indices déjà fournis, il en est notifié.
     * Paramètres : - nbMax, un entier, la limite entre 0 et laquelle l'utilisateur doit chercher.
     *              - nbCoupsMax, un entier, soit le nombre de coups auxquels l'utilisateur a droit.
     *              - nombreATrouver, un entier, le nombre à trouver.
     * Return : un booléen, vrai si le niveau est réussi, false sinon.
     */
    static boolean jeuDevin_joueurChercheValeur(int nbMax, int nbCoupsMax, int nombreATrouver) {
        boolean coherence = true;   //stock l'aiguillage donné à l'utilisateur pour la dernière tentative, true si nombre trop petit, false si trop grand.
        int stockDerniereTentative = 0;  
        int nbCoups = 0;
        boolean resultat = false;

        do {
            System.out.println("\n********************"
                                + "\n\nVous devez trouver un nombre entre 0 et " + nbMax + ". \n"
                                + "Il reste " + (nbCoupsMax-nbCoups) + " coups à jouer.");
            int tentative = jeuAventure_saisirNombreIntervalle(0, nbMax);

            if (tentative == nombreATrouver) {
                resultat = true;
                break;

            } else if (stockDerniereTentative != 0 && tentative < stockDerniereTentative && coherence) {
                System.out.println("Réponse incohérente, le devin vous a indiqué que la solution été supérieure à " 
                                    + stockDerniereTentative + ".");  

            } else if (stockDerniereTentative != 0 && tentative > stockDerniereTentative && !coherence) {
                System.out.println("Réponse incohérente, le devin vous a indiqué que la solution été inférieure à " 
                                    + stockDerniereTentative + ".");

            } else if (tentative < nombreATrouver) {
                System.out.println("\nNombre proposé trop petit.");
                coherence = true;

            } else {
                System.out.println("\nNombre proposé trop grand.");
                coherence = false;
            }

            stockDerniereTentative = tentative;

            nbCoups++;

        } while (nbCoups < nbCoupsMax);

         return resultat;
    }


    /**
     * Rôle : renvoie la limite entre 0 et laquelle l'utilisateur doit chercher le nombre mystère,
     *        pour un niveau de difficulté donné.
     * Paramètre : difficulte, un entier.
     * Return : un entier.
     */
    static int jeuDevin_nbMax(int difficulte) {     
        switch (difficulte) {
            case 2 :
                return 50;
            case 3 :
                return 100;
            default :
                return 10;
        }
    }


    /**
     * Rôle : renvoie le nombre de coups maximum auxquels l'utilisateur à droit selon le niveau
     *        de difficulté.
     * Paramètre : difficulte, un entier.
     * Return : un entier.
     */
    static int jeuDevin_nbCoupsMax(int difficulte) {
        switch (difficulte) {
            case 1 :
                return 5;
            default :
                return 10;
        }
    }


    /// JEU 2 : SUITES

    /**
     * Rôle : fonction principale du jeu, lance l'affichage des règles, permet de saisir le niveau de 
     *        difficulté, de lancer le jeu et d'afficher les résultats.
     * Paramètre : aucun 
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuSuite_principal() {
        jeuSuite_afficheRegles();
        
        int difficulte = jeuAventure_saisirNiveauDifficulte();         

        boolean resultat = jeuSuite_partie(difficulte);
        if (resultat) {
            System.out.println("\nBravo tu as trouvé la forme manquante !");
        } else {
            System.out.println("\nC'est perdu, essais encore.");
        }
        return resultat;
    }


    /**
     * Rôle : affiche les règles du jeu des suites.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuSuite_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu des suites ! \nLes règles sont simples : "
        + "comprendre la suite logique et indiquer quelle est la prochaine forme. \n");
    }


    /**
     * Rôle : démarre une session de jeu selon le niveau de difficulté passé en paramètre et compare
     *        la réponse de l'utilisateur avec la forme attendue.
     * Paramètre : un entier, le niveau de difficulté
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuSuite_partie(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 1 :
                jeuSuite_afficheFormes('♣', '♥', '♣', '♥', ' ');
                break;
            case 2 :
                jeuSuite_afficheFormes('♥', '♥', '♣', '♣', ' ');
                break;
            default :
                jeuSuite_afficheFormes('♣', '♥', '♠', '♣', ' ');
        }
        return jeuSuite_saisirForme() == jeuSuite_formeCorrecte(niveauDifficulte);
    }


    /**
     * Rôle : affiche et présente la suite de caractères que l'utilisateur doit compléter.
     * Paramètres : 5 caractères, les qutres premiers de la suite, plus un espace vide pour indiquer 
     *              visuellement que l'utilisateur doit la compléter.     
     * Return : aucun
     */
    static void jeuSuite_afficheFormes(char c1, char c2, char c3, char c4, char c5) {
        System.out.println(" - - - - - \n"
                         + "|" + c1 + "|" + c2 + "|" + c3 + "|" + c4 + "|" + c5 + "|"
                         + "\n - - - - - ");
    }


    /**
     * Rôle : demande à l'utilisateur de saisir un caractère pour compléter la suite.
     * Paramètre : aucun
     * Return : le caractère saisi par l'utilisateur.
     */
    static char jeuSuite_saisirForme() {
       System.out.println("Saisir une lettre, t(♣) ou c(♥) ou p(♠).");
       char entree = jeuAventure_saisirCaractere();
       return entree;
    }

    /** 
     * Rôle : renvoie, pour un niveau de difficulté donné, le caractère attendu pour compléter la suite.
     * Paramètre : un entier, le niveau de difficulté.
     * Return : le caractère attendu pour compléter la suite.
     */
    static char jeuSuite_formeCorrecte(int niveauDifficulte) {
        switch (niveauDifficulte) {
            case 2 :
            case 3 :
                return 'c';
            default :
                return 't';
        }
    }


    /// JEU 3 : COURSE

    /** 
     * Rôle : fonction principale du jeu de la course, lance l'affichage des règles, lance le jeu et 
     *        affiche les résultats.
     * Paramètre : aucun
     * Return : un booléen, true si le joueur 1 gagne, false si c'est le joueur 2 (l'IA).
     */
    static boolean jeuCourse_principal() {
        boolean resultat = true;

        jeuCourse_afficheRegles();

        int joueurGagnant = jeuCourse_partie();

        if (joueurGagnant != 1) {
            resultat = false;  
        }
        
        System.out.println("\nLe joueur " + joueurGagnant + " a remporté la course !");
        
        return resultat;
    }


    /** 
     * Rôle : affiche les règles du jeu de course.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuCourse_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu de course ! \n"
                            + "Ce jeu se joue à deux. Le premier joueur qui fait passer la ligne d'arrivée à un courreur gagne. \n"
                            + "A chaque tour, un seul courreur peut être déplacé de 1, 2 ou 3 cases \n"
                            + "Excepté au démarrage, deux courreurs ne peuvent pas se trouver positionnés côte à côte. \n");
    }


    /** 
     * Rôle : affiche un message d'erreur si un joueur essaie de déplacer un coureur à côté d'un autre. 
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuCourse_afficherMessageErreur() {
        System.out.println("\nVous ne pouvez pas vous déplacer ici, un autre courreur est déjà en place à ce niveau.");
    }


    /**
     * Rôle : déroule une course, fait tourner le joueurs actif à chaque tour et lui demande 
     *        quel courreur il souhaite déplacer et jusqu'où. Vérifie également la validité
     *        des déplacemments et lance l'actualisation de l'affichage de la piste à chaque tour
     *        selon les positions respectives des trois courreurs.     
     * Paramètre : aucun
     * Return : un entier, le numéro du joueur ayant remporté la course.
     */
    static int jeuCourse_partie() {
        int posJ1 = 0, posJ2 = 0, posJ3 = 0;    // positions respectives des courreurs sur la piste.
        boolean positionInvalide = false;     // vaut true si l'on tente de déplacer un courreur à côté d'un autre, false sinon.
        int joueur = 0;
        int ligne = 0;  
        int tmp = 0;    // variable tampon, stocke la version précédente d'une variable de position pour y revenir si déplacement invalide.

        do {
            if (positionInvalide) {
                jeuCourse_afficherMessageErreur();
                positionInvalide = false;
            } else {
                joueur = jeuCourse_joueurSuivant(joueur);

                jeuCourse_afficheCourse(posJ1,posJ2,posJ3);
                
                System.out.println("\nJoueur " + joueur + ", à vous de jouer. \n"
                                        + "Sur quelle ligne voulez vous faire avancer un courreur ? (1, 2 ou 3)");
                if (joueur == 1) {
                    ligne = jeuAventure_saisirNombreIntervalle(1, 3);
                } else {
                    ligne = jeuCourse_IA_choisirLigne(posJ1, posJ2, posJ3);
                    System.out.println(ligne);
                }
            }
            System.out.println("De combien voulez vous faire avancer votre courreur ?");
            switch (ligne) {
                case (1) :
                    if (joueur==1) {
                        tmp = jeuAventure_saisirNombreIntervalle(1, 3);
                        posJ1 += tmp;
                        if (posJ1==posJ2 || posJ1==posJ3) {     // vérifie si le déplacement saisi emmène le courreur à côté d'un autre.
                            positionInvalide = true;
                            posJ1 -= tmp;
                        }
                    } else {
                        tmp = jeuCourse_IA_choisirDistance(posJ1, posJ2, posJ3);
                        posJ1 += tmp;
                        System.out.println(tmp);
                    }
                    break;
                case (2) :
                    if (joueur==1) {
                        tmp = jeuAventure_saisirNombreIntervalle(1, 3);
                        posJ2 += tmp;
                        if (posJ2==posJ1 || posJ2==posJ3) {     // vérifie si le déplacement saisi emmène le courreur à côté d'un autre.
                            positionInvalide = true;
                            posJ2 -= tmp;
                        }
                    } else {
                        tmp = jeuCourse_IA_choisirDistance(posJ2, posJ1, posJ3);
                        posJ2 += tmp;
                        System.out.println(tmp);
                    }
                    break;
                default :
                    if (joueur==1) {
                        tmp = jeuAventure_saisirNombreIntervalle(1, 3);
                        posJ3 += tmp;
                        if (posJ3==posJ2 || posJ3==posJ1) {     // vérifie si le déplacement saisi emmène le courreur à côté d'un autre.
                            positionInvalide = true;
                            posJ3 -= tmp;
                        }
                    } else {
                        tmp = jeuCourse_IA_choisirDistance(posJ3, posJ1, posJ2);
                        posJ3 += tmp;
                        System.out.println(tmp);
                    }
            }
        } while(posJ1<9 && posJ2<9 && posJ3<9);

        if (posJ1>9) { 
            posJ1 = 9;
        } else if (posJ2>9) {
            posJ2 = 9;
        } else if (posJ3>9) {
            posJ3 = 9;
        }
        jeuCourse_afficheCourse(posJ1,posJ2,posJ3);

        return joueur;
    }


    /** 
     * Rôle : passe d'un joueur à l'autre en fonction du joueur actif.
     * Paramètre : un entier, le numéro du joueur actif.
     * Return : un entier, le numéro du joueur qui rentre en jeu.
     */
    static int jeuCourse_joueurSuivant(int joueurActif) {
        switch (joueurActif) {
            case 1 :
                return 2;
            default :
                return 1;
        }
    }


    /** 
     * Rôle : affiche la piste de la course, actualisé en fonction du placement des coureurs.
     * Paramètres : 3 entiers, les positions respectives des trois coureurs.
     * Return : aucun
     */
    static void jeuCourse_afficheCourse(int posJ1, int posJ2, int posJ3) {
        System.out.println(" - - - - - - - - - ARRIVEE");
        jeuCourse_afficheLigne(posJ1, '♥');
        jeuCourse_afficheLigne(posJ2, '♣');
        jeuCourse_afficheLigne(posJ3, '♠');
        System.out.println(" - - - - - - - - - ARRIVEE");
    }


    /**
     * Rôle : affiche une ligne de la piste de course, sur laquelle se trouve un coureur, selon son symbole et
     *        sa position récupérée en paramètre.
     * Paramètres : - un entier, position du coureur sur sa ligne.
     *              - un caractère, représentant le coureur en question.
     * Return : aucun
     */
    static void jeuCourse_afficheLigne(int position, char symbole) {
        for(int i=0; i<=9; i++){
            if(position==i){
                System.out.print("|" + symbole);
            }
            else{
                System.out.print("| ");
            }
        }
        System.out.println("|");
    }


    /** 
     * Rôle : chosit le meilleur courreur à déplacer, en fonction des positions respectives de 
     *        tous les courreurs.
     * Paramètres : - posJ1, un entier, la position du courreur de la ligne 1 sur la piste.
     *              - posJ2, un entier, la position du courreur de la ligne 2 sur la piste.
     *              - posJ3, un entier, la position du courreur de la ligne 3 sur la piste.
     * Return : un entier, le numéro de la ligne choisie.
     */
    static int jeuCourse_IA_choisirLigne(int posJ1, int posJ2, int posJ3) {
        int choix = 3;

            if ((posJ1<=posJ3 && posJ2<=posJ3) && (posJ3<5) || (posJ1<4 && posJ1<posJ3) || (posJ2<4 && posJ2<posJ3) && (posJ3<5) || (posJ3+3>=9)) {  
                choix = 3;
            } else if ((posJ1<=posJ2 && posJ3<=posJ2) && (posJ2<5) || (posJ1<4 && posJ1<posJ2) || (posJ3<4 && posJ3<posJ2) && (posJ2<5) || (posJ2+3>=9)) {
                choix = 2;
            } else if (((posJ3<=posJ1 && posJ2<=posJ1) && (posJ1<5) || (posJ2<4 && posJ2<posJ1) || (posJ3<4 && posJ3<posJ1)) && (posJ1<5) || (posJ1+3>=9)) {
                choix = 1;
            }
        
        return choix;
    }


    /** 
     * Rôle : determine la distance d'avancement optimale du courreur sélectionné, selon les positions
     *        respectives de tous les courreurs.
     * Paramètres : - posCourreurActif, un entier, la position du courreur de la ligne sélectionnée.
     *              - posJ1, un entier, la position d'un courreur inacif sur la piste.
     *              - posJ2, un entier, la position de l'autre courreur inactif sur la piste.
     * Return : un entier, la distance à faire parcourrir au courreur sélectionné.
     */
    static int jeuCourse_IA_choisirDistance(int posCourreurActif, int posJ1, int posJ2) {
        int avancement = 3;
        
        if (posCourreurActif<=1) {
            avancement = jeuAventure_entierAleatoire(1,2);

        } else if ((posCourreurActif<5) && ((posJ1!=5) && (posJ2!=5))) {
            avancement = 5-posCourreurActif;

        } else if ((posCourreurActif<4) && ((posJ1!=4) && (posJ2!=4))) {
            avancement = 4-posCourreurActif;

        } else if (posCourreurActif==2) {
            avancement = 1;
        }

        return avancement;
    }

    /// JEU 4 : TRAIN

    /** 
     * Rôle : fonction principale du jeu du train, lance l'affichage des règles, permet de saisir 
     *        un niveau de difficulté et de lancer le jeu.
     * Paramètre : aucun
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuTrain_principal() {
        jeuTrain_afficheRegles();

        int difficulte = jeuAventure_saisirNiveauDifficulte();

        return jeuTrain_partie(difficulte);
    }


    /**
     * Rôle : affiche les règles du jeu du train.
     * Parmètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheRegles() {
        System.out.println("\nBienvenue dans le jeu du train ! \n"
                            + "Les règles sont simples : comptez les usagers à quai et saisissez le nombre "
                            +"de wagons nécessaires pour les accueillir.\n" );        
    }


    /**
     * Rôle : tire un nombre aléatoire d'usagers en fonction du niveau de difficulté et demande à 
     *        l'utilisateur de saisir le nombre de wagons nécessaires. Lance aussi l'affichage des
     *        usagers (smileys), du train, et des résultats.
     * Paramètre : un entier, le niveau de difficulté.
     * Return : un booléen, true si le jeu est réussi, false sinon.
     */
    static boolean jeuTrain_partie(int niveauDifficulte) {
        boolean resultat = true;
        int usagers;

        switch (niveauDifficulte) {
            case 1 :
                usagers = jeuAventure_entierAleatoire(1,2);
                break;
            case 2 :
                usagers = jeuAventure_entierAleatoire(1,3);
                break;
            default :
                usagers = jeuAventure_entierAleatoire(1,4);
        } 
        
        System.out.println();

            int i = usagers;
            for (; i>0; i--) {
                System.out.print("☺");
            }
            System.out.println("\nVoici le nombre d'usager à quais, combien de wagons faut il ajouter ?");

            int wagons = jeuAventure_saisirNombre();
            do {
                while (((usagers%2==0) && ((usagers/2)<wagons)) || ((usagers%2!=0) && (usagers-usagers/2)<wagons)) {
                    jeuTrain_afficheWagonVide();
                    wagons--;
                    resultat = false;
                }
                if ((usagers%2==0 && wagons<=usagers) || (usagers%2!=0 && usagers>1 && wagons==1)) {
                    jeuTrain_afficheWagonOccupeDouble();
                    wagons--;
                    usagers-=2;
                } else if ((usagers%2==1 && wagons<=usagers)) {
                    jeuTrain_afficheWagonOccupeSimple();
                    wagons--;
                    usagers--;
                }
            } while (wagons > 0);

            jeuTrain_afficheLocomotive();
            
            if (usagers>0) {
                System.out.println("\nC'est perdu. Vous avez laissez " + usagers + " usagers sur le quais ! :");
                for (; usagers>0; usagers--) {
                    System.out.print("☺");
                } 
                resultat = false;
            } else if (!resultat) {
                System.out.println("\nC'est perdu. Vous avez prévu trop de wagons !");  // si un wagon vide a été afficher, resultat vaut déjà false.
            } else {
                System.out.println("\nC'est gagné ! Vous avez parfaitement remplit le train !");
            }
        return resultat;
    }


    /** 
     * Rôle : affiche un wagon vide du train.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheWagonVide() {
        System.out.println(""
                    + "  —————  \n"
                    + "  |   |  \n"
                    + "  |   |  \n"
                    + "  |   |  \n"
                    + "  —————  \n"
                    + "    |    ");
    }


    /** 
     * Rôle : affiche un wagon du train occupé par une seule personne.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheWagonOccupeSimple() {
        System.out.println(""
                    + "  —————  \n"
                    + "  |   |  \n"
                    + "  | ☺ |  \n"
                    + "  |   |  \n"
                    + "  —————  \n"
                    + "    |    "
            );
    }


    /** 
     * Rôle : affiche un wagon du train occupé par deux personnes.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheWagonOccupeDouble() {
        System.out.println(""
                    + "  —————  \n"
                    + "  | ☺ |  \n"
                    + "  |   |  \n"
                    + "  | ☺ |  \n"
                    + "  —————  \n"
                    + "    |    ");
    }


    /** 
     * Rôle : affiche la locomotive du train.
     * Paramètre : aucun
     * Return : aucun
     */
    static void jeuTrain_afficheLocomotive() {
        System.out.println("    |\n"
                + "   |||\n"
                + " .-----.\n"
                + " |o< >o|\n"
                + "//// \\\\\\\\\n"
                + "  /---\\ \n"
                + " /-----\\\n"
        );
    }



}
