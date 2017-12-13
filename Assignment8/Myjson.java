/* Good Work
 * Total score 10
 */
import java.util.*;
import java.io.*;

public class MyJson {
  private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException {
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    FileReader reader = new FileReader(file);
    BufferedReader br = new BufferedReader(reader);

    String line;

    while (true) {
      line = br.readLine();
      if (line == null) {
        break;
      }

      String[] carInfo = line.split("~");
      Vehicle vehicle = new Vehicle(carInfo);
      vehicles.add(vehicle);
    }
    br.close();
    reader.close();

    return vehicles;
  }

  public static String getJsonString(ArrayList<Vehicle> vehicles) {
    StringBuilder sb = new StringBuilder();
    int count = 0;

    sb.append("{\n" + "\"gmps-camino\" : [\n");
    for (Vehicle v: vehicles) {
      sb.append(v.toString());
      if (count == vehicles.size()) {
        sb.append('\n')
      }
      else {
          sb.append(',\n');
      }
    }
    sb.append("]\n}");

    return sb.toString();
  }

  public static void writeToFile(String inputToWrite, String filePath) {
    FileWriter writer = new FileWriter(filePath + "json.txt");
    writer.write(inputToWrite);
    writer.close();
  }

  public static void main(String[] args) throws IOException{
    File file = new File("your file path");
    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
    String s = getJsonString(vehicles);
    writeToFile(s, file.getParent());
  }
}
