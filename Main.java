import PlaneComponent.Wing.Wing;
import PlaneComponent.Engine.Engine;
import PlaneComponent.Frame.Frame;

import java.sql.*;
import java.util.Scanner;


public class Main {
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

        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            con = DriverManager.getConnection(connectionUrl, "postgres", "3125");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            String sql = "INSERT INTO planesengine(name,power, weight, volume) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, engine.getName());
            st.setDouble(2, engine.getPower());
            st.setInt(3, engine.getWeight());
            st.setInt(4, engine.getVolume());

            st.execute();
            try {
                st.close();
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }

        // Input parameters for Wing class
        System.out.println("Enter parameters for Wing:");
        System.out.print("Name: ");
        String wingName = sc.nextLine();

        float wingAirResistance;
        while (true) {
            System.out.print("Air resistance coefficient: ");
            String input = sc.nextLine();
            try {
                wingAirResistance = Float.parseFloat(input);
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

        // Input parameters for Frame class
        System.out.println("Enter parameters for Frame:");
        System.out.print("Name: ");
        String frameName = sc.nextLine();
        float frameAirResistance;
        while (true) {
            System.out.print("Air resistance coefficient: ");
            String input = sc.nextLine();
            try {
                frameAirResistance = Float.parseFloat(input);
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

        // Create Plane object with input parameters
        Plane plane = new Plane(engine, frame, wing);

        // Output plane information
        plane.getPlaneInfo();
    }
}
