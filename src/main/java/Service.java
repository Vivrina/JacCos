import java.io.*;
import java.util.TreeSet;

public class Service {
    public TreeSet<String> traits;
    public TreeSet<String> allTraits;

    public Service() {
        this.traits = new TreeSet<>();
        this.allTraits = getAllTraits();
    }

    TreeSet<String> getAllTraits() {
        TreeSet<String> characterTraits = new TreeSet<String>();
        characterTraits.addAll(Types.CHOLERIC.traits);
        characterTraits.addAll(Types.MELANCHOLIC.traits);
        characterTraits.addAll(Types.SANGUINE.traits);
        characterTraits.addAll(Types.PHLEGMATIC.traits);
        return characterTraits;
    };

    void writeCharacterTraits() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/character.txt"));
            for (String trait : allTraits) {
                bw.write(trait);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readCharacterTraits() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/character.txt"));
            String s;
            while ((s = br.readLine())!=null) {
                if (allTraits.contains(s)) {
                    traits.add(s);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
