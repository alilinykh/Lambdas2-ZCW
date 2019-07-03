import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class CheckingClassTest {
    CheckingClass checkingClass = new CheckingClass();
    List<Person> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        Person p1 = new Person("Alex", LocalDate.MAX, Person.Sex.MALE, "asdf@mail.com");
        Person p2 = new Person("Bob", LocalDate.MAX, Person.Sex.MALE, "1@mail.com");
        Person p3 = new Person("Caleb", LocalDate.MAX, Person.Sex.MALE, "asdf@mail.com");
        Person p4 = new Person("Donna", LocalDate.MAX, Person.Sex.FEMALE, "asdf@mail.com");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
    }

    @Test
    public void printPersons() {

        Predicate<Person> predicate = p ->
                p.getName().equals("Alex");

        CheckPerson checkPerson = checkingClass.new Tester(predicate);
        Integer actual = checkingClass.printPersons(list,checkPerson);
        Integer expected = 1;

        Assert.assertEquals(expected,actual);


    }
}