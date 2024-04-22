import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserDemographic {
    //Class that stores basic user demographics
    //including name, age, and work duration.
    public String userFirstName;
    public String userLastName;
    public int userAge;
    private int userWorkDuration;

        //Variables from reading position file.
    private String positions;
    private Path dataPath = Paths.get("data/SoftwareEngineerIIPosition.txt");




    /**
     * Record keeping a position's data.
     * @param position
     * @param description
     * @param avgSalary
     * @param management
     * @param degreeReq
     * @param certReq
     */
    public record Positions(String position, String description,
                            int avgSalary, boolean management,
                            String degreeReq, String certReq){
        public String toString(){
            return String.format("""
                    Position: %s
                    Description: %s
                    Average Salary: %d
                    Management Position: %b
                    Degree Requirements: %s
                    License/Certificate Requirements: %s
                    """,position, description, avgSalary,
                    management, degreeReq, certReq);
        }
    }


    /**
     * A file reader that reads a designated input and returns the data
     * as its string.
     * @return
     * @throws IOException
     */
    private String positionLoader() throws IOException{

            //Initialization of variables later used.
        int counter = 0;
        String position = "";
        String description = "";
        int avgSalary = 0;
        boolean management = false;
        String degreeReq = "";
        String certReq = "";

            //For loop that goes through each line of the file.
        for(String line : Files.readAllLines(dataPath)){
                //Depending on a line's spot in the file,
                // its contents are set equal to what it's
                // variable counterpart.
           switch(counter){
               case 0:
                   position = line;
                   break;
               case 1:
                   description = line;
                   break;
               case 2:
                   avgSalary = Integer.parseInt(line);
                   break;
               case 3:
                   management = Boolean.getBoolean(line);
                   break;
               case 4:
                   degreeReq = line;
                   break;
               case 5:
                   certReq = line;
                   break;
               default:
               System.out.println("Error processing file.");
               break;

           }
                //Running counter that increases after each switch.
           counter++;
        }
            //
        Positions positions = new Positions(position,description,
                avgSalary,management,degreeReq,certReq);
        return positions.toString();
    }


    /**
     * Constructor class.
     */
    public UserDemographic() throws IOException{
        this.positions = positionLoader();
        this.userFirstName = "Ronald";
        this.userLastName = "Roe";
        this.userAge = 50;
        this.userWorkDuration = 0;
    }


    /**
     * Function that allows the initialization of variables.
     * @param userName
     * @param userAge
     * @param userWorkDurationMTHS
     */
    public UserDemographic(String userName, int userAge,
                           int userWorkDurationMTHS){
        this.userName(userName);
        this.userAge = userAge;
        this.userWorkDuration = userWorkDurationMTHS;
    }

    /**
     * Takes string input of first and last name.
     * @param name
     */
    public void userName(String name){
        System.out.printf("Name set as: %s\n\n",name);
        String[] nameArray = name.split(" ");
        switch(nameArray.length){
            case 1:
                this.userFirstName = nameArray[0];
                break;
            case 2:
                this.userFirstName = nameArray[0];
                this.userLastName = nameArray[1];
                break;
            default:
                System.out.println("Invalid input.\n");
                break;

        }
    }

    /**
     * Takes in input of user's age.
     * @param age
     */
    public void userAge(int age) {
        System.out.printf("Age set as: %d\n\n",age);
        this.userAge = age;
    }


    /**
     * Takes integer input of years worked.
     * @param yearNum
     */
    public void userWorkDurationYRS(int yearNum){
        System.out.printf("Years set as: %d\n\n",yearNum);
        this.userWorkDuration += yearNum*12;
    }

    /**
     * Takes integer input of months worked.
     * @param mthNum
     */
    public void userWorkDurationMTH(int mthNum){
        System.out.printf("Months set as: %d\n\n",mthNum);
        this.userWorkDuration += mthNum;
    }

    /**
     * Accessor of total work duration.
     * @return
     */
    public String userWorkDuration(){
        return String.format("%d years and %d months",
                this.userWorkDuration/12,this.userWorkDuration%12);
    }


    /**
     * Overloaded string function to print full employee details.
     * @return
     */
    public String toString(){
        return String.format("""
                Employee Name: %s %s
                Employee Age: %d
                Employee Time Worked: %01d year(s) %01d month(s)
                \n%s""",
                this.userFirstName,this.userLastName,
                this.userAge,this.userWorkDuration/12,
                this.userWorkDuration%12,positions);
    }
}
