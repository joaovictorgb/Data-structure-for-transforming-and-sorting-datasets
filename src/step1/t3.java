package step1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import step3.methods;
public class t3 {
	double meanValue;
	public t3() throws FileNotFoundException {
		double sum = 0D;
		int count = 0;
		File metroTrips = new File("LAMetroTrips.csv");
		Scanner metroTime = null;
		String lineTable;
		metroTime = new Scanner(metroTrips);
		metroTime.nextLine(); 
		//Is using for read about the line trips and time of roads		
		while(metroTime.hasNextLine()) {
			lineTable = metroTime.nextLine();
			sum += Integer.parseInt(methods.readLinha(lineTable, 1, 2));//searchTime(lineTable);
			++count;
		}
		this.meanValue = sum / count;
	} //Using for creat the method initial for read and change
	public void newFile2() {
		int number;
		try (FileWriter writer = new FileWriter("LAMetroTrips_F2.csv", true)){
			File metroTrips = new File("LAMetroTrips.csv");
			Scanner metroTime = null;
			String lineTable;
			metroTime = new Scanner(metroTrips);
			lineTable = metroTime.nextLine(); 
			writer.write(lineTable + "\n");		
    		while(metroTime.hasNextLine()) {
    			lineTable = metroTime.nextLine();
				number = Integer.parseInt(methods.readLinha(lineTable, 1, 2));//searchTime(lineTable);
				if(number > meanValue) {
					writer.write(lineTable + "\n");
				}
				
			} 
    		writer.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}


