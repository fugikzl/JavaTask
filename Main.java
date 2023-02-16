import PlaneComponent.Wing.Wing;
import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;

import java.sql.*;
import java.util.Scanner;


public class Main {
    static String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
    static PreparedStatement st = null;
    static Connection con = null;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Input parameters for Engine class
        System.out.println("Enter parameters for Engine:");
        System.out.print("Name: ");
        String engineName = sc.nextLine();
        System.out.print("Power: ");
        int enginePower = sc.nextInt();
        System.out.print("Weight: ");
        int engineWeight = sc.nextInt();
        System.out.print("Volume: ");
        int engineVolume = sc.nextInt();
        Engine engine = new Engine(engineName, enginePower, engineWeight, engineVolume);
        sc.nextLine(); // Consume leftover newline character
        connectionToDB();
        addEngine(engineName, enginePower, engineWeight, engineVolume);
        disconnectionOfDB();

        // Input parameters for Wing class
        System.out.println("Enter parameters for Wing:");
        System.out.print("Name: ");
        String wingName = sc.nextLine();

        double wingAirResistance;
        while (true) {
            System.out.print("Air resistance coefficient: ");
            String input = sc.nextLine();
            try {
                wingAirResistance = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }

        System.out.print("Weight: ");
        int wingWeight = sc.nextInt();
        System.out.print("Volume: ");
        int wingVolume = sc.nextInt();
        Wing wing = new Wing(wingName, wingAirResistance, wingWeight, wingVolume);
        sc.nextLine(); // Consume leftover newline character
        connectionToDB();
        addWing(wingName, wingAirResistance, wingWeight, wingVolume);
        disconnectionOfDB();

        // Input parameters for Frame class
        System.out.println("Enter parameters for Frame:");
        System.out.print("Name: ");
        String frameName = sc.nextLine();
        double frameAirResistance;
        while (true) {
            System.out.print("Air resistance coefficient: ");
            String input = sc.nextLine();
            try {
                frameAirResistance = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
            }
        }
        System.out.print("Weight: ");
        int frameWeight = sc.nextInt();
        System.out.print("Capacity: ");
        int frameCapacity = sc.nextInt();
        Frame frame = new Frame(frameName, frameAirResistance, frameWeight, frameCapacity);
        sc.nextLine(); // Consume leftover newline character
        connectionToDB();
        addFrame(frameName, frameAirResistance, frameWeight, frameCapacity);
        disconnectionOfDB();

        // Create Plane object with input parameters
        Plane plane = new Plane(engine, frame, wing);

        // Output plane information
        plane.getPlaneInfo();
    }

    public static void connectionToDB(){
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "3125");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void disconnectionOfDB(){
        try {
            st.close();
            con.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println("Success!");
        }
    }
    public static void addEngine(String name, double power, int weight, int volume) throws SQLException {
        String sql = "INSERT INTO planesengine(name,power, weight, volume) VALUES (?,?,?,?)";
        st = con.prepareStatement(sql);

        st.setString(1, name);
        st.setDouble(2, power);
        st.setInt(3, weight);
        st.setInt(4, volume);

        st.execute();
    }
    public static void addWing(String name, double airResistance, int weight, int volume) throws SQLException {
        String sql = "INSERT INTO planeswing(name,airresistance, weight, volume) VALUES (?,?,?,?)";
        st = con.prepareStatement(sql);

        st.setString(1, name);
        st.setDouble(2, airResistance);
        st.setInt(3, weight);
        st.setInt(4, volume);

        st.execute();
    }
    public static void addFrame(String name, double airResistance, int weight, int capacity) throws SQLException {
        String sql = "INSERT INTO planesframe(name,airresistance, weight, capacity) VALUES (?,?,?,?)";
        st = con.prepareStatement(sql);

        st.setString(1, name);
        st.setDouble(2, airResistance);
        st.setInt(3, weight);
        st.setInt(4, capacity);

        st.execute();
    }
}

