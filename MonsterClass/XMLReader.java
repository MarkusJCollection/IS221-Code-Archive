import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLReader {

    public Map<String,List<String>> outputMap = new HashMap<>();
    //Class that will read an XML file and put its contents
    // into a <String,List<String> hashmap.

        //Variable definition used for storing the path
        // to the XML file.
    private Path XMLFilePath = Paths.get("data/singlePokemon.xml");



    /**
     * Public function that allows the changing
     * of the file being read.
     * @param newPath
     */
    public void XML_Load(String newPath){
        this.XMLFilePath = Paths.get(newPath);
        XMLPreload("<xml>");
    }



    /**
     * Main function that appends data into a hashmap.
     * @param tag Tag of part of XML file you'd like to search.
     */
    private void XMLPreload(String tag){

            //List used for iterations.
        List<String> XMLFile = null;
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


        //Try-catch for IOException.
        try{
            XMLFile = Files.readAllLines(XMLFilePath);

        }catch (IOException ex){
            System.out.println("Monster file could not open or does not exist.");
        }



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

                //Running count increasing at the end of each loop.
            count++;
        }


        outputMap.put(tag,listOfVariables);
        for(String entry : listOfVariables){
            if(entry.contains("<")){
                XMLPreload(entry);
            }

        }
    }



    /**
     * Basic constructor that automatically searches
     * through the <xml> tag.
     */
    public XMLReader(){
        XMLPreload("<xml>");
    }



    /**
     * Constructor that allows the user to search
     * through a specific tag.
     * @param tag Input of any tag inside a given <xml> file.
     */
    public XMLReader(String tag){
        XMLPreload(tag);
    }
}
