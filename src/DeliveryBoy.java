/**
 * Created by anicolasgarcia on 5/8/17.
 */
public class DeliveryBoy {
    private double TPS=0;
    private boolean highValue;

    public DeliveryBoy() {
        this.highValue=true;
    }

    public Double getTPS() {
        return TPS;
    }

    public void setTPS(Double TPS) {
        this.TPS = TPS;
    }

    public boolean isHighValue() {
        return highValue;
    }

    public void setHighValue(boolean highValue) {
        this.highValue = highValue;
    }
}
