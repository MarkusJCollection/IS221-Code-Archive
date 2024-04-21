import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    //Class that readers XML files recursively.

        //Variable definition used for storing the path
        // to the XML file.
    private Path XMLFilePath = Paths.get("data/singlePokemon.xml");


        //Function accessible to the user that allows them to
        // load their own file.
    public void XML_Load(String newPath) throws IOException {
        this.XMLFilePath = Paths.get(newPath);
        XMLPreload("<xml>");
    }


    /**
     * Function that will output the full contents of a given XML tag.
     * @param tag Tag of part of XML file you'd like to search.
     * @return Outputs starting tag and it's contents.
     * @throws IOException
     */
    private String XMLPreload(String tag) throws IOException {
            //Lists used for iterations.
        List<String> XMLFile = Files.readAllLines(XMLFilePath);
        List<String> listOfVariables = new ArrayList<>();

            //Takes the tag and finds what the name is,
            // and what the end tag would be.
        String groupTag = tag.substring(1,tag.length()-1);
        String endTag = "</"+groupTag+">";

            //Count used to keep track of what
            // line is being read.
        int count = 0;

            //Variables deciding whether contents should be
            // skipped when deciding the outputs.
        String endSkipTag = "<>";
        boolean tagSeen = false;
        boolean skip = false;

            //Output initialized with a starting bracket.
        String outputString = "[";

            //While loop that goes through the files contents until
            // the end tag is found.
        while(!XMLFile.get(count).equals(endTag)){
                //Each time the loop is ran, the current line is
                // set to the running count.
            String line = XMLFile.get(count);

                //First if statement regarding where
                // the function will start reading.
            if(line.equals(tag)){
                    //If the tag is seen,
                    // the flag is set to true.
                tagSeen = true;
            }else if (tagSeen){
                    //If the tag was found,
                    // then the contents are added
                    // to the output list if it's the
                    // start of a new tag, or is truly
                    // a part of the original tag.
                if (line.equals(endSkipTag)){
                        //If the tag to stop skipping was found,
                        // skipping is stopped.
                    skip = false;
                }else if(line.contains("<") && !line.contains("/") && !skip){
                        //If a nested function is found, just
                        // the tag of the function is added to
                        // the output list, and so that
                        // its contents can be skipped.
                    endSkipTag = "</"+line.substring(1);
                    listOfVariables.add(line);
                    skip = true;
                } else if (!skip){
                        //Anything that is a member
                        // of the tag is added to the
                        // output list.
                    listOfVariables.add(line);
                }
            }
                //Running count increased at the end of each loop.
            count++;
        }
            //Output string adds the group tag
            // and a colon showing its contents.
        outputString += groupTag+": ";

            //For loop going through the output list.
        for (String subSection : listOfVariables){
                //If statement deciding if the tag is
                // nested and requires another running
                // of the program.
            if(subSection.contains("<")){
                    //If it's nested then it runs the same
                    // program again with the new tag.
                outputString+= XMLPreload(subSection)+" ";
            }else{
                    //If it's not nested then the item is
                    // concatenated to the output string.
                outputString += subSection+" ";
            }
        }
            //Return statement giving the output string
            // with an ending bracket.
        return outputString.substring(0,outputString.length()-1)+"]";
    }

    /**
     * Basic constructor that automatically searches
     * through the <xml> tag.
     * @throws IOException
     */
    public XMLReader() throws IOException{
        System.out.println(XMLPreload("<xml>"));
    }

    /**
     * Constructor that allows the user to search
     * through their own tag.
     * @param tag Input of any tag inside a given <xml> file.
     * @throws IOException
     */
    public XMLReader(String tag) throws IOException{
        System.out.println(XMLPreload(tag));
    }
}