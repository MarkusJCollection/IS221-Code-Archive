import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    //Class that readers XML files recursively.

        //Variable definition used for storing the path
        //to the XML file.
    private Path XMLFilePath = Paths.get("data/singlePokemon.xml");


        //Function accessible to the user that allows them to
        //load their own file.
    public void XML_Load(String newPath) throws IOException {
        this.XMLFilePath = Paths.get(newPath);
        XMLPreload("<xml>");
    }



    private String XMLPreload(String tag) throws IOException {

        List<String> XMLFile = Files.readAllLines(XMLFilePath);
        List<String> listOfVariables = new ArrayList<>();

        int count = 0;

        String groupTag = tag.substring(1,tag.length()-1);
        String endTag = "</"+groupTag+">";

        String skipTag = "<>";

        boolean tagSeen = false;
        boolean skip = false;

        String outputString = "[";



        while(!XMLFile.get(count).equals(endTag)){
            String line = XMLFile.get(count);
            if(line.equals(tag)){
                tagSeen = true;
            }else if (tagSeen){

                if (line.equals(skipTag)){
                    skip = false;
                }else if(line.contains("<") && !line.contains("/") && !skip){
                    skipTag = "</"+line.substring(1);
                    listOfVariables.add(line);
                    skip = true;
                } else if (!skip){
                    listOfVariables.add(line);
                }
            }
            count++;
        }
        outputString += groupTag+": ";
        for (String subSection : listOfVariables){
            if(subSection.contains("<")){
                outputString+= XMLPreload(subSection)+" ";
            }else{
                outputString += subSection+" ";
            }
        }
        return outputString.substring(0,outputString.length()-1)+"]";
    }


        //Constructor class that preloads a designated file.
    public XMLReader() throws IOException{
        System.out.println(XMLPreload("<xml>"));
    }
    public XMLReader(String tag) throws IOException{
        System.out.println(XMLPreload(tag));
    }
}