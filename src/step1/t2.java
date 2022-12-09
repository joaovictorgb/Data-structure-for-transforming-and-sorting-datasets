package step1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class t2 {
	
	String station[] = new String[31];
	public t2() throws IOException{
	//Create the archive for facility the program 
		File pasadena = new File("pivot_stations.csv");
		Scanner initialLogPasadena = null;
		//ADD To top line in the space of memory[0]i++
		initialLogPasadena = new Scanner(pasadena);
		initialLogPasadena.nextLine(); 
		int i = 0;			
		while(initialLogPasadena.hasNext()) {
			this.station[i] = initialLogPasadena.nextLine().toString(); 
			++i;
		}				
	}
	public void newFile() {
    	File trips = new File("LAMetroTrips.csv");
		Scanner metroTrips = null;
		String lineTable, receiveTable;
		try (FileWriter writer = new FileWriter("LAMetroTrips_F1.csv", true)){
			metroTrips = new Scanner(trips); 
    		lineTable = metroTrips.nextLine();
    		writer.write(lineTable + "\n");
    		String[] stationsArchive;
    	// for learning of table with loop	
    		while(metroTrips.hasNextLine()) {
				lineTable = metroTrips.nextLine();
				receiveTable = getStations(lineTable, 9, 11);
				stationsArchive = receiveTable.split(","); 
				
				for(int i = 0; i < this.station.length; i++) {
					if((stationsArchive[0].equals(this.station[i])) || (stationsArchive[1].equals(this.station[i]))) {
						writer.write(lineTable + "\n");
						break;
					}
				} 
			}
    		writer.close();
		}
		catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
    } 
    private static String getStations(String line, int n, int m) {	
    	String linhaStations = "";
    	int count = 0;
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext() && (count <= m)) {
            	if((count >= n) && (count < m)) {
            		linhaStations += rowScanner.next().toString();
            		linhaStations += ",";
                    ++n;
                    ++count;
            	}
            	else {
            		rowScanner.next();
            		++count;
            	}
            } 
        }        
        return linhaStations;
    }
}
