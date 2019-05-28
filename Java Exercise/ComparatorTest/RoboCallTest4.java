import java.util.List;
import java.util.function.Predicate;

public class RoboCallTest4 {
    public static void main(String[] args) {
        List<Person> pl = Preson.createShortList();
        RoboContactLambda robo = new RoboContactLambda();

        // Predicates
        Predicate<Person> allDrivers = p -> p.getAge() >= 16;

        Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MAIL;
        Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        System.out.println("");
    }
}