import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliveryBoySimulator_test {
    static private final Logger log = LoggerFactory.getLogger(DeliveryBoySimulator.class);



    @Test
    public void testConUnDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(1, 2, 500.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));

        log.info("Test con un delivery boy");
        dbs.start();

    }

//    @Test
//    public void testConDosDeliveryBoys() {
//        DeliveryBoySimulator dbs2 =
//                new DeliveryBoySimulator(2, 2, 500.0,
//                        new FdpTA(1.0, 15.0, 0.0),
//                        new FdpIA(1.0, 5.0, 0.0));
//
//        log.info("Test con dos delivery boys");
//        dbs2.start();
//    }
//
//    @Test
//    public void testConTresDeliveryBoys() {
//        DeliveryBoySimulator dbs3 =
//                new DeliveryBoySimulator(3, 2, 300.0,
//                        new FdpTA(1.0, 15.0, 0.0),
//                        new FdpIA(1.0, 5.0, 0.0));
//
//        log.info("Test con tres delivery boys");
//        dbs3.start();
//    }

}
