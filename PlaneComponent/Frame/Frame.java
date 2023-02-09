package PlaneComponent.Frame;
import PlaneComponent.PlaneComponent;

public class Frame extends PlaneComponent implements IFrame {

    private double airResistanceCoeficcent;
    private int capacity;

    public Frame(String name, double airResistanceCoeficcent, int weight, int capacity)
    {
        super(weight, 0, name);
        this.capacity = capacity;
        this.airResistanceCoeficcent = airResistanceCoeficcent;
    }

    public int getCapacity()
    {
        return this.capacity;
    }

    public double getAirResistanceCoefficent()
    {
        return this.airResistanceCoeficcent;
    }

}
