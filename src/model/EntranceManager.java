package model;

import exceptions.DayNotCorrespondingException;
import exceptions.UnderAgeException;

import java.util.ArrayList;
import java.util.List;

public class EntranceManager {

    private int countAttempts;
    private List<Person> registeredPersons;

    public EntranceManager() {
        countAttempts = 0;
        registeredPersons = new ArrayList<>();
    }//End Constructor

    public void setCountAttempts(int countAttempts) {
        this.countAttempts = countAttempts;
    }//End setCountAttempts

    public int getCountAttempts() {
        return  countAttempts;
    }//End getCountAttempts

    public void setRegisteredPersons(List<Person> registeredPersons) {
        this.registeredPersons = registeredPersons;
    }//End setRegisteredPersons

    public List<Person> getRegisteredPersons() {
        return registeredPersons;
    }//End getRegisteredPersons

    public void registerPerson(String idT, String idNumber, int monthNumber) throws DayNotCorrespondingException, UnderAgeException {
        setCountAttempts(getCountAttempts()+1);
        IdType idType = IdType.valueOf(idT);
        if(idType == IdType.TI) {
            throw new UnderAgeException();
        }//End if
        int penultimateIdNumber = (idNumber.length() == 1)?Integer.parseInt(idNumber):Integer.parseInt(String.valueOf(idNumber.charAt(idNumber.length()-2)));
        if((penultimateIdNumber%2 == 0 && monthNumber%2 == 0) || (penultimateIdNumber%2 != 0 && monthNumber%2 != 0)) {
            throw new DayNotCorrespondingException(penultimateIdNumber, monthNumber);
        }//End if
        Person person = new Person(idType, idNumber);
        registeredPersons.add(person);
    }//End registeredPerson

}//End EntranceManager class