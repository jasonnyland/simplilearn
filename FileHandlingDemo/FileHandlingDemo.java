package FileHandlingDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandlingDemo {
	
	public static void writeToFile(Person input) throws IOException {
		FileOutputStream fout = new FileOutputStream("data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(input);
		oos.close();
	}
	
	public static Person readFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fin = new FileInputStream("data.txt");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Person output;
		output = (Person)ois.readObject();
		ois.close();
		return output;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("writing to file");
		
		Person newGuy = new Person("steve","818-818-8118");
		writeToFile(newGuy);
		
		System.out.println("OK");
		
		Person saveData = readFromFile();
		System.out.println("read from file:" + saveData);
	}

}
