import org.junit.Test;

public class DeliveryBoySimulator_test {

    @Test
    public void testConUnDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(1, 2, 300.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));

        System.out.println("Test con un delivery boy");
        dbs.start();

    }

    @Test
    public void testConDosDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(2, 2, 300.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));

        System.out.println("Test con dos delivery boys");
        dbs.start();
    }

    @Test
    public void testConTresDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(3, 2, 300.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));

        System.out.println("Test con tres delivery boys");
        dbs.start();
    }

}
