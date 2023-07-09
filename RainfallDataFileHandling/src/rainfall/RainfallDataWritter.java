package rainfall;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * The RainfallDataCreator class is responsible for creating a set of rainfall data
 * and storing it in a text file using java.io.Writer.
 */
public class RainfallDataWritter {
    private String fileName;
    private String stationName;
    private String district;
    private int[] rainfallData;

    /**
     * Constructs a RainfallDataCreator object with the specified parameters.
     *
     * @param fileName      the name of the file to store the rainfall data
     * @param stationName   the name of the weather station
     * @param district      the district where the weather station is located
     * @param rainfallData  an array of integer values representing the rainfall data
     */
    public RainfallDataWritter(String fileName, String stationName, String district, int[] rainfallData) {
        this.fileName = fileName;
        this.stationName = stationName;
        this.district = district;
        this.rainfallData = rainfallData;
    }

    /**
     * Creates the rainfall data file and stores the data using java.io.Writer.
     * The data includes the station name, district, and the rainfall readings.
     */
    public void createRainfallData() {
        try (Writer writer = new FileWriter(fileName)) {
            writer.write(stationName + "\n");
            writer.write(district + "\n");

            writer.write(String.valueOf(rainfallData.length) + "\n");

            for (int rainfall : rainfallData) {
                writer.write(String.valueOf(rainfall) + "\n");
            }

            System.out.println("Successfully created the data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method creates an instance of RainfallDataCreator and calls the
     * createRainfallData() method to create the rainfall data file.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        String fileName = "rainfall_data.txt"; // File location
        String stationName = "Durian Tunggal"; // Station name
        String district = "Alor Gajah"; // District
        int[] rainfallData = { 0, 0 , 0, 26, 3, 1 }; // Rainfall data of Alor Gajah in 6 days

        RainfallDataWritter dataCreator = new RainfallDataWritter(fileName, stationName, district, rainfallData);
        dataCreator.createRainfallData();
    }
}
