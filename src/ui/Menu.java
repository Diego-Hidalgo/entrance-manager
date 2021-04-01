package ui;

import exceptions.DayNotCorrespondingException;
import exceptions.UnderAgeException;
import model.EntranceManager;
import java.io.*;
import java.time.LocalDate;

public class Menu {

    //Menu options
    private final static int REGISTER_PERSON = 1;
    private final static int CONSULT_ATTEMPTS = 2;
    private final static int EXIT = 3;

    //read and print
    private BufferedReader br;
    private BufferedWriter bw;

    private EntranceManager manager;

    public Menu() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        this.manager = new EntranceManager();
    }//End constructor

    public void showMenu() throws IOException {
        bw.write("¿Qué desea hacer? \n [1] Registrar a una persona " +
                "\n [2] Consultar intentos de ingreso \n [3] Salir \n Opcion: ");
        bw.flush();
    }//End showMenu

    public int readOption() throws IOException {
        int option = Integer.parseInt(br.readLine());
        return option;
    }//End readOption

    public void registerPerson() throws IOException {
        bw.write("Tipo de documento (Solo las iniciales): ");
        bw.flush();
        String idType = br.readLine().toUpperCase();
        while(!idType.equals("TI") && !idType.equals("CC") && !idType.equals("PP") && !idType.equals("CE")) {
            bw.write("Tipo de documento inválido. Los tipos válidos son: \nTI-Tarjeta de Identidad " +
                    "\nCC-Cédula de Ciudadanía \nPP-Pasaporte \nCE-Cédula de Extranjería \n: ");
            bw.flush();
            idType = br.readLine().toUpperCase();
        }//End while
        bw.write("Número de documento: ");
        bw.flush();
        String idNumber = br.readLine();
        int monthNumber = LocalDate.now().getDayOfMonth();
        try {
            manager.registerPerson(idType, idNumber, monthNumber);
            bw.write("Ingreso registrado correctamente \n");
            bw.flush();
        } catch (UnderAgeException uae) {
            bw.write("No se pudo registrar el ingreso." + uae.getMessage() + "\n");
            bw.flush();
        } catch (DayNotCorrespondingException dne) {
            bw.write(dne.getMessage() + "\n#Día del mes: " + dne.getMonthNumber() +
                    "\nPenúltima cifra del documento: " + dne.getPenultimateNumber() + "\n");
            bw.flush();
        }
    }//End registerPerson

    public void consultAttempts() throws IOException {
        bw.write("Intentos de ingreso totales: " + manager.getCountAttempts() + "\n");
        bw.flush();
    }//End consultAttempts

    public void doOperation(int option) throws IOException {
        switch(option) {
            case REGISTER_PERSON:
                registerPerson();
                break;
            case CONSULT_ATTEMPTS:
                consultAttempts();
                break;
            case EXIT:
                break;
            default:
                bw.write("Opción inválida");
                bw.flush();
        }//End switch
    }//End doOperation

    public void startProgram() throws IOException {
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while(option != 3);
        bw.close();
        br.close();
    }//End startProgram

}//End menu class