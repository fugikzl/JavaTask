package PlaneComponent;
public abstract class PlaneComponent {

    public PlaneComponent(int weight, int volume, String name)
    {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
    }

    private int weight;
    private int volume;
    private String name;

    public int getWeight()
    {
        return this.weight;
    }
    public int getVolume()
    {
        return this.volume;
    }
    public String getName()
    {
        return this.name;
    }
}
