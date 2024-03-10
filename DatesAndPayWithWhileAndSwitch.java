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
    //that returns a calculated gross pay or zero if the input is invalid.
        if(payRate>0 && payRate<=120 && hoursWorked>=0 && hoursWorked<=15){
            return (((payRate*100)*hoursWorked)/100);
        }else{
            return 0;
        }
    }

    static String timeOfDayFinder(int hour,int minute){
        if(hour>12) {
            hour -= 12;
            return String.format("%d:%02d P.M.", hour, minute);
        }else if(hour == 12){
            return String.format("%d:%02d P.M.",hour, minute);
        }else{
            return String.format("%d:%02d A.M.",hour,minute);
        }
    }

    static String formatDateString(String dayName, String monthName,
                                   int dateNumbers, int yearNumbers,
                                   String timeOfDay, String region){
    //A function that displays the date in a formatted string in U.S. style.
    //Requires the inputs of the day name, month name, date number, year number,
    //the hour, the minute, and whether it is A.M. or P.M.
        switch(region){
            case "UK": case "England": case "European":
                //UK Format: Sunday, 4 February 2024 11:59 PM
                return String.format("UK Format: %s, %d %s %d %s",
                        dayName,dateNumbers,monthName,
                        yearNumbers,timeOfDay);
            case "Japan": case "JPN": case "Iraq": case "Korea":
                //Japanese Format: 2024 February 4 (Sunday) 11:59 PM
                return String.format("Japan Format: %d %s %d (%s) %s",
                        yearNumbers,monthName,dateNumbers,
                        dayName,timeOfDay);
            default:
                //USA Format: Sunday, February 4, 2024: 11:59 PM
                return String.format("USA Format: %s, %s %d, %d: %s",
                        dayName,monthName,dateNumbers,
                        yearNumbers,timeOfDay);
        }
    }


    static void programTesting(){
        System.out.print("\n\n\n");
        //Complete copy of main program that just allows quick testing.
        Scanner sc = new Scanner(System.in);

        //Definition of day numbers, then names. monthNumbers not used, but still included.
        int dateNumbers;
        int monthNumbers;
        int yearNumbers;
        String dayName;
        String monthName;

        //Definition of time variables + region.
        int hour;
        int minute;
        String region;

        //Definition of pay variables.
        double payRate;
        int hoursWorked;
        double totalPay;

        //Numbers to change
        dateNumbers = 2;
        monthNumbers = 3;
        yearNumbers = 2024;
        dayName = "Saturday";
        monthName = "March";

        hour = 13;
        minute = 1;
        region = "Japan";

        payRate = 13.54;
        hoursWorked = 5;


        //Printing the date in U.S. format using function defined above.
        String date = formatDateString(dayName, monthName, dateNumbers, yearNumbers,
                timeOfDayFinder(hour,minute),region);
        System.out.println("\n"+date);


        //Pay displayed in a rounded floating point format, using function defined previously.
        totalPay = calcGrossPay(payRate,hoursWorked);
        System.out.printf("Total Pay: %.2f\n\n",totalPay);

        System.out.print("\n\n\n\n");
    }





    //$$$$#####$$$$$$######$$$$$$#####$$$$$###
    //$$$$#####$$$$$$######$$$$$$#####$$$$$###

    public static void main(String[] args) {
    //Definition of variables, starting with the Scanner
        Scanner sc = new Scanner(System.in);

    //Definition of day numbers, then names. monthNumbers not used, but still included.
        int dateNumbers;
        int monthNumbers;
        int yearNumbers;
        String dayName;
        String monthName;

    //Definition of time variables + region.
        int hour;
        int minute;
        String region;

    //Definition of pay variables.
        double payRate;
        int hoursWorked;
        double totalPay;


    //############
    //A function that can be used for quick testing.
        //programTesting();


    //Welcome message that displays on program start.
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

        System.out.print("What region are you in? (US): ");
        region = sc.nextLine();


    //Asking of pay. Inside a while to allow for a valid input.
        while(true){
            System.out.print("\nWhat is your pay per hour? (Must be between 1 and 35.): ");
            payRate = Double.parseDouble(sc.nextLine());

        //Checks if pay is within required range. Option to retry a different value or exit overall.
            if(payRate<=0 || payRate>35){
                System.out.println("Would you like to exit the program? (Y/N): ");
                if(sc.nextLine().equalsIgnoreCase("Y")){
                    System.out.println("Please contact your manager for further assistance.");
                    payRate = 0;
                    break;
                }else{
                    System.out.println("Rate must be between 1 and 35.");
                }
            }else{
                break;
            }
        }
        System.out.print("How many hours have you worked? ");
        hoursWorked = Integer.parseInt(sc.nextLine());


    //Printing the date in requested format using function defined above.
        String date = formatDateString(dayName, monthName, dateNumbers, yearNumbers,
                                        timeOfDayFinder(hour,minute),region);
        System.out.println("\n"+date);


    //Pay displayed in a rounded floating point format, using function defined previously.
        totalPay = calcGrossPay(payRate,hoursWorked);
        System.out.printf("Total Pay: %.2f\n\n",totalPay);


    //Last line in program, and displays an exit message showing that there's nothing else.
        displayExitMsg();
    }
}
