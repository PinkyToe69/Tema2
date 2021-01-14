package ro.mta.se.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * clasa pentru testul unitar
 *
 * @author Comandasu Andrei
 */
class OraseTest {

    @Test
    void test() {

        Orase c=new Orase(new OraseInterface("1","2","3","4"));
        assertEquals(c.getNm(),"1");
        assertEquals(c.getLat(),2);
        assertEquals(c.getLon(),3);
        assertEquals(c.getCountryCode(),"4");
    }


}