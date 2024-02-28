import javax.naming.Name;

public class Main {
    public static void main(String[] args) {

        //2.
        String dayName = "Wednesday";
        int dayNumber = 31;
        String monthName = "January";
        int yearNumber = 2024;


        //3.
        /*
        System.out.println(
                "Month: " + monthName + "; "+
                "Day: " + dayNumber + "; "+
                "Day No.: " + dayNumber + "; "+
                "Year: " + yearNumber
        );
        */

        
        //4.
        int hour = 2;
        String minute = "00";
        String timeOfDay = "P.M.";


        //5.
        System.out.println(
                "USA Format"
        );
        System.out.println(
                dayName + ", "+
                monthName + " "+
                dayNumber + ", "+
                yearNumber + ": "+
                hour + ":"+
                minute + " "+
                timeOfDay
        );
        System.out.println(
                "UK Format"
        );
        System.out.println(
                dayName + ", "+
                dayNumber + " "+
                monthName + " "+
                yearNumber + " "+
                hour + ":"+
                minute + " "+
                timeOfDay
        );

    }
}