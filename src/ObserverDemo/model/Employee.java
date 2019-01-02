/**
 * 
 */
package ObserverDemo.model;

import java.util.ArrayList;

/**
 * @author Nanda
 *
 */
public class Employee {
	
	double salary;
	
	ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
		notifyObservers();
	}
	
	public void notifyObservers() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
	
	public void attach(Observer obs) {
		observers.add(obs);
	}	

}
