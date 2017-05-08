/**
 * Created by anicolasgarcia on 5/8/17.
 */
public abstract class Fdp {
	Double a;
	Double b;
	Double m;
 
   public Fdp(Double a, Double b, Double m){
	   this.a = a;
	   this.b = b;
	   this.m = m;
   }
   
   public abstract Double get();
}




