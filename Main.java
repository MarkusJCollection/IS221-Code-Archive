import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Program that uses a user demographics class
        //to set a user's name, age, and work duration.

        //Definition of classes used.
        UserDemographic userDemographic = new UserDemographic();

        /*
        Scanner sc = new Scanner(System.in);


            //Asking of user name and setting.
        System.out.println("What is your name? ");
        userDemographic.userName(sc.nextLine());

            //Asking of user age and setting.
        System.out.println("What is your age? ");
        userDemographic.userAge(Integer.parseInt(sc.nextLine()));

            //Asking of duration of work at the company
            //in years and months.
        System.out.println("How long have you been working for the company?");
        System.out.println("(years): ");
        userDemographic.userWorkDurationYRS(Integer.parseInt(sc.nextLine()));
        System.out.println("(months): ");
        userDemographic.userWorkDurationMTH(Integer.parseInt(sc.nextLine()));


        */


            //Printing of object items.
        System.out.println(userDemographic);
    }
}