import java.util.Scanner;

public class Hangman {

    public static String get_word() {

        String word = "TEST";
        return word;
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
           displayed_word += displayed_letters[i];
        }

        System.out.println("-".repeat(100));
        System.out.println("Word: " +displayed_word+
                "  Guess: " +num_guesses+
                "  Wrong: " +num_wrong+
                "  Tried: " +guessed_letters);
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

        while (num_wrong < 10 && remaining_letters > 0) {

            String guess = get_letter(guessed_letters);
            System.out.println(guess);

            boolean x = !word.contains(guess);
            guessed_letters += guess;

            System.out.println(x);
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

        System.out.println("HANGMAN!");

        while (again.equals("y")) {
            play_game();
            System.out.println("\nDo you want to play again (y/n)?: ");
            again = inputDevice.nextLine();
            }
        System.out.println("Bye!");
        }
    }