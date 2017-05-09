import org.junit.Test;

public class DeliveryBoySimulator_test {

    @Test
    public void testConCincuentaDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(5, 2, 240.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
        //  new FdpTA(-1.6, 17.81, 7.88),
        //  new FdpIA(0.65, 6.94, 3.03));

        System.out.println("CASO MAS OCIOSO: Test con 5 delivery boy ");
        dbs.start();

    }

    @Test
    public void testConDiezDeliveryBoys() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(2, 2, 240.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
        //  new FdpTA(-1.6, 17.81, 7.88),
        //  new FdpIA(0.65, 6.94, 3.03));

        System.out.println("CASO BALANCEADO: Test con 2 delivery boys");
        dbs.start();
    }

    @Test
    public void testConUnDeliveryBoy() {
        DeliveryBoySimulator dbs =
                new DeliveryBoySimulator(1, 2, 240.0,
                        new FdpTA(1.0, 15.0, 0.0),
                        new FdpIA(1.0, 5.0, 0.0));
        // new FdpTA(-1.6, 17.81, 7.88),
        // new FdpIA(0.65, 6.94, 3.03));

        System.out.println("CASO MENOS OCIOSO: Test con 1 delivery boy");
        dbs.start();
    }

}
