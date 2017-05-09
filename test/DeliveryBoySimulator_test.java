import org.junit.Test;

public class DeliveryBoySimulator_test {

    @Test
    public void testConCincuentaDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(50, 2, 500.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
//                        new FdpTA(-1.6, 17.81, 7.88),
//                        new FdpIA(0.65, 6.94, 3.03));

        System.out.println("Test con cincuenta delivery boy");
        dbs.start();

    }

    @Test
    public void testConDiezDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(10, 2, 500.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
//                        new FdpTA(-1.6, 17.81, 7.88),
//                        new FdpIA(0.65, 6.94, 3.03));

        System.out.println("Test con diez delivery boys");
        dbs.start();
    }

    @Test
    public void testConUnDeliveryBoy() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(1, 1, 500.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
//                        new FdpTA(-1.6, 17.81, 7.88),
//                        new FdpIA(0.65, 6.94, 3.03));

        System.out.println("Test con un delivery boy");
        dbs.start();
    }

}
