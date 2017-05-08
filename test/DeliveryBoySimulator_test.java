import static org.junit.Assert.*;

import org.junit.Test;

public class DeliveryBoySimulator_test {

	@Test
	public void test() {
		DeliveryBoySimulator dbs = 
				new DeliveryBoySimulator(3,2,300.0,
						                new FDP(1.0,15.0,0.0),
						                new FDP(1.0,5.0,0.0));
		
		dbs.start();
	} 

}
