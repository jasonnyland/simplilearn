import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {

	
	static void printTitle() {
		System.out.println("--------------------------------------");
		System.out.println(" File Operator Program - Jason Nyland ");
		System.out.println("--------------------------------------");
	}
	
	static int mainMenu() {
		System.out.println("\n1) List Files");
		System.out.println("2) File Operations");
		System.out.println("3) Exit");
		System.out.println("Make a selection: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		if (selection != 1 && selection != 2 && selection != 3) {
			System.out.println("Not recognized.  Please try again.");
			return mainMenu();
		} else {
			return selection;
		}
	}
	
	static int fileMenu() {
		System.out.println("\n1) Add a file");
		System.out.println("2) Delete a file");
		System.out.println("3) Search for a file");
		System.out.println("4) Back");
		System.out.println("Make a selection: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		if (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
			System.out.println("Not recognized.  Please try again.");
			return fileMenu();
		} else {
			return selection;
		}
	}
	

	public static void main(String[] args) throws IOException {

		printTitle();
		
		boolean done = false;
		Scanner scan = new Scanner(System.in);
		
		do {
			
			switch(mainMenu()) {
			case 1:
				System.out.println("------- File Listing -------");
				Files.list(Paths.get("."))
		        	.forEach(x -> {
		        		System.out.println(x.toString().substring(2));
		        	});
				System.out.println("----------------------------");
				break;
			case 2:
				
				switch(fileMenu()) {
				case 1:
					System.out.println("Enter a filename to create:");
					String nameToCreate = scan.next();
					File newFile = new File(nameToCreate);
					
					if (newFile.createNewFile()) {
						System.out.println("The file was created.");
					} else {
						System.out.println("The file already exists.");
					}
					break;
				case 2:
					System.out.println("Enter a filename to delete:");
					String nameToDelete = scan.next();
					File delFile = new File(nameToDelete);
					if (delFile.delete()) {
						System.out.println("The file was deleted.");
					} else {
						System.out.println("The file could not be deleted.");
					}
					break;
				case 3:
					System.out.println("Enter a filename to search for:");
					String nameToFind = scan.next();
					File findFile = new File(nameToFind);
					System.out.println((findFile.exists()) ? "File exists" : "File does not exist");
					break;
				case 4:
					//go back
					break;
				default:
					break;			
				}
				
				break;
			case 3:
				done = true;
				break;
			default:
				break;
			}
			
			
			
		} while (!done);
		
		
		
	}

}
