package model;

import exceptions.DayNotCorresponding;
import exceptions.UnderAgeException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EntranceManagerTest {

    private EntranceManager myManager;

    private void setupScenary1() {
        myManager = new EntranceManager();
    }//End setupScenary1

    @Test
    public void testRegisterPerson1() {
        setupScenary1();
        String idNumber = "1006492806";
        String idT = "CC";
        int monthDay = 3;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
            assertEquals(1, myManager.getRegisteredPersons().size());
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number an month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
    }//End testRegisterPerson1

    @Test
    public void testRegisterPerson2() {
        setupScenary1();
        String idNumber = "1056678657";
        String idT = "PP";
        int monthDay = 4;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
            assertEquals(1, myManager.getRegisteredPersons().size());
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number an month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
    }//End testRegisterPerson3

    @Test
    public void testRegisterPerson3() {
        setupScenary1();
        String idNumber = "1056122374";
        String idT = "CE";
        int monthDay = 2;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
            assertEquals(1, myManager.getRegisteredPersons().size());
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number an month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
    }//End testRegisterPerson4

    @Test
    public void testRegisterPerson4() {
        setupScenary1();
        String idNumber = "1006495762";
        String idT = "TI";
        int monthDay = 4;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number an month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
        assertEquals(0,myManager.getRegisteredPersons().size());
    }//End testRegisterPerson2

    @Test
    public void testRegisterPerson5() {
        setupScenary1();
        String idNumber = "1006482955";
        String idT = "CE";
        int monthDay = 3;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number and month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
        assertEquals(0,myManager.getRegisteredPersons().size());
    }//End testRegisterPerson3

    @Test
    public void testRegisterPerson6() {
        setupScenary1();
        String idNumber = "1004375842";
        String idT = "CC";
        int monthDay = 4;
        try{
            myManager.registerPerson(idNumber, idT, monthDay);
        } catch (DayNotCorresponding dnc) {
            fail("Day not corresponding according to the penultimate id number and month day");
        } catch (UnderAgeException uae) {
            fail("An under-age person cannot be registered");
        } finally {
            assertEquals(1, myManager.getCountAttempts());
        }//End finally
        assertEquals(0,myManager.getRegisteredPersons().size());
    }//End testRegisterPerson4

}//End EntranceManagerTest