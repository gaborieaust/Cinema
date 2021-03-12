package com.company;

import java.util.Scanner;


public class Main {

    // fonction to check if there is enough place in the row : true if enough : false if not
    private static boolean Availability(int row, int tickets, String[][] kino) {
        boolean res = false; // initialisation du boolean à 0
        int count = 0;
        for (int c = 1; c <= kino[row - 1].length - 1; c++) {// going through the row bu counting the numbers of "-"
            if (kino[row - 1][c] == "-") {
                count = count + 1;
            }
        }
        System.out.println("Nombre de places disponibles dans la rangée : " + count);
        if (count >= tickets) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }
        // after checking the availability, we booked the place requested by the customers.
    private static String[][] Booking(String[][] kino, int row, int tickets) {
        int count = 0;
        //System.out.printf("Je suis ici 1");
        int c = 1;
        count = 0;
        while (c <= kino[row - 1].length - 1 && count < tickets) {// going through the table by replacing "-" when possible limited by the number of tickets requested
            if (kino[row - 1][c] == "-") {
                kino[row - 1][c] = "X";
                count++;
            }
            else {kino[row - 1][c] = "X";}
            c++;
        }

        return kino;
        }


 // simple function to return the result
private static String[][] readingTable(String[][] kino) {
    for (int l = 0; l < kino.length; l++) {
        // going through each column of each line
        for (int c = 0; c < kino[l].length; c++) {
            // disclosing the content of every cells.
            System.out.printf("[" + kino[l][c] + "]");

        }
        System.out.println();
    }
    return kino;
}

    private static String[][] Initialisation (String[][]kino){


        // j'initialiste mon tableau avec un chaîne de caractère de la forme "-"
        for (int l = 0; l <= kino.length - 1; l++) {
            kino[l][0] = Integer.toString(l + 1);
            for (int c = 1; c <= kino[l].length - 1; c++) {
                kino[l][c] = "-";
            }
            kino[3][3] = "X"; // place prise au hasard
            kino[5][6] = "X"; // place prise au hasard
        }
        // for the first column, numerotation with transformation of integer into string to match with table format
        for (int l = 0; l < kino.length; l++) {
            // going through each column of each line
            for (int c = 0; c < kino[l].length; c++) {
                // disclosing the content of every cells.
                System.out.printf("[" + kino[l][c] + "]");

            }
            System.out.println();
        }


        return kino;
    }


    public static void main(String[] args) {
        // gérer la salle de cinéma sous forme d'un tableau
        // demander à quel emplacement souhaite se mettre le client ?
        // demander le nombre de sièges ?
        // vérifier la dispo
        // remplir dans le tableau
        // intialisation de la fonction scann
        boolean bookingok = false;

        Scanner scanner = new Scanner(System.in);

            // représenter la salle de cinéma par un tableau
            String[][] kino = new String[6][7]; // 6 lignes et 7 colonnes
            // on va chercher dans une fonction pour représenter initialiser la salle comme vide avec le caractère "-"
            Initialisation(kino);
        while (!bookingok) {
            // Questions for the numbers of tickets requested ?
            System.out.println("How many tickets do you need ?");
            int tickets = scanner.nextInt();

            System.out.println("Where would you prefer to sit ?");
            int row = scanner.nextInt();


            // objectif is to check if there is enough place in the row specied by the customer

            bookingok = Availability(row, tickets, kino);
            if (bookingok) {
                System.out.println("You can book the tickets");
                Booking(kino, row, tickets);
                readingTable(kino);
                bookingok = false;
            } else {
                System.out.println("not enough place in the row, please select another row!");
            }

        }





    }
}

