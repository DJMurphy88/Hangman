import java.util.Scanner;

public class Hangman {

    public static String get_word() {

        return "TEST";
    }

    public static String[] hidden_letters(String[] letters) {
        String[] hidden = new String[letters.length];
        for (int i = 0; i < letters.length; i++) {
           hidden[i] = "_";
        }
        return hidden;
    }

    public static void draw_screen(int num_wrong, int num_guesses, String guessed_letters, String[] displayed_letters) {

        String displayed_word = "";

        for (int i =0; i <= displayed_letters.length - 1; i++) {
           displayed_word += displayed_letters[i] + " ";
        }

        System.out.println("-".repeat(100));
        System.out.println("Word: " +displayed_word+
                "  Guesses: " +num_guesses+
                "  Wrong: " +num_wrong+
                "  Tried: " +guessed_letters);
    }

    public static void draw_gallows(int num_wrong) {
        String head = " ";
        String body = " ";
        String r_arm = " ";
        String l_arm = " ";
        String r_leg = " ";
        String l_leg = " ";

        switch (num_wrong) {
            case 6:
                l_leg = "\\";
            case 5:
                r_leg = "/";
            case 4:
                l_arm = "\\";
            case 3:
                r_arm = "/";
            case 2:
                body = "|";
            case 1:
                head = "O";
        }
        System.out.println("   __");
        System.out.println("  |/ |");
        System.out.println("  |  "+head);
        System.out.println("  | "+r_arm+body+l_arm);
        System.out.println("  |  "+body);
        System.out.println("  | "+r_leg+" "+l_leg);
        System.out.println(" _|_______");
        System.out.println("|/       \\|");
    }

    public static String get_letter(String guessed_letters) {
        Scanner inputDevice = new Scanner(System.in);

        while (true) {
            System.out.println("guess a letter.");
            String guess = inputDevice.nextLine();
            guess = guess.toUpperCase();

            if (guess.equals("") || guess.length() > 1) {
                System.out.println("Invalid entry. Please enter only one letter.");
            }
            else if (guessed_letters.contains(guess)) {
                System.out.println("You already guessed that letter");
            }
            else {
                return guess;
            }
        }
    }

    public static void play_game() {
        String word = get_word();

        String[] letters = word.split("");
        String[] displayed_letters = hidden_letters(letters);

        int remaining_letters = letters.length;
        int num_wrong = 0;
        int num_guesses = 0;
        String guessed_letters = "";

        draw_screen(num_wrong, num_guesses, guessed_letters, displayed_letters);

        while (num_wrong < 6 && remaining_letters > 0) {

            String guess = get_letter(guessed_letters);

            boolean x = !word.contains(guess);
            guessed_letters += guess + " ";

            if (!x) {
                for (int i = 0; i <= letters.length - 1; i++) {
                    if (guess.equals(letters[i])) {
                        displayed_letters[i] = letters[i];
                        remaining_letters -= 1;
                    }
                }
            }
            else {
                num_wrong += 1;
            }
            num_guesses += 1;

            draw_screen(num_wrong, num_guesses, guessed_letters, displayed_letters);

            System.out.println("-".repeat(100));
        }

        if (remaining_letters == 0) {
            System.out.println("You won in " +num_guesses+ " guesses.");
        }
        else {
            System.out.println("You lost. the correct word was: " +word);
        }
    }

    public static void main(String[] args) {

        Scanner inputDevice = new Scanner(System.in);

        String again = "y";

        System.out.println("-".repeat(100));
        System.out.println("HANGMAN!");

        while (again.equals("y")) {
            play_game();
            System.out.println("\nDo you want to play again (y/n)?: ");
            again = inputDevice.nextLine();
            }
        System.out.println("Bye!");
        }
    }