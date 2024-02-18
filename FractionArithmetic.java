package prog2.prelimgroup;

/*
Program: Prelim Group Project 1
Members:
    - Barrozo, Sebastian
    - Bernal, Mariella Lyshael Angeli
    - Caramat, Maria Fides Portia
    - Mabalot, Rod Clarenz
    - Palitayan, Ezekial Avensis
    - Vega, Althea Elise
    - Yarisantos, Nicole
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class FractionArithmetic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numerator, denominator;
        String enter = null;

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction solve = new Fraction();
        DecimalFormat df = new DecimalFormat("#.##");

        // displays when program first runs
        System.out.println( "╭─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮" +
                            "     ⢀⣀⣀⡤⠤⠤⠖⠒⠒⠒⠲⠤⠤⠤⠤⣀⣀⣀⡀\n" +
                            "     ⢸⠩⣭⣹⣍⣭⣙⡲⣒⠶⠶⠤⠤⠤⣄⣀⣀⠀⠉⢉⣩⡵⠶⡆⠀⠀ ⢀⣀⣀⣀⣀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⢠⣤⡀⠀⠀⠀  ⡀⠀⠀⠀⠀                 ⣀⡀⠀⠀⠀⠀⠀⢀⣤⡄\n" +
                            "     ⢸⡑⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣶⣥⣎⡬⢍⡿⠁⠛⡇⠀⣷⣄ ⠀⠈⠉⢹⡟⠉⠁⠀⣿⣀⣤⣀⠀⠀⢀⣠⣤⡀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⢿⡆⠀⠀⣀⣀⣠⣄⠀⠀⣀⣠⣍⠀⠀⢀⣀⣿⣇⣀⡀⠀ ⣿⣀⣤⣀⠀⢀⣀⣠⣀⣠⡀⠀⠀⣠⣤⣀⠀⢀⣀⣿⣇⣀⡀⠀⣀⣠⣍⡄⠀⠀ ⠀⣠⣤⣀\n" +
                            "     ⢸⡔⣿⣿⣿⣿⣿⣿⣿⣿⡿⠙⣿⣿⣿⣿⣷⡊⢼⠀⢙⡇⠀⣺⠀⣷⠀  ⠀⢸⡇⠀⠀⠀⣿⠋⠉⣿⡇ ⣿⣋⣈⣻⡇⠀⠀⠀⠀⠀ ⠀⣸⡏⠘⣷⠀⠀⣿⡏⠉⢹⡧⠀⠉⠉⣿⠀⠀⠈⠉⣿⡏⠉⠁ ⣿⠏⠉⣿⡇⢸⣿⢹⣯⢹⡿⠀⣿⣋⣈⣻⡇⠈⠉⣿⡏⠉⠁ ⠀⠉⠉⣿ ⠀ ⣾⠏⠉⠛⠇\n" +
                            "     ⠈⡖⡿⠿⣿⣿⣿⣿⣿⢹⢃⡆⢿⣿⣿⣿⣿⡇⢾⠤⠟⠓⠉⣹⢀⣹ ⠀⠀⢸⡇⠀⠀⠀⣿⠀⠀⣿⡇⠀⣿⡉⠉⣉⡁⠀⠀⠀⠀⠀⠀⢀⣿⠟⠛⢿⡆⠀⣿⡇⠀⠀⠀ ⠀⣀⣀⣿⣀⠀⠀ ⣿⣇⣀⡀⠀⣿⡀⠀⣿⡇⢘⣿⢸⣗⢸⣟⠀⣿⡉⠉⣉⡁⠀ ⠀⣿⣇⣀⡀⠀⣀⣀⣿⣃⣀⠀⣿⣄⠀⣠⡤\n" +
                            "     ⠀⡗⣿⣾⣶⣶⣦⡍⢡⣦⣼⣷⡘⢻⠻⠿⠿⣯⢼⠀⠀⠀⠀ ⢸⠟⢹⠀⠀ ⠘⠛⠀⠀⠀⠛⠃⠀⠛⠃⠀⠈⠛⠛⠋⠀⠀⠀⠀⠀⠀⠀⠘⠛⠀⠀ ⠘⠛⠀⠛⠃⠀⠀⠀⠀⠛⠛⠛⠛⠛⠀⠀ ⠈⠛⠛⠃⠛⠃⠀⠛⠃⠈⠛⠘⠛⠘⠛⠀⠈⠛⠛⠋⠀⠀⠀  ⠈⠛⠛⠃⠀⠛⠛⠛⠛⠛⠈⠙⠛⠋⠁\n" +
                            "     ⠀⡯⢼⣿⣿⣿⣿⡇⣼⣿⣿⣿⣇⣼⣿⣿⣿⡏⣼⢀⣠⣤⠀⢸⣠⠞\n" +
                            "     ⠀⣟⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⣼⠛⠋⣱⠀⣼⠁\n" +
                            "     ⠀⠉⠙⠓⠲⠾⠭⢿⣛⣻⡻⢿⡿⢿⡿⣿⡿⢒⢼⡆⠀⣺⡴⠊⠀⠀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⣀⠀⠀⠀⠀⠀ ⢠⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⣀⣀⣀⣀\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⢻⣿⠓⠒⠶⠬⠼⢼⠧⠚⠁⠀⠀⠀⠀ ⠀⣿⠉⠉⠉⠁⠀⣀⣀⣤⣄⠀⠀⢀⣠⣤⣀⠀⠀⢀⣠⣤⣀⠀⢠⣄⣿⣇⣠⡄ ⠀⣤⣠⣍⠀⠀⠀⢀⣠⣤⣀⠀⠀⣄⣀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡏⠉⢻⣧⠀⣄⣀⣤⣄⡀⠀⢀⣠⣄⣀⠀⠀⢀⣠⣄⣀⡄⠀⣠⣀⣠⣄⡀⠀⢀⣠⣤⣀⠀⢀⣤⣠⣀⣤⡀⠀\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⣻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⣿⣶⣶⣶⠆⠀⣿⡏⠈⢻⡷⠀⢛⣫⣌⣿⡇⢀⣿⠋⠈⠛⠃⠈⠉⣿⡏⠉⠁⠀⠉⠉⣿⠀⠀⢀⣿⠋⠉⣿⡇⠀⣿⡏⠈⣿⡇⠀⠀⠀⠀⠀⠀⣿⣧⣤⡾⠏⠀⣿⡏⠉⢹⡷⢄⣿⠏⠈⢻⡇⠀⣿⡏⠈⢿⡇⠀⣽⡏⠁⢹⡷⠀⢛⣋⣌⣽⡇⢰⣿⠈⣿⠈⣿⠀\n" +
                            "     ⠀⠀⠀⠀⠀⠀⢀⣤⢶⢻⡀⠉⠉⣼⢗⣤⡀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⣿⠄⠀⠀ ⠀⠀⣿⡇⠀⠀⠀⠰⣿⡁⢀⣿⡇⠀⣿⣄⠀⣤⡄⠀⠀ ⣿⣇⣀⡀⠀⣀⣀⣿⣀⣀⠈⣿⣄⢀⣿⡇⠀⣿⡆⠀⣿⡇⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀ ⠀⣿⡇⠀⠀⠀⠀ ⣿⣆⢀⣼⡇⠀⢿⣧⣠⣿⡇⠀⣹⡇⠀⠀⠀⠀ ⣿⡉⢀⣽⡇⢰⣿⠀⣿⠀⣿⠀\n" +
                            "     ⠀⠀⠀⠀⠀⢰⣿⢶⠎⠁⠉⡿⣷⠾⠷⣏⢾⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀ ⠀⠉⠁⠀⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠈⠹⠿⠉⠀⠀ ⠀⠈⠉⠉⠁⠀⠉⠹⠉⠉⠉⠀⠈⠹⠿⠉⠀⠀⠉⠁⠀⠉⠁⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀ ⠉⠁⠀⠀⠀⠀ ⠈⠹⠿⠉⠀⠀ ⠀⠉⠁⣾⡇⠀⠉⠁⠀⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠉⠀⠉⠀⠉⠀\n" +
                            "     ⠀⠀⠀⠀⠀⠈⠫⣻⣦⣄⠀⢧⣿⡄⠀⠈⢓⣌⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀               ⠛⠛⠋⠀\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀ ⠒⢟⣳⣮⣿⣧⣒⣯⡿⣞⠋⠁\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⡧⢸⣿⡍⢫⠉⣭⣯⡇⠀⠀⠀⠀⠀⠀⠀⠀⣶⣶⡆⠀⠀⣰⣶⣶⠀⠀⢰⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⢰⣶⣶⣶⣶⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀        ⠀⢰⣶⣶⡆\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⠻⠽⠧⠾⣿⣷⢤⡟⣭⣽⢻⡦⠀⠀⠀⠀ ⠀⠀⢼⣿⡇⠀⠀⣿⣿⣿⠀⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠘⠛⠛⠛⢻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀             ⠀⠀⠀⢸⣿⣿⡇\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⣿⠀⠉⠓⠚⠋⠀⠀⠀⠀⠀⠀⠀ ⠀⢸⣿⣷⠀⢠⣿⣟⣿⡆⠀⣼⣿⡇⠀⠀⠀⣠⣴⣶⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀ ⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣶⣦⣤⡀⠀⠀ ⠀⣶⣶⣆⣴⣶⣦⣀⣴⣶⣶⣄⠀⠀⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀ ⠀⢸⣿⣿⠇\n" +
                            "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⡏⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠈⣿⣿⠀⢸⣿⠀⣿⡇⠀⣿⣿⠇⠀⢠⣾⣿⡿⠋⠉⠙⢻⣿⣷⡄⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⠟⠛⠛⠻⣿⣿⣦⠀⠀⢀⣾⣿⡿⠟⠛⠛⢿⣿⣿⡄⠀⠀⣿⣿⡟⠉⢻⣿⣿⠉⠙⣿⣿⡆⠀⢀⣾⣿⡿⠛⠉⠙⠻⣿⣿⡄⠀⠀⢸⣿⣿⡀\n" +
                            "⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀⢸⣧⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⣿⣿⡆⣸⣿⠀⣿⣿⠠⣿⣿⠀⠀⣸⣿⣿⣀⣀⣀⣀⣀⣿⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠙⠛⠛⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⣃⣀⣀⣀⣀⣿⣿⣿⠀ ⢸⣿⣿⠄\n" +
                            "⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀⠀⠸⣽⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⢿⣿⣇⣿⡏⠀⢸⣿⢰⣿⣟⠀⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠟⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀   ⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠀⠀⢸⣿⣿⠀\n" +
                            "⠀⠀     ⠀⠀⠀⠀⠀⢀⣤⡤⠤⢤⡴⢿⣿⠲⡤⢄⣀⠀⠀⠀⠀⠀ ⠀⠀⠀⢹⣿⣿⣿⡇⠀⢸⣿⣿⣿⡇⠀⠀⢸⣿⣿⡀⠀⠀⠀⠀⣀⣀⡀⠀⠀ ⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣇⠀⠀⠀⠀⣶⣴⣶⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⢀⣿⣿⡿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⡇⠀⠀⠀⠀⣀⣀⣀\n" +
                            "⠀⠀     ⠀⠀⠀⢀⣴⣿⣟⡻⢷⣮⡵⠶⠶⢛⢳⣖⣚⠛⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠁⠀⠈⣿⣿⣿⡇⠀⠀⠈⢻⣿⣿⣦⣤⣴⣾⣿⡿⠃⠀⠀⠀⠀⠀⠈⢿⣿⣿⣶⣶⣶⣶⡆⠀⠻⣿⣿⣶⣶⣶⣾⣿⣿⠋⠀⠀⠀⢻⣿⣿⣶⣶⣶⣿⣿⡿⠃⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⠀⠻⣿⣿⣶⣤⣤⣾⣿⡿⠃⠀⠀⣶⣿⣿⡆\n" +
                            "⠀⠀⠀⠀     ⠀⠀⠉⠛⠿⢿⣯⣏⣴⣶⣸⡿⠭⢼⢿⣿⠃⠀⠀⠀⠀ ⠀ ⠀⠛⠛⠛⠀⠀⠀⠛⠛⠛⠁⠀⠀⠀⠀⠈⠛⠛⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠛⠛⠛⠃⠀⠀ ⠀⠈⠙⠛⠛⠛⠛⠋⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀⠀ ⠛⠛⠃⠀⠘⠛⠋⠀⠀⠛⠛⠃⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀ ⠀⠙⠛⠛⠃\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⢻⡿⠀⠀⠀⠈⣻⡃\n" +
                            "     ════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\n" +
                            "                                                            >>> Press [ENTER] to see the Main Menu <<<\n" +
                            "╰─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");
        while (scn.hasNextLine()) { // stops program until an [ENTER] is received
            int choice = 0;
            while (choice > 8 || choice < 1) {
                System.out.print("╭──────────────────────────────╮\n" + // displays user's choices
                                 "| ︵‿︵‿୨♡୧‿︵‿︵‿︵‿︵‿୨♡୧‿︵‿︵ |\n" +
                                 "|   OPERATION/ACTION OPTIONS   |\n" +
                                 "| ════════════════════════════ |\n" +
                                 "| 1. INPUT FRACTION 1  (❓)     |\n"+
                                 "| 2. INPUT FRACTION 2  (❓)     |\n" +
                                 "| 3. ADDITION          (➕)    |\n" +
                                 "| 4. SUBTRACTION       (➖)    |\n" +
                                 "| 5. MULTIPLICATION    (✖)     |\n" +
                                 "| 6. DIVISION          (➗)    |\n" +
                                 "| 7. REDUCTION         (🔻)    |\n" +
                                 "| 8. EXIT              (❌)    |\n" +
                                 "| ════════════════════════════ |\n" +
                                 "╰──────────────────────────────╯\n");
                System.out.print("  ︵‿︵‿୨♡୧‿︵‿︵\n" +
                                 "Enter Digit Choice: ");   // reads user's choice
                choice = scn.nextInt();
                if (choice > 8 || choice < 1) { // refuses values greater than 8 or less than 1
                    System.out.println("\n╭───────────────────────────────────────────╮" +
                                       "\n| ═════════════════════════════════════════ |" +
                                       "\n|     Invalid choice! Please try again.     |" +
                                       "\n| ═════════════════════════════════════════ |" +
                                       "\n╰───────────────────────────────────────────╯");
                }
            }
            switch (choice) {
                case 1:
                    System.out.print("╭───────────────────────────────────────────╮\n" +
                                     "|     SELECTED ACTION: INPUT FRACTION 1     |\n" +
                                     "| ═════════════════════════════════════════ |\n");
                    System.out.print("     Input Numerator: "); // reads user's input
                    numerator = scn.nextInt();
                    do {
                        System.out.print("     Input Denominator: "); // reads user's input
                        denominator = scn.nextInt();
                        if (denominator <= 0){ // refuses denominator values less than 1
                            System.out.println("\n╭───────────────────────────────────────────╮" +
                                               "\n| ═════════════════════════════════════════ |" +
                                               "\n|     Invalid input! Please try again.      |" +
                                               "\n| ═════════════════════════════════════════ |" +
                                               "\n| Note: Denominators have a positive value. |" +
                                               "\n╰───────────────────────────────────────────╯");
                        }
                    } while (denominator <= 0);

                    f1.setNumerator(numerator); // sets received values in Fraction Class
                    f1.setDenominator(denominator);
                    System.out.print("     You have entered: " + f1.toString() + " or " + df.format(f1.toDouble()) +
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 2:
                    System.out.print("╭───────────────────────────────────────────╮\n" +
                                     "|     SELECTED ACTION: INPUT FRACTION 2     |\n" +
                                     "| ═════════════════════════════════════════ |\n");
                    System.out.print("     Input Numerator: ");
                    numerator = scn.nextInt(); // reads user's input
                    do {
                        System.out.print("     Input Denominator: ");
                        denominator = scn.nextInt(); // reads user's input
                        if (denominator <= 0){ // refuses denominator values less than 1
                            System.out.println("\n╭───────────────────────────────────────────╮" +
                                               "\n| ═════════════════════════════════════════ |" +
                                               "\n|     Invalid input! Please try again.      |" +
                                               "\n| ═════════════════════════════════════════ |" +
                                               "\n| Note: Denominators have a positive value. |" +
                                               "\n╰───────────────────────────────────────────╯");
                        }
                    } while (denominator <= 0);

                    f2.setNumerator(numerator); // sets received values in Fraction Class
                    f2.setDenominator(denominator);
                    System.out.print("     You have entered: " + f2.toString() + " or " + df.format(f2.toDouble())+
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 3:
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                                     "|       SELECTED OPERATION: ADDITION        |\n" +
                                     "| ═════════════════════════════════════════ |\n" +
                                     "       Action: " + f1.toString() + " + " + f2.toString() +
                                     "\n       Sum: " + solve.add(f1.getNumerator(), f2.getNumerator(),
                                                        f1.getDenominator(), f2.getDenominator()) +
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 4:
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                                     "|      SELECTED OPERATION: SUBTRACTION      |\n" +
                                     "| ═════════════════════════════════════════ |\n" +
                                     "       Action: " + f1.toString() + " - " + f2.toString() +
                                     "\n       Difference: " + solve.subtract(f1.getNumerator(),
                                                               f2.getNumerator(), f1.getDenominator(),
                                                               f2.getDenominator()) +
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 5:
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                                     "|    SELECTED OPERATION: MULTIPLICATION     |\n" +
                                     "| ═════════════════════════════════════════ |\n" +
                                     "      Fraction 1: " + f1.toString() + " x " + f2.toString() +
                                     "\n       Product: " + solve.multiply(f1.getNumerator(), f2.getNumerator(),
                                                            f1.getDenominator(), f2.getDenominator()) +
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 6:
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                                     "|       SELECTED OPERATION: DIVISION        |\n" +
                                     "| ═════════════════════════════════════════ |\n" +
                                     "       Fraction 1: " + f1.toString() + " ÷ " + f2.toString() +
                                     "\n       Quotient: " + solve.divide(f1.getNumerator(), f2.getNumerator(),
                                                             f1.getDenominator(), f2.getDenominator()) +
                                     "\n| ═════════════════════════════════════════ |" +
                                     "\n| Press [ENTER] to return to the Main Menu. |" +
                                     "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // stops program until an [ENTER] is received
                    break;
                case 7:
                    int fNum = 0;
                    System.out.println("╭───────────────────────────────────────────╮\n" +  // displays entered fractions
                                     "|       SELECTED OPERATION: REDUCTION       |\n" +
                                     "| ═════════════════════════════════════════ |\n" +
                                     "       Fraction 1: " + f1.toString() +
                                     "\n       Fraction 2: " + f2.toString() +
                                     "\n| ═════════════════════════════════════════ |\n");
                            do {
                                System.out.print("         Enter Fraction number: ");   // reads user's choice
                                fNum = scn.nextInt();

                                    if (fNum == 1) {
                                        System.out.println("       Reduced Fraction: " +
                                                                                        solve.reduce(f1.getNumerator(),
                                                                                        f1.getDenominator()) +
                                                        "\n| ═════════════════════════════════════════ |" +
                                                        "\n| Press [ENTER] to return to the Main Menu. |" +
                                                        "\n╰───────────────────────────────────────────╯");
                                        enter = scn.nextLine(); // stops program until an [ENTER] is received
                                    }
                                     else if (fNum == 2) {
                                        System.out.println("       Reduced Fraction: " +
                                                                                        solve.reduce(f2.getNumerator(),
                                                                                        f2.getDenominator()) +
                                                "\n| ═════════════════════════════════════════ |" +
                                                "\n| Press [ENTER] to return to the Main Menu. |" +
                                                "\n╰───────────────────────────────────────────╯");
                                        enter = scn.nextLine(); // stops program until an [ENTER] is received
                                     }
                             } while (fNum < 1 || fNum > 2);    // refuses numbers less than 1 or greater than 2
                    break;
                case 8:
                    // displays before program halts
                    System.out.print("╭────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n" +
                                     "   ⠀⠀⠀⠀⠀⠀⠀⢀⡠⢶⢒⠲⡒⢖⠢⡄⠤⠠⠤⠤⢤⠤⡤⢤⣀⢀⡀⣀⣀⣀⣀⣀\n" +
                                     "⠀⠀⠀   ⠀⠀⡀⣴⠁⠀⢸⢌⣱⣾⣾⣷⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣥⣶⣠⢃⠾⠀⠀ ⡆⢰⡆ ⢀⣀⣀ ⠘⠒⡆⠀ ⢀⣴⣀⡀ ⢠⣛⠁ ⣀⣀⡀  ⢀⣀⣀⠀⠀⠀⠀⢀⣀⣀⠀ ⢀⣠⣀⠀ ⣀⣀⠀ ⢀⣀⣀⡀ ⣀⣠⡀ ⠀⣀⣀⠀ ⣀⣄⣀\n" +
                                     "   ⠀⠀⠀⡄⠊⠀⣇⡀⠀⢸⢆⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡜⠸⠀⠀ ⡟⢛⡇ ⢨⠗⢾ ⠀⠀⡇⠀ ⠀⢹⠀⠀⠀ ⢸⠀⠀  ⡏⢘⡇ ⢸⡁⣹⠀⠀⠀⠀⢸⡇⢸⡇ ⢸⠁⠙⠃ ⡏⠈⡷ ⢸⡁⣹ ⠀⣿⠀⠛ ⢨⡕⢺⡇ ⡇⢸⢸\n" +
                                     "   ⠀⠀⠀⡇⠀⠀⠋⠁⠀⢸⡌⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢲⠀⠀ ⠇⠘⠇ ⠘⠶⠺⠀ ⠀⠳⠶ ⠀⠘⠶⠆ ⠲⠾⠶ ⠀⠇⠘⠇ ⠘⠓⣻⠀⠀⠀⠀⢸⡗⠾⠁ ⠸⠀⠀  ⠀⠳⠶⠃ ⠘⠓⣻ ⠀⠻⠀⠀ ⠘⠷⠚⠃ ⠃⠸⠸⠀ ⠺⠂ ⠺⠂ ⠺\n" +
                                     "   ⠀⠀⡀⡇⠀⠀⢸⠂⢀⣸⡖⣿⣿⣿⣿⡏⣉⣀⣈⢻⣿⣿⣿⣿⠟⠉⠻⢿⣿⣿⣇⢺⠀⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀        ⠉⠁⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀ ⠀    ⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀  ⢠⣤⣤⠀\n" +
                                     "   ⢠⠊⠀⣇⡀⠤⠚⠈⠁⠘⡆⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣷⣶⣶⠶⣾⣿⣿⣏⠲⠀ ⠀⢀⣠⣤⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⣤⣤  ⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀    ⠀ ⢸⣿⡟⠀\n" +
                                     "   ⠸⠀⠀⡇⠀⠀⠀⠀  ⠀⠀⡇⣿⣿⣿⣿⣇⡈⠹⠿⢿⣿⣿⣿⡿⠿⠋⠀⣸⣿⣿⡧⣙ ⠀⢠⣿⡟⠋⠉⢻⣿⡆ ⠀⠀⠀⢀⣀⣀⠀⠀ ⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⣀⡀ ⠀ ⣿⣿⠀⠀⣿⣿⠀⣀⣀⠀⠀ ⠀⡀⢀⠀⠀⠀⠀⠀⢀⠀⠀⠀  ⢀⣀⣀⠀⠀⠀   ⢸⣿⡇⠀\n" +
                                     "   ⢰⡈⡤⡃⠀⠀⠀⣀⣠⠤⡧⣹⣿⣿⣿⣿⣷⣶⣀⣈⣉⠉⡉⠁⣠⣼⣿⣿⣿⣿⡗⢢⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀  ⢀⣶⣿⠿⠿⣿⣦⠀ ⠀⢠⣾⡿⠿⠿⣿⣆⠀⠀⣰⣿⡿⠿⢷⣿⣿⠀⠀⣿⣷⠾⠿⢿⣷⡄⠀⠹⣿⣆⠀ ⠀⢰⣿⡟ ⢀⣶⡿⠛⠻⣿⣦⠀  ⢸⣿⡇⠀\n" +
                                     "   ⢰⠀⠀⡁⠀⡖⣫⡥⢴⡶⡇⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢼⠀ ⢸⣿⡇⠀ ⣿⣿⣾⡇ ⢺⣿⡇⠀⠀ ⢸⣿⡇⠀⣿⣿⠀⠀⠀ ⢻⣿⠀⣿⣿⠀⠀  ⠀⣿⣿⠀⠀⣿⣿⠀⠀ ⠈⣿⣿⠀⠀⢻⣿⡄⢀⣿⡿⠀⢸⣿⣅⣀ ⣀⣸⣿⡇  ⢸⣿⡇⠀\n" +
                                     "   ⠈⠢⢀⢰⠀⡏⢛⣭⣭⢀⣟⠨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠜⡸⠀ ⢸⣿⡇⠀ ⠀⢰⣿⡇ ⢸⣿⡇⠀⠀ ⢸⣿  ⣿⣿⠀⠀ ⠀⣽⣿⠀⣿⣿⠀⠀  ⠀⣿⣿⠀⠀⣿⣿⠀⠀ ⠀⣿⣿⠀⠀⠀⢿⣷⣼⣿⠃⠀ ⢸⣿⡉⠉⠉⠉⠉⡁⠀⠀⠀⠀\n" +
                                     "⠀   ⠀⠀⢱⠀⡇⠘⣿⡻⠀⢯⠒⢭⢋⠟⣛⠻⡛⠿⠿⠿⠿⠿⠿⠿⢟⠻⣛⠻⡍⢎⣱⠀  ⠈⠻⣿⣶⣴⣾⡿⠃⠀ ⠘⢿⣷⣶⣶⣿⠟⠀⠀⠘⢿⣷⣦⣶⣿⠟⠀⠀⠻⣿⣶⣶⡾⣿⣿⠀ ⠀⣿⡟⢶⣴⣾⣿⠇⠀⠀⠀⠘⣿⣿⠇⠀⠀⠀⠈⢿⣷⣦⣴⣾⠟⠁  ⢾⣿⣿⠄\n" +
                                     "⠀   ⠀⠀⠸⠠⠧⠔⢚⡓⣉⣉⣉⣉⣉⣉⣉⣩⠙⡛⣩⣉⣉⣙⣉⣉⣉⠹⠴⠗⠚⠒⠉⠀⠀ ⠀ ⠀⠉⠉⠁⠀⠀⠀⠀⠀  ⠀⠉⠉⠀⠀⠀⠀⠀  ⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠉⠁ ⠀⠁⠉⠀⠀⠉⠁ ⠀⠉⠉⠀⠀⠀⠀⠀⢠⣿⡟⠀⠀⠀⠀⠀⠀ ⠈⠉⠉⠀⠀⠀⠀    ⠁\n" +
                                     "⠀⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                 ⠀⠚⠛⠁\n" +
                                     "╰────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");
                            System.exit(0); // exits program
            }
        }
    }
}