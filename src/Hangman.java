import java.util.Scanner;

public class Hangman {

    public static void get_word() {

    }

    public static void draw_screen(int num_wrong, int num_guesses, String guessed_letters, String displayed_word) {

        System.out.println("-".repeat(100));
        System.out.println("Word: " +displayed_word+
                "  Guess: " +num_guesses+
                "  Wrong: " +num_wrong+
                "  Tried: " +guessed_letters);
    }

    public static void add_spaces() {

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

        Word random_word = new Word("TEST", 4);

        String word = random_word.getWord();
        int length = random_word.getLength();

        int remaining_letters = length;
        String displayed_word ="_".repeat(length);

        int num_wrong = 0;
        int num_guesses = 0;
        String guessed_letters = "";

        draw_screen(num_wrong, num_guesses, guessed_letters, displayed_word);

        while (num_wrong < 10 && remaining_letters > 0) {

            String guess = get_letter(guessed_letters);

            guessed_letters += guess;

            int x = word.indexOf(guess);
            System.out.println(x);
        }

            num_guesses += 1;

            draw_screen(num_wrong, num_guesses, guessed_letters, displayed_word);

            System.out.println("G" +num_guesses);
            System.out.println("R" +remaining_letters);

            System.out.println("-".repeat(100));
            if (remaining_letters == 0) {
                System.out.println("You guessed the word in " +num_guesses+ " guesses.");
            }
            else {
                System.out.println("Sorry, you lost.");
                System.out.println("The word was: " +word);
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