# Football-Simulator-Java
SIMPLE FOOTBALL SIMULATOR 

Players:
there are 3 types of players, attackers, defenders,midfielders(Goal keepers in the future)
Each player has a different special stats:

Attackers :(Shooting,Dribbling,Passing,Speed);
Midfielders:(Dribbling,Passing,Vision,Defending)
Defenders:(Defending,Composure,Aggression,Passing)

Each team is made up of 2 attackers,3 midfielders and 3 defenders.

Teams:
Each team will have different tactics,
Each tactic will offer arrays for the match sim to round

Each team has 3 stats: Attack,defence,Midfield. 
Attack: Determines how many chances they will score(Will probably change)
Midfield: Determines how many chances they get 
Defence:Determines how many chances they will stop

***The rating of attack,defence and midfield depends on the teams rating***


Match Engine:
The amount of array chances depends on what tactics each team used. Max array number is 20.


The match engine will take in both teams stats and events will occur based on ratings:

Midfield: Creates chances
Attackers: Take chances
Defcence: Stop attacks


The teams attack,midfield, and defence will be comapred and the team with higher ratings will have more chances of events hapening,
the other team will have but it will be less likely
For example:
team 1 has a midfield of 89
team 2 has a midfield of 78

we add these two ratings and to get the weights for each team,

CODE SNIPPET:

       int team1Rating = 80;
        int team2Rating = 70;
        double team1Weight = (double) team1Rating / (team1Rating + team2Rating); // Calculate weight for team 1
        double team2Weight = (double) team2Rating / (team1Rating + team2Rating); // Calculate weight for team 2
        
        Random random = new Random();
        if (random.nextDouble() < team1Weight) {
            // The code inside this block will execute with a probability equal to team 1's weight
            System.out.println("Event occurred for team 1");
        } else {
            // The code inside this block will execute with a probability equal to team 2's weight
            System.out.println("Event occurred for team 2");
        }
    }


AFter this i will create an array of team objects which will add these two teams to the based on their weights, the higher the team weight,
likely the team is to be apart of the array.Below is an implementation:

CODE SNIPPET:

 String[] teamsArray = new String[10];
        Random random = new Random();
        
        int team1Count = (int) Math.round(team1Weight * 10); // Calculate number of times to add team 1 to the array
        int team2Count = 10 - team1Count; // Calculate number of times to add team 2 to the array
        
        int index = 0;
        for (int i = 0; i < team1Count; i++) {
            teamsArray[index] = "Team 1";
            index++;
        }
        for (int i = 0; i < team2Count; i++) {
            teamsArray[index] = "Team 2";
            index++;
        }
        
        // Print the resulting array
        for (String team : teamsArray) {
            System.out.println(team);
        }
    }
}

After this is done, i generate random numbers based on the length of the array, for example: if it is 10,we have values:2,5,6,1,3..
until we have random numbers the lenght of the array we have:To do this we need to generate unqiue random numbers part of our number set:
 Below is an implementation:

 CODE SNIPPET:

 This solution implements Sets which i have not been taught:

        Set<Integer> usedNumbers = new HashSet<>(); // Create a set to keep track of used numbers
        Random random = new Random();
        
        while (usedNumbers.size() < 10) { // Generate 10 unique numbers
            int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
            if (!usedNumbers.contains(randomNumber)) { // Check if the number has already been generated
                usedNumbers.add(randomNumber); // Add the number to the set of used numbers
                System.out.println(randomNumber);
            }
        }
 

 This solution uses an array, but it also uses break statements which i have been warned against:

 int[] usedNumbers = new int[10]; // Create an array to keep track of used numbers
        int generatedNumbersCount = 0; // Keep track of the number of generated numbers
        Random random = new Random();

        while (generatedNumbersCount < 10) { // Generate 10 unique numbers
            int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
            
            boolean isUnique = true; // Assume the number is unique until proven otherwise
            for (int i = 0; i < generatedNumbersCount; i++) { // Check each previously generated number
                if (usedNumbers[i] == randomNumber) { // Check if the number has already been generated
                    isUnique = false; // The number is not unique
                    break; // No need to check further
                }
            }
            
            if (isUnique) { // If the number is unique, add it to the used numbers array
                usedNumbers[generatedNumbersCount] = randomNumber;
                generatedNumbersCount++; // Increment the generated numbers count
                System.out.println(randomNumber);
            }
        }
    }
}

//This is also an array of boooleans which makes the code cleaner.
Yes, you could use an array of booleans instead of an array of integers to keep track of used numbers. Using an array of booleans would make the code simpler and easier to understand, because we could use true and false values instead of 1 and 0.

Here's an example of how to use an array of booleans to generate unique random numbers in Java:

java
Copy code
boolean[] usedNumbers = new boolean[100]; // create an array to keep track of used numbers
Random random = new Random();
int randomNumber = random.nextInt(100); // generate a random number between 0 and 99

if (!usedNumbers[randomNumber]) { // check if the number has already been generated
    usedNumbers[randomNumber] = true; // mark the number as used in the array
    // use the random number in your game
} else {
    // the number has already been generated, generate a new random number
}


After we geneare a random numbers on different indexes. We take the team in that index and give them a chance in real time.
When they have a chance, the attackers ratings are matched with the defenders.


and The system decides if they score based on an array of different values, weighted again. the array selects a random value in the arrayy
and who ever is in the array, is who is in favour.


If the attackers are in favour,the score becomes grows in their favour. We could have a score board method that stores the two teams score.

AFter the array has run through each random chance. The team with the highest score wins.


TO DECIDE WHO SCORES IN THE TEAM:
the engine creates an array of players in the team and assigns weights based on their attack. 
Players with higher ratings are bound to score.
We could use a parallel array to do this

NOTE: NEED A RANDOM METHOD

To Give players ratings in the match is decided by the following(WILL IMPLEMENT AFter)
A Goal-Attacker each gets a + random value(from 0.5-1.0)(Scorer gets 2.0)
       Midfielders each gets a random value(from 0.3-0.8)(assister gets 1.2)
       defender









