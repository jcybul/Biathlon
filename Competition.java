import java.util.LinkedList;
public class Competition {
	LinkedList<Athlete> ListOfAthletes;
	int Sround;

	Competition (int Sround,LinkedList<Athlete> ListOfAthletes){
		this.ListOfAthletes = ListOfAthletes;
		this.Sround = Sround;
	}
	//produces the list of athletes that had less than the given number of shooting rounds set on the competiton.
	LinkedList<String> shootingDNF(){
		LinkedList<String> DNFList = new LinkedList<String>(); 
		for(Athlete round: this.ListOfAthletes) {
			if(round.ShootingResult.Lrounds.size() < Sround) {
				DNFList.add(round.name);
			}
		}
		return DNFList; 
	}
    // produces the skiing score of the athlete with the given name 
	double skiingScoreForAthlete(String Name) {
		double SkiingScore = 0; 
		for(Athlete round: this.ListOfAthletes) {
			if(round.name.equals(Name)) {
				SkiingScore = round.SkiingResult.pointsEarned();
			}
		}
		return SkiingScore;
	}
	// checks if any of the athletes on a competition improved their skiing result on the next competiton.
	boolean anySkiingImprovement(Competition AnotherCompetition) { 
		for(Athlete round1: this.ListOfAthletes) {
			for(Athlete round2: AnotherCompetition.ListOfAthletes) {
				if(round1.name.equals(round2.name)) {
					if(round1.SkiingResult.pointsEarned() < round2.SkiingResult.pointsEarned()) {
						return true; 
					}
				}
			}
		}
		return false; 
	}
}

//Yes, there could be a helper method that takes a name as an input and loops through the linked list trying to find an Athlete with the same name
//It would return the Athlete for future computations on that specific Athlete. In SkiingScoreForAthlete it would call the helper funnction with the input string name and then compute the points earned. 
//In the anySkiingImprovement it was called the function  after the first loop and then compared the SkiingResults. 

