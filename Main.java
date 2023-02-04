import PlaneComponent.Wing.Wing;
import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;


class Main {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine("test", 45000, 450, 450);
        Wing wing = new Wing("testWing", 0.869, 600, 1000);
        Frame frame = new Frame("testFrame", 0.45, 1200, 1450);
        
        Plane plane = new Plane(engine, frame, wing);

        plane.getPlaneInfo();
    }
}