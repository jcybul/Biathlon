
public class SkiingResult  extends AbsMassAndSki {
	ShootingResult shootingResult;
	SkiingResult(double time,int position, ShootingResult shootingResult){
		super(time,position);
		this.shootingResult = shootingResult;
	}
	//adds the penalty time to the final time according the shots missed.
	public double addShootingPenalties ( ShootingResult shootingResult) {
		double totalMissed = 0; 
		for(ShootingRound round: shootingResult.Lrounds) {
			totalMissed += (20 * (5 - round.TargetsHit));
		}
	
		return totalMissed;
	
	}

	// Produces the total time the athlete got after penalty 
	public double pointsEarned () {
	
		double totalSum = (time + addShootingPenalties(shootingResult));
		if (position == 1) {
			totalSum = totalSum - 10;
		}
		else if (position == 2) {
			totalSum = totalSum - 7;
		}
		else if (position == 3) {
			totalSum = totalSum - 3;
		}
	
		return totalSum;
	}
}
