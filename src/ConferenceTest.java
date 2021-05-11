import jdk.jshell.PersistentSnippet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConferenceTest {
    private static int  capacity=10;
    private Conference conference=new Conference(capacity);
    @Test
    public void calculatePriceForAffiliate(){
        Person affiliate=new Person("Dijana","Sazdevska",Role.AFFILIATE,25);
        conference.addAttendeeToConference(affiliate);
        assertEquals((1 - Conference.AFFILIATE_DISCOUNT) * Conference.TICKET_PRICE,conference.calculateTotalPricePaid(),0);


    }
    @Test
    public void calculatePriceForFacultyEmployee(){
        Person employee=new Person("Dijana","Sazdevska",Role.FACULTY_EMPLOYEE,25);
        conference.addAttendeeToConference(employee);
        assertEquals((1 - Conference.FACULTY_EMPLOYEE_DISCOUNT) * Conference.TICKET_PRICE,conference.calculateTotalPricePaid(),0);


    }
    @Test
    public void calculatePriceForOther(){
        Person other=new Person("Dijana","Sazdevska",Role.OTHER,25);
        conference.addAttendeeToConference(other);
        assertEquals(Conference.TICKET_PRICE,conference.calculateTotalPricePaid(),0);
    }
    @Test
    public void calculatePriceForStudent(){
        Person student=new Person("Dijana","Sazdevska",Role.STUDENT,25);
        conference.addAttendeeToConference(student);
        assertEquals(0,conference.calculateTotalPricePaid(),0);
    }

}
