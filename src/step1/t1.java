package step1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import step3.methods;

public class t1 {

	Scanner inputs = null;
	int idTable[] = new int[350];
	String nameTable[] = new String[350];
	int i = 0;
	String receiveTable;
	String colTable;
	String[] file = new String[1250835];
	public t1() throws IOException {
		File bikeSharing = new File("LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv");
		try (Scanner read = new Scanner(bikeSharing)) {
			this.colTable = read.nextLine().toString();
			int n = 0;
			String lineTable;

			while (read.hasNextLine()) {
				lineTable = read.nextLine().toString();
				this.file[n] = lineTable;
				++n;
			}
		}
	}

	public void archivestations() throws IOException {
		
		File stations = new File("stations.csv");
		this.inputs = new Scanner(stations);
		methods.readLinha(this.inputs.nextLine(), 0, 2);
		while (this.inputs.hasNextLine()) {
			;
			this.receiveTable = methods.readLinha(this.inputs.nextLine(), 0, 2);
			this.idTable[i] = Integer.parseInt(this.receiveTable.substring(0, 4));
			this.nameTable[i] = this.receiveTable.substring(4);
			++i;
		}
	}

	public void leMetroTrips() throws IOException {
		String receiveTable;
		String lineTable;
		int idinit, idfine;
		int j = 0;
		changeArchive(colTable, "start_station", "end_station");

		while (j < 1250835) {
			lineTable = file[j];
			receiveTable = methods.readLinha(lineTable, 9, 11);
			idinit = Integer.parseInt(receiveTable.substring(0, 4));
			idfine = Integer.parseInt(receiveTable.substring(4));
			++j;
			String start = "", end = "";
			for (i = 0; i < 350; i++) {
				if ((this.idTable[i] == idinit) || (this.idTable[i] == idfine)) {
					if ((this.idTable[i] == idinit) && (this.idTable[i] == idfine)) {
						start = this.nameTable[i];
						end = this.nameTable[i];
						i = 351;
					} else if (this.idTable[i] == idinit) {
						start = this.nameTable[i];
					} else if (this.idTable[i] == idfine) {
						end = this.nameTable[i];
					}
				}
				else if (i == 349) {
					if (start.equals("") || end.equals("")) {
						if (start.equals("") && end.equals("")) {
							start = "" + idinit;
							end = "" + idfine;
						} else if (start.equals(""))
							start = "" + idinit;
						else if (end.equals(""))
							end = "" + idfine;
					}
				}
			} 
			changeArchive(lineTable, start, end);
		} 
	}

	public void changeArchive(String line, String start, String end) { // id, (id, id)

		int n = 0;
		try (FileWriter writer = new FileWriter("LAMetroTrips.csv", true)) {
			StringBuilder addToCode = new StringBuilder();

			Scanner rowScanner = new Scanner(line);
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext() && (n < 16)) {
				if ((n == 9) || (n == 10)) {
					if (n == 9) {
						addToCode.append(start);
						rowScanner.next();
						addToCode.append(",");
					} else {
						addToCode.append(end);
						rowScanner.next();
						addToCode.append(",");
					}
				} else {
					addToCode.append(rowScanner.next());
					if (n != 15) {
						addToCode.append(",");
					}
				}
				++n;
			}
			addToCode.append("\n");
			writer.write(addToCode.toString());
			writer.close();
			rowScanner.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	} 

}
