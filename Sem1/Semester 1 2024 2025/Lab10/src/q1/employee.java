
package q1;


public abstract class employee {
    String name;
    String employeeType;
    double salary;
    
    public abstract void Name();
    public abstract void EmployeeType();
    public abstract void Salary();
    
    @Override
    public String toString(){
        return "Name: " + name 
        + "Employee Type: " + employeeType 
        + "Salary" + salary ;
                
    }
}
