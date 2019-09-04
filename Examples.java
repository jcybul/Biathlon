// Joseph Cybul  jcybul       Camila Di fino Napolitano cdifinonapolitan
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class Examples {
 LinkedList<ShootingRound>  joeRounds = new LinkedList<ShootingRound> ();
 LinkedList<ShootingRound>  carlRounds = new LinkedList<ShootingRound> ();
 LinkedList<ShootingRound>  maxRounds = new LinkedList<ShootingRound> ();
 LinkedList<Athlete> ListOfAthletes1 = new LinkedList<Athlete>();
 LinkedList<Athlete> ListOfAthletes2 = new LinkedList<Athlete>(); 
public Examples() {
	//joe rounds//
	 joeRounds.add(noHit);
	 joeRounds.add(fiveHit);
	 joeRounds.add(twoHit);
	 //carl rounds//
	 carlRounds.add(noHit);
	 //max rounds //
	 maxRounds.add(fiveHit);
	 maxRounds.add(fiveHit);
	 maxRounds.add(threeHit);
	 ///athlete list//
	 ListOfAthletes1.add(carl);
	 ListOfAthletes1.add(joe);
	 ListOfAthletes1.add(max);
	 ListOfAthletes2.add(carl);
	 ListOfAthletes2.add(joe);
	 ListOfAthletes2.add(max);
	  
	}
  // Shooting Round hits 
	
  ShootingRound noHit = new ShootingRound(0);	
  ShootingRound oneHit = new ShootingRound (1);
  ShootingRound twoHit = new ShootingRound (2);
  ShootingRound threeHit = new ShootingRound (3);
  ShootingRound fourthHit = new ShootingRound (4);
  ShootingRound fiveHit = new ShootingRound (5);
  ////////
  ShootingResult joeShoot = new ShootingResult(joeRounds);
  ShootingResult carlShoot = new ShootingResult(carlRounds);
  ShootingResult maxShoot = new ShootingResult(maxRounds);
  ////////
  SkiingResult joeSki = new SkiingResult (16,2,joeShoot);
  SkiingResult maxSki = new SkiingResult (16,1,maxShoot);
  SkiingResult carlSki = new SkiingResult (16,3,carlShoot);
  ////////
  Athlete max = new Athlete (maxShoot,maxSki,"max");
  Athlete joe = new Athlete (joeShoot,joeSki,"joe");
  Athlete carl = new Athlete (carlShoot,carlSki,"carl");

/// test on points earned 
	  @Test
	  
	  public void joeResult() {
		 
		  assertEquals (7, joeShoot.pointsEarned(), .01);
	  }
  
	  @Test 
	  public void carlResult () {
		  assertEquals (0, carlShoot.pointsEarned(), .01);	  
	  }
	
	  @Test 
	  public void maxResult () {
		  assertEquals (13, maxShoot.pointsEarned(), .01);
	  }
  
//////// addShootingPenalties tests////////
  
	  @Test
	  public void joePenaltyTime () {
		  assertEquals (160,joeSki.addShootingPenalties(joeShoot) , .01);
	  }
  
	  @Test
	  public void maxPenaltyTime () {
		  assertEquals (40 ,maxSki.addShootingPenalties(maxShoot) , .01);
	  }
	  @Test
	  public void carlPenaltyTime () {
		  assertEquals (100,carlSki.addShootingPenalties(carlShoot) , .01);
	  }
  
/////////tests for skiing points earned///////
  
	  @Test
	  public void joeSkiingPoints () {
		 
		  assertEquals (169,joeSki.pointsEarned() , .01);
	
	  }
	  @Test
	  public void maxSkiingPoints () {
		  
		  assertEquals (46,maxSki.pointsEarned() , .01);
	
	  }
	  @Test
	  public void carlSkiingPoints () {
		  assertEquals (113,carlSki.pointsEarned() , .01);
	  }
  
/////////tests for betterSkiier/////////
	  @Test
	  public void Betterskier () {
		  assertEquals(max,max.betterSkiier(joe));	 
	  }
	  @Test
	  public void Betterskier2 () {
		  assertEquals(carl,carl.betterSkiier(joe));
	  }
//////test for has beaten////////////
	  @Test
	  public void maxHasBeatenJoe () {	  
		  assertTrue(max.hasBeaten(joe));
	  }
	  @Test
	  public void carlHasBeatenJoe () {
		  assertTrue(carl.hasBeaten(joe));
	  }
	  @Test 
	  public void bestRoundjoe () {
		  assertEquals(fiveHit,joeShoot.bestRound());	  	 
	  }
 
	  @Test 
	  public void bestRoundmax () {
		  assertEquals(fiveHit,maxShoot.bestRound());	  	 
	  }
// test on shooting DNF
	  @Test 
	   public void ShootingDNF () {

		 LinkedList<Athlete> ListOfAthletes1 = new LinkedList<Athlete>();
		 ListOfAthletes1.add(carl);
		 ListOfAthletes1.add(joe);
		 ListOfAthletes1.add(max);
		  
		 Competition FirstComp = new Competition(4,ListOfAthletes1); 
		 LinkedList<String> ListOfAthletes2 = new LinkedList<String>();
		 ListOfAthletes2.add("carl");
		 ListOfAthletes2.add("joe");
		 ListOfAthletes2.add("max");
		 assertEquals(ListOfAthletes2,FirstComp.shootingDNF()); 
	  }
	 
	  @Test 
	  public void ShootingDNF2 () {
		
		  
		  LinkedList<Athlete> ListOfAthletes1 = new LinkedList<Athlete>();
		  ListOfAthletes1.add(carl);
		  ListOfAthletes1.add(joe);
		  ListOfAthletes1.add(max);
		  
		 Competition FirstComp = new Competition(3,ListOfAthletes1); 
		 LinkedList<String> ListOfAthletes2 = new LinkedList<String>();
		  ListOfAthletes2.add("carl");
		 assertEquals(ListOfAthletes2,FirstComp.shootingDNF()); 
	  }
 // tests on skiing score for athlete
	  @Test 
	  public void skiingScoreForAthleteTest1() {
		  
		  LinkedList<Athlete> ListOfAthletes1 = new LinkedList<Athlete>();
		  ListOfAthletes1.add(carl);
		  ListOfAthletes1.add(joe);
		  ListOfAthletes1.add(max);
		  
		 Competition FirstComp = new Competition(3,ListOfAthletes1); 


		 assertEquals(46,FirstComp.skiingScoreForAthlete("max"), 0.1);
	  }
	  @Test 
	  public void skiingScoreForAthleteTest2() {
		  
		  LinkedList<Athlete> ListOfAthletes1 = new LinkedList<Athlete>();
		  ListOfAthletes1.add(carl);
		  ListOfAthletes1.add(joe);
		  ListOfAthletes1.add(max);
		  
		 Competition FirstComp = new Competition( 3,ListOfAthletes1); 		
		 assertEquals(113, FirstComp.skiingScoreForAthlete("carl"), 0.1); 
	  }
// test on any skiing improvement 
	  @Test 
	  public void anySkiingImprovementTest1() {

		 Competition FirstComp = new Competition( 3,ListOfAthletes1); 
		 Competition SecondComp = new Competition(3,ListOfAthletes2); 
		 assertFalse(SecondComp.anySkiingImprovement(FirstComp)); 
	  }
	  @Test 
	  public void anySkiingImprovementTest3() {

		  ///Second Competition Scores 
		 LinkedList<ShootingRound>  joeRounds2 = new LinkedList<ShootingRound> ();
		 joeRounds2.add(fiveHit);
		 joeRounds2.add(fiveHit);
		 joeRounds2.add(fiveHit);
		  ShootingResult joeShoot2 = new ShootingResult(joeRounds2);
		  SkiingResult joeSki2 = new SkiingResult (18,2,joeShoot2);
		  Athlete joe2 = new Athlete (joeShoot2,joeSki2,"joe");
		  
		  LinkedList<ShootingRound>  maxRounds2 = new LinkedList<ShootingRound> ();
		  maxRounds2.add(fiveHit);
		  maxRounds2.add(fiveHit);
		  maxRounds2.add(fiveHit);
		  ShootingResult maxShoot2 = new ShootingResult(maxRounds2);
		  SkiingResult maxSki2 = new SkiingResult (16,1,maxShoot2);
		  Athlete max2 = new Athlete (maxShoot2,maxSki2,"max");
		  
		  LinkedList<ShootingRound>  carlRounds2 = new LinkedList<ShootingRound> ();
		  carlRounds2.add(fiveHit);
		  carlRounds2.add(fiveHit);
		  carlRounds2.add(fiveHit);
		  ShootingResult carlShoot2 = new ShootingResult(carlRounds2);
		  SkiingResult carlSki2 = new SkiingResult (20,3,carlShoot2); 
		  Athlete carl2 = new Athlete (carlShoot2,carlSki2,"carl");
		  
		  
		  LinkedList<Athlete> ListOfAthletes2 = new LinkedList<Athlete>();
		  ListOfAthletes2.add(carl2);
		  ListOfAthletes2.add(joe2);
		  ListOfAthletes2.add(max2);
		 
		  Competition FirstComp = new Competition(3,ListOfAthletes1);
		  Competition SecondComp = new Competition(3,ListOfAthletes2);
		  
		 
		 assertTrue(SecondComp.anySkiingImprovement(FirstComp)); 
	  }
 
 
}