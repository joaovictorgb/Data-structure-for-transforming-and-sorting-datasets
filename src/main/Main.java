package main;

import java.io.IOException;
import java.util.Scanner;
import step1.t1;
import step1.t2;
import step1.t3;
import step2.o1;
import step2.o2;
import step2.o3;

public class Main {
	public static void main(String args[]) {
		try {
			Scanner entrada = new Scanner(System.in);

			System.out.print("Informe o numero 1 para começar as transformações ou 0 para sair:\n ");
			int numero = entrada.nextInt();
			if (numero == 1) {
			try (Scanner leitor = new Scanner(System.in)) {
				System.out.println(
						"------------------Menu-------------\nOs arquivos da 1° etapa-Transformação estão sendo gerados\nPode levar alguns minutos\nDepois de gerar vai aparecer abaixo para fazer as ordenações, ok?\nGerando ....");
				t1 trans1 = new t1();
				trans1.archivestations();
				trans1.leMetroTrips();
				t2 trans2 = new t2();
				trans2.newFile();
				t3 trans3 = new t3();
				trans3.newFile2();

				System.out.println("Finalizado com sucesso, conferir na pasta\nVamos para as ordenações agora...\n");

				int display = 0;
				int size = 0;
				do {
					System.out.println("Para ordenar tem três formas: 1°, 2°, 3° ,digite o número correspondente:");
					System.out.println("\n1 - -\n2 - \n3 -\n4 - exit");
					display = leitor.nextInt();
					System.out.println(
							"Deseja ordenar em quantas linhas? (max value is: 1250836): ");
					size = leitor.nextInt();

				
						if(display==1){
						
							o1 stepOne = new o1();
							stepOne.allMediumCases();
							stepOne.insertionFiles(size);
							stepOne.selectionFiles(size);
							stepOne.mergeSortFiles();
							stepOne.quickSortFiles();
							stepOne.heapSortFiles(size);
						}
						else if (display==2){
						
							o2 steptwo = new o2();
							steptwo.allMediumCases();
							steptwo.countingFiles();
							steptwo.mergeSortFiles();
							steptwo.insertionFiles(size);
							steptwo.selectionFiles(size);
							steptwo.heapSortFiles();
							steptwo.quickSort3tFiles(size);
							steptwo.quickSortFiles(size);
						}
						
						else if (display== 3){
							o3 stepthree = new o3();
							stepthree.allMediumCases();
							stepthree.heapSortFiles(size);
							stepthree.insertionFiles(size);
							stepthree.selectionFiles(size);
							stepthree.quickSortFiles(size);
							stepthree.quickSort3tFiles(size);
							stepthree.mergeSortFiles(size - 1);
						}
						
						else if (display==4){
							System.out.println("Sua ordenação foi finalizada !");
						}
						else{
							System.out.println("Opção não corresponde");
						}
					
				} while (display < 4 && display > 0);
			}}
		} catch (IOException e) {
			System.out.println("Erro detectado, reinicie o processo!\n");
			System.out.println(e);
		}
	}
}
