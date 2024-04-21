import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Monster {


    //Record keeping track of regions.
    public record RegionsList(int regID, String regName,
                              String regDesc){}
    RegionsList regionsList = new RegionsList(0,"Kanto","First City");


    public record PokeMove(String name, int damage,
                           String archetype, String desc){}
    PokeMove pokeMove = new PokeMove("Tackle", 2,
            "Physical","Tackle your enemy");




    private String	pokeName;
    private List<String> pokeType = new ArrayList<>();
    private List<Integer> pokeStats = new ArrayList<>();
    private Path pokeFilePath = Paths.get("data/singlePokemon.xml");
    private int	pokeHeight;
    private double	pokeWeight;
    private String	pokeNickname;
    private int	pokeBattles;
    private int pokeIDNum;
    private String pokeDescription;
    public String[] pokeMoveSet = {"Empty","Empty","Empty","Empty"};

    /**
     * Preload an already designated monster.
     * @param newPath Relative path with filename.
     * @throws IOException
     */
    public void pokePreload(String newPath) throws IOException{
        this.pokeFilePath = Paths.get(newPath);
        pokePreload();
    }
    private void pokePreload() throws IOException{

        boolean Monst = false;
        boolean types = false;
        boolean stats = false;
        int counter = 0;

        for(String line : Files.readAllLines(pokeFilePath)){

            switch(line){
                case "<monster>":
                    Monst = true;
                    break;
                case "</monster>":
                    Monst = false;
                    break;
                case "<types>":
                    types = true;
                    break;
                case "</types>":
                    types = false;
                    break;
                case "<stats>":
                    stats = true;
                    break;
                case "</stats>":
                    stats = false;
                    break;
                default:
                    break;
            }
            if (Monst){
                if (counter == 1){
                    this.pokeIDNum = Integer.parseInt(line);
                    counter ++;
                }else if(counter == 2){
                    this.pokeName = line;
                    counter ++;
                } else if(counter == 3){
                    counter = 0;
                    Monst = false;
                }else{
                    counter ++;
                }
            }
            if (types){
                this.pokeType.add(line);
            }
            System.out.println(counter);
            if (stats){
                if (counter != 0){
                    this.pokeStats.add(Integer.parseInt(line));
                    counter = 0;
                } else{
                    counter ++;
                }
            }
        }
    }

    //Constructor = setting defaults.
    //Has no type.
    public Monster() throws IOException{
        this.pokePreload();
        pokeIDNum = 1;
        pokeName = "Bulbasaur";
    }

    public Monster(int id, String name){
        pokeIDNum  = id;
        pokeName = name;
    }



    public Monster(int regID, String regName, String regDesc){
        regionsList = new RegionsList(regID,regName,regDesc);
    }

    public Monster(String name, int dmg,
                   String dmgType, String desc){
        pokeMove = new PokeMove(name,dmg,dmgType,desc);
    }





    public void pokeHeight(int givenHeightFT,int givenHeightIN){
        this.pokeHeight = (givenHeightFT*12)+givenHeightIN;
    }




    public int pokeIDNum(){
        return this.pokeIDNum;
    }
    public String pokeDescription(){
        return this.pokeDescription;
    }
    /**
     *
     * @return String of ft & inches.
     */
    public String pokeHeight(){
        return String.format("%d' %d''",
                this.pokeHeight/12, this.pokeHeight%12);
    }

    public void typeString(){
        String newTypeString = "";
        for (String type : pokeType){
            newTypeString += type;

        }

    }

    public String toString(){
        return String.format("""
                Name: %s
                ID: %d
                Type:
                Stats:""",this.pokeName,this.pokeIDNum);
    }
    //super.[METHOD]
    //Super gets parent function and is like an override.
    //this.[METHOD]
    //This references current object.














}
