import java.util.ArrayList;

class Team {
    private  String teamName;
    private  ArrayList<Player> players=new ArrayList<Player>();
    private int atk;
    private int mid;
    private int def;

    public Team(String name){
        teamName=name;

    }

    

    public void addPlayer(Player p){
        players.add(p);
        atk=calculateAVG(players, "ATK");
        mid=calculateAVG(players,"MID");
        def=calculateAVG(players, "DEF");
    }


    public void printPlayers(){
        System.out.println(teamName.toUpperCase()+"'S PLAYER LIST");
        System.out.println("ATTACK:"+atk);
        System.out.println("MIDFIELD:"+mid);
        System.out.println("DEFENCE:"+def);

        //ATTACKERS
        System.out.println("ATTACKERS:");
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equalsIgnoreCase("ATK")) {
                System.out.println(players.get(i).getFullName()+" Rating:"+players.get(i).getRating());
            }
        }
        System.out.println("*************************************");

        //MIDFIELDERS
        System.out.println("MIDFIELDERS:");
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equalsIgnoreCase("MID")) {

                System.out.println(players.get(i).getFullName()+" Rating:"+players.get(i).getRating());
            }
        }

        System.out.println("*************************************");
        //DEFENDERS
        System.out.println("DEFENDERS:");
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equalsIgnoreCase("DEF")) {

                System.out.println(players.get(i).getFullName()+" Rating:"+players.get(i).getRating());
            }
        }
    }


    public int calculateAVG(ArrayList<Player> p,String position){
        int total=0;
        int count=0;

        for (int i = 0; i < p.size(); i++) {

            if(p.get(i).getPosition().equals(position.toUpperCase())){
                total+=p.get(i).getRating();
                count+=1;
            }
        }

        if (count==0) {
            return 0;
        }

        return total/count;
    }


    public String getName(){
        return teamName;
    }
    public int getAtk(){
        int a=calculateAVG(players, "ATK");
        return a;
    }

    public int getMid(){
        int m=calculateAVG(players, "MID");
        return m;
    }

    public int getDef(){
        int d=calculateAVG(players, "DEF");
        return d;
    }
}
