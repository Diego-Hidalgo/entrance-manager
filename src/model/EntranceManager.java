package model;

import exceptions.DayNotCorresponding;
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

    public void registerPerson(String idNumber, String idT, int monthDay) throws DayNotCorresponding, UnderAgeException {
        setCountAttempts(getCountAttempts()+1);
        IdType idType = IdType.valueOf(idT);
        if(idType == IdType.TI) {
            throw new UnderAgeException();
        }//End if
        int penultimateIdNumber = Integer.parseInt(String.valueOf(idNumber.charAt(idNumber.length()-2)));
        if((penultimateIdNumber%2 == 0 && monthDay%2 == 0) || (penultimateIdNumber%2 != 0 && monthDay%2 != 0)) {
            throw new DayNotCorresponding(penultimateIdNumber, monthDay);
        }//End if
        Person person = new Person(idNumber, idType);
        registeredPersons.add(person);
    }//End registeredPerson

}//End EntranceManager class