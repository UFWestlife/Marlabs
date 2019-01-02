/**
 * 
 */
package ObserverDemo.model;

/**
 * @author Nanda
 *
 */
public class HRObserver extends Observer {
	public HRObserver(Employee employee) {
		this.employee = employee;
		this.employee.attach(this);
	}
	
	public void update() {
		if(employee.getSalary() > 9500)
			System.out.println("You will get a higher designation!");
		else
			System.out.println("Only your role will change as the sal is < 9500");
	}
}
