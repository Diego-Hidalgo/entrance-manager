package model;

public class Person {

    private String idNumber; //Identification number of the person
    private IdType idType; //Identification type of the person

    public Person(IdType idType, String idNumber) {
        this.idType = idType;
        this.idNumber = idNumber;
    }//End constructor

    public void setIdType(IdType idType) {
        this.idType = idType;
    }//End setIdType

    public IdType getIdType() {
        return idType;
    }//End getIdType

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }//End setIdNumber

    public String getIdNumber() {
        return idNumber;
    }//End getIdNumber

}//End Person class