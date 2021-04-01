package ui;

import model.EntranceManager;

import java.io.*;

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

    public void registerPerson() {

    }//End registerPerson

    public void consultAttempts() {

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
    }//End startProgram

}//End menu class