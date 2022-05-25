import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
//       service.writeCharacterTraits();
        service.readCharacterTraits();

        Person person = new Person(new ArrayList<>(service.traits));

        Algorithm.getCharacterType(person);
    }
}
