/**
 * 
 */
package ObserverDemo.demo;

import ObserverDemo.model.Employee;
import ObserverDemo.model.HRObserver;
import ObserverDemo.model.TaxObserver;

/**
 * @author Nanda
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee();
		
		TaxObserver obs1 = new TaxObserver(emp);
		HRObserver obs2 = new HRObserver(emp);
		
		System.out.println("About to set the salary....");
		emp.setSalary(5000.00);
		
		System.out.println("About to change the salary...");
		emp.setSalary(10000.00);		

	}

}
