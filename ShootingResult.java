import java.util.LinkedList;
public class ShootingResult implements IEvent {
	LinkedList<ShootingRound> Lrounds;
	
	ShootingResult (LinkedList<ShootingRound> Lrounds){
		this.Lrounds = Lrounds;
	}
// Produces the points that the athlete got after shooting.
	public double pointsEarned () { 
		double points = 0;
		for (ShootingRound round: this.Lrounds) {
			points += round.TargetsHit;
		}
		return points;
		}
	// Produces the best shooting round a given athlete had 
	   ShootingRound bestRound() {
		ShootingRound best = this.Lrounds.getFirst();
		for(ShootingRound round: this.Lrounds) {
			if (round.TargetsHit >= best.TargetsHit) {
				best = round;
			}	
		}
		return best;	
	}
}

