import java.util.Scanner;


public class Main {

    static void displayWelcomeMsg(){
    //A function that will display a welcome message when called.
        System.out.println("Welcome to the pay calculator section of the HR app!");
    }

    static void displayExitMsg(){
    //A function that will display an exit message when called.
        System.out.println("Goodbye and thank you for using our pay calculator app.");
    }

    static double calcGrossPay(double payRate, int hoursWorked){
    //A function with input parameters of a pay rate and # of hours worked
    //that returns a calculated gross pay.
        return (((payRate*100)*hoursWorked)/100);
    }

    static String formatDateString(String dayName, String monthName,
                                   int dateNumbers, int yearNumbers,
                                   int hour, int minute){
    //A function that displays the date in a formatted string in U.S. style.
    //Requires the inputs of the day name, month name, date number, year number,
    //the hour, the minute, and whether it is A.M. or P.M.
        return String.format("%s, %s %d, %d: %d:%02d",
                dayName,monthName,dateNumbers,
                yearNumbers,hour,minute);
    }


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

    //Definition of pay variables.
        double payRate;
        int hoursWorked;
        double totalPay;

        displayWelcomeMsg();



    //Beginning of lists of strings asking questions
    //such as the day's date, and other relevant items.

    //Asking of day numbers.
        System.out.print("What is today's date in DD/MM/YYYY?\n (DD): ");
        dateNumbers = Integer.parseInt(sc.nextLine());

        System.out.print(" (MM): ");
        monthNumbers = Integer.parseInt(sc.nextLine());

        System.out.print(" (YYYY): ");
        yearNumbers = Integer.parseInt(sc.nextLine());

    //Asking of day names.
        System.out.print("\n What day of week is it? (ex. Sunday): ");
        dayName = sc.nextLine();

        System.out.print("What is the month name? (ex. January): ");
        monthName = sc.nextLine();

    //Asking of time.
        System.out.print("\nWhat hour is it? (24hr): ");
        hour = Integer.parseInt(sc.nextLine());

        System.out.print("What minute is it? ");
        minute = Integer.parseInt(sc.nextLine());


    //Asking of pay.
        System.out.print("\nWhat is your pay per hour?");
        payRate = Double.parseDouble(sc.nextLine());

        System.out.print("How many hours have you worked? ");
        hoursWorked = Integer.parseInt(sc.nextLine());



    //Printing the date in U.S. format using function defined above.
        String date = formatDateString(dayName, monthName, dateNumbers, yearNumbers,
                                        hour, minute);
        System.out.println("\n"+date);


    //Pay displayed in a rounded floating point format, using function defined previously.
        totalPay = calcGrossPay(payRate,hoursWorked);
        System.out.printf("\nTotal Pay: %.2f\n",totalPay);


    //Last line in program, and displays an exit message showing that there's nothing else.
        displayExitMsg();
    }
}