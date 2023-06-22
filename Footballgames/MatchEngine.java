import java.util.Random;

class MatchEngine {
    private Team homeTeam;
    private int homeTeamAtk;
    private int homeTeamMid;
    private int homeTeamDef;
    private int homeTeamScore;
    private double htotalRating=(homeTeamAtk+homeTeamMid+homeTeamDef)/3;

    private Team awayTeam;
    private int awayTeamAtk;
    private int awayTeamMid;
    private int awayTeamDef;
    //will change this later
    private double atotalRating=(awayTeamAtk+awayTeamMid+awayTeamDef)/3;
    private int awayTeamScore;

    public Team winner;



    public MatchEngine(Team h,Team a){
        this.homeTeam=h;
        homeTeamAtk=h.getAtk();
        homeTeamMid=h.getMid();
        homeTeamDef=h.getDef();

        this.awayTeam=a;
        awayTeamAtk=a.getAtk();
        awayTeamMid=a.getMid();
        awayTeamDef=a.getDef();

    }


    public Team simulate(){
    // Calculate the expected goals for each team using a Poisson distribution
    double team1ExpectedGoals = Math.exp(htotalRating / 10.0) / 2.0;
    double team2ExpectedGoals = Math.exp(atotalRating / 10.0) / 2.0;

    // Create a new instance of the Random class
    Random random = new Random();

    // Simulate the number of goals each team scores using a Poisson distribution
     homeTeamScore = poissonDistribution(team1ExpectedGoals, random);
     awayTeamScore = poissonDistribution(team2ExpectedGoals, random);

    // Print the simulated scoreline
    // System.out.println(homeTeam.getName()+": " + homeTeamScore + " - " + awayTeam.getName()+": " + awayTeamScore);
    // if (getWinner()==null) {
    //     System.out.println("Draw");
    // }
    // else if (getWinner()==homeTeam) {
    //     System.out.println(homeTeam.getName()+" Wins");
    // } else {
    //     System.out.println(awayTeam.getName()+" Wins");
    // }
    return getWinner();

    }


    // Helper method to generate a random number using a Poisson distribution
    private static int poissonDistribution(double lambda, Random random) {
        int x = 0;
        double p = Math.exp(-lambda);
        double s = p;

        double u = random.nextDouble();

        while (u > s) {
            x++;
            p = p * lambda / x;
            s += p;
        }

        return x;
    }

private Team getWinner(){
    if (homeTeamScore>awayTeamScore) {
        return homeTeam;
    } else if(awayTeamScore>homeTeamScore) {
        return awayTeam;
    }else{
        return null;//draw
    }
}
public Team winner(){
    return winner;
}


}
