import java.util.List;
import java.util.function.Predicate;

public class CheckingClass {

    public Integer printPersons(List<Person> roster, CheckPerson tester) {
        Integer counter = 0;
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
                counter++;
            }
        }
        return counter;
    }

    class Tester implements CheckPerson {
        Predicate predicate;

        public Tester(Predicate predicate) {
            this.predicate = predicate;
        }
        @Override
        public boolean test(Person p) {
            return predicate.test(p);

        }
    }
}
