package Java8_Features.defaultmethods;

public interface Transaction {
	
	default void printInfo() {
		System.out.println("From Transaction...");
	}

}
