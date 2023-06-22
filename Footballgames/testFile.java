
public class testFile {
    public static void main(String[] args) {
        //team 1
        Player p1=new Player("Daniel","Nwogo","ATK");
        Player p2=new Player("James", "Daly", "ATK");
        Player p3=new Player("Oliver", "Rodriguez", "MID");
        Player p4=new Player("Darwin", "Truncez", "mid");
        Player p5=new Player("Kevin", "Chancey", "Def");
        Player p6=new Player("Yaak", "Black", "Def");
        p1.setRating(100);
        p2.setRating(100);
        p3.setRating(100);
        p4.setRating(100);
        p5.setRating(100);
        p6.setRating(100);

        //team 2
        Player p7=new Player("Steven", "Davis", "Def");
        Player p8=new Player("Antonio", "Villa", "Def");
        Player p9=new Player("teven", "sadiq", "Def");
        Player p10=new Player("Leonardo", "Da vinci", "Mid");
        Player p11=new Player("Goal", "Keeper", "Mid");
        Player p12=new Player("Saint", "Lopez", "ATk");


        
        Team team1=new Team("Saskatewan Cougars");
        Team team2=new Team("Manitoba Bisons");


        //team 1
        team1.addPlayer(p1);
        team1.addPlayer(p2);
        team1.addPlayer(p3);
        team1.addPlayer(p4);
        team1.addPlayer(p5);
        team1.addPlayer(p6);
        //team 2
        team2.addPlayer(p7);
        team2.addPlayer(p8);
        team2.addPlayer(p9);
        team2.addPlayer(p10);
        team2.addPlayer(p11);
        team2.addPlayer(p12);









        MatchEngine m1=new MatchEngine(team1, team2);

        System.out.println("WINNER IS:"+m1.simulate().getName());
    }
}
