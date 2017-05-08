import java.util.Random;

public class FDP {
	Double a;
	Double b;
	Double m;
 
   public FDP(Double a, Double b, Double m){
	   this.a = a;
	   this.b = b;
	   this.m = m;
   }
   
   public Double get(){ 
	   Random r = new Random();
	   return ( ( r.nextDouble() * (b - a) ) + a );
   }
}
