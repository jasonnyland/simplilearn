package FileHandlingDemo;

import java.io.Serializable;

public class Person implements Serializable {
	@Override
	public String toString() {
		return "Person [name=" + name + ", number=" + number + "]";
	}
	String name;
	String number;
	public Person(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
}