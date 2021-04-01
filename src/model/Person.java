package model;

public class Person {

    private String idNumber; //Identification number of the person
    private IdType idType; //Identification type of the person

    public Person(String idNumber, IdType idType) {
        this.idNumber = idNumber;
        this.idType = idType;
    }//End constructor

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }//End setIdNumber

    public String getIdNumber() {
        return idNumber;
    }//End getIdNumber

    public void setIdType(IdType idType) {
        this.idType = idType;
    }//End setIdType

    public IdType getIdType() {
        return idType;
    }//End getIdType

}//End Person class