import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word {

    private ArrayList<String> words = new ArrayList<>();

    public ArrayList<String> load_file() {

        try {
            File word_list = new File("src/Word_list.txt");
            Scanner file_reader = new Scanner(word_list);
            while (file_reader.hasNextLine()) {
                words.add(file_reader.nextLine());
            }
            file_reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        return words;
    }

    public String getWord() {
        words = load_file();
        int i = (int) (Math.random() * ((words.size())));
        String word = words.get(i);
        return word;
    }

    public Word () {

   }
}