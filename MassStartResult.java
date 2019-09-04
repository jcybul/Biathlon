
public class MassStartResult  extends AbsMassAndSki {

MassStartResult (double time,int position){
super(time,position);
}
// gives the points earned on this competition, in this case is the same as time 
public double pointsEarned() {
	return this.time; 
} 

}


