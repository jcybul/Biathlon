
class Athlete {
ShootingResult ShootingResult;
SkiingResult SkiingResult;
String name;

Athlete (ShootingResult ShootingResult,SkiingResult SkiingResult,String name){
	
	this.ShootingResult = ShootingResult;
	this.SkiingResult = SkiingResult;
	this.name = name;
}
// Compares two athletes and returns the one with better results 
public Athlete betterSkiier( Athlete other) {
	if  (this.SkiingResult.pointsEarned() > other.SkiingResult.pointsEarned()){
	return other;
	}
	
	else {
    return this;
	}
	

}
//Compares two athletes and returns true if the given athlete has beaten the other
public boolean hasBeaten(Athlete other) {
	return 
      ((this.SkiingResult.pointsEarned() < other.SkiingResult.pointsEarned())
      || (this.ShootingResult.pointsEarned() > other.ShootingResult.pointsEarned()));
	
	
}
}
