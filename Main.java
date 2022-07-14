package bus_managment_system;

import javax.crypto.spec.PSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String name, email, street, city, state, password, source = "", destination = "";
    static long phone = 0;
    static SignupLogin signupLogin = new SignupLogin();

    public static void main(String[] args) {
        mainPage();
    }
public static void mainPage(){
    int choice;
    BusOperations busOperations = new BusOperations();
    System.out.println("################  Bus Reservation SYSTEM  ###############");
    System.out.println("##                 Press 1 for SignUp:                 ##");
    System.out.println("##                 Press 2 for Login :                 ##");
    System.out.println("##                 Press 3 for Bus Details:            ##");
    System.out.println("#########################################################");
    choice = sc.nextInt();
    switch (choice) {
        case 1:
            Signup();
            break;
        case 2:
            Login();
            break;
        case 3:
            busOperations.busDeatails();
            mainPage();
            break;
        default:
            System.out.println("Wrong Choice");
    }
}


    public static void Signup() {
        System.out.println("---------------Sign Up Page-------------");
        System.out.println("Enter name : ");
        name = sc.next();
        System.out.println("Enter email : ");
        email = sc.next();
        System.out.println("Enter Phone : ");
        phone = sc.nextLong();
        System.out.println("Enter street : ");
        street = sc.next();
        System.out.println("Enter city : ");
        System.out.println();
        city = sc.next();
        System.out.println("Enter state : ");
        state = sc.next();
        System.out.println("Enter password : ");
        password = sc.next();
        System.out.println(signupLogin.signup(name, phone, email, state, city, street, password));
        mainPage();
    }


    public static void Login() {
        System.out.println("---------------Login Page---------------");
        System.out.println("Enter email :");
        email = sc.next();
        System.out.println("Enter password :");
        password = sc.next();

        String flag = signupLogin.login(email, password);
        System.out.println(flag);
        if (flag.contains("Sucessfuly login")) {
            System.out.println("---------------PLease Choose Your Way---------------");
            System.out.println("Enter Source :");
            source = sc.next();
            System.out.println("Enter Destination :");
            destination = sc.next();
            BusOperations busOperations = new BusOperations();
            busOperations.searchBus(source, destination);
            mainPage();
        }

    }
}
