package exceptions;

public class DayNotCorresponding extends Exception{

    int penultimateNumber;
    int monthNumber;

    public DayNotCorresponding(int idPenultimateNumber, int monthNumber) {
        super("No le corresponde el día de acuerdo a su penúltimo número de cédula y día del mes");
        this.penultimateNumber = idPenultimateNumber;
        this.monthNumber = monthNumber;
    }//End DayNotCorresponding

    public int getPenultimateNumber() {
        return penultimateNumber;
    }//End getIdLastNumber

    public int getMonthNumber() {
        return monthNumber;
    }//End getMonthNumber

}//End DayNotCorresponding class