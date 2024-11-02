import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    //Definition of variables, starting with the Scanner
        Scanner sc = new Scanner(System.in);

    //Definition of day numbers, then names. monthNumbers not used, but still included.
        int dateNumbers;
        int monthNumbers;
        int yearNumbers;
        String dayName;
        String monthName;

    //Definition of time variables.
        int hour;
        int minute;
        String timeOfDay;

    //Definition of pay variables.
        double payRate;
        int hoursWorked;
        double totalPay;



    //Beginning of lists of strings asking questions
    //such as the day's date, and other relevant items.

    //Asking of the day numbers.
        System.out.print("What is today's date in DD/MM/YYYY?\n (DD): ");
        dateNumbers = sc.nextInt();
        sc.nextLine();

        System.out.print(" (MM): ");
        monthNumbers = sc.nextInt();
        sc.nextLine();

        System.out.print(" (YYYY): ");
        yearNumbers = sc.nextInt();
        sc.nextLine();

    //Asking of day names.
        System.out.print("\n What day of week is it? (ex. Sunday): ");
        dayName = sc.nextLine();

        System.out.print("What is the month name? (ex. January): ");
        monthName = sc.nextLine();

    //Asking of time.
        System.out.print("\nWhat hour is it? ");
        hour = sc.nextInt();
        sc.nextLine();

        System.out.print("What minute is it? ");
        minute = sc.nextInt();
        sc.nextLine();

        System.out.print("Is it before or after noon? (A.M./P.M.): ");
        timeOfDay = sc.nextLine();

    //Asking of pay.
        System.out.print("\nWhat is your pay per hour?");
        payRate = sc.nextDouble();
        sc.nextLine();

        System.out.print("How many hours have you worked? ");
        hoursWorked = sc.nextInt();
        sc.nextLine();



    //Printing of date in two formats, and pay from the answers asked above.
        System.out.print(
                "\n\nUSA Format\n"
        );
        System.out.printf("%s, %s %02d, %d: %d:%02d %s \n",
                dayName,monthName,dateNumbers,yearNumbers,hour,minute,timeOfDay
        );

        System.out.println(
                "UK Format"
        );
        System.out.printf("%s, %d %s %d %d:%02d %s\n",
                dayName,dateNumbers,monthName,yearNumbers,hour,minute,timeOfDay
                );

    //Pay displayed in floating point format, with multiplication as needed.
        totalPay = ((payRate*100)*hoursWorked)/100;
        System.out.printf("\nTotal Pay: %.2f",totalPay);
    }
}
