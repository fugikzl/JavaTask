package PlaneComponent.Wing;
import PlaneComponent.PlaneComponent;

public class Wing extends PlaneComponent implements IWing{
    
    private double airResistanceCoeficcent;

    public Wing(String name, double airResistanceCoeficcent, int weight, int volume)
    {
        super(weight, volume, name);
        this.airResistanceCoeficcent = airResistanceCoeficcent;
    }

    public double getAirResistanceCoefficent()
    {
        return this.airResistanceCoeficcent;
    }

}
