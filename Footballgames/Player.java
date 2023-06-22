 import java.util.Random;
import java.util.Scanner;

class Player {
    Random random = new Random();

    private static final String POSITION_ATK="ATK";
    private static final String POSITION_MID="MID";
    private static final String POSITION_DEF="DEF";

    private  String fName;
    private  String lName;
    private  String playerPosition;
    private int rating=random.nextInt(31) + 70;


    public Player(String fN,String lN,String pos){
        fName=fN;
        lName=lN;
        playerPosition=pos.toUpperCase();

        boolean valid=false;

        while(!valid){
            if(playerPosition.equalsIgnoreCase(POSITION_ATK)){
                System.out.println(fName+" is an ATTACKER!");
                valid=true;
            }
            else if(playerPosition.equals(POSITION_MID)){
                System.out.println(fName+" is a MIDFIELDER!");
                valid=true;
            }
            else if(playerPosition.equalsIgnoreCase(POSITION_DEF)){
                System.out.println(fName+" is a DEFENDER!");
                valid=true;
            }
            else{
                playerPosition=positionErrorMessage();
            }
            System.out.println("*************************************");
        }
    }





    public  String positionErrorMessage() {
        System.out.println("YOU DID NOT ENTER A VALID POSITION-\n FOR "+fName+",THE POSITIONS AVAILABLE ARE:\n [ATK,MID,DEF])");
        System.out.println("ENTER A NEW POSITION:...");
        Scanner in=new Scanner(System.in);
        String newPos=in.nextLine();

        return newPos;
    }

    public String getPosition(){
        return this.playerPosition;
    }

    public String getFullName(){
        return this.fName+" "+this.lName;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int r){
        this.rating=r;
    }
}


