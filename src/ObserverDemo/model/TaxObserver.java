/**
 * 
 */
package ObserverDemo.model;

/**
 * @author Nanda
 *
 */
public class TaxObserver extends Observer {
	
	public TaxObserver(Employee employee) {
		this.employee = employee;
		this.employee.attach(this);
	}
	
	public void update() {
		System.out.println("Tax value is: " + (employee.getSalary() * 0.10));
	}

}
