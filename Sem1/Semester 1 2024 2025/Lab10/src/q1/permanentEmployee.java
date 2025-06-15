
package q1;


public class permanentEmployee extends employee{
    char type;
    
    public void setType(char type){
        this.type = type;
    }
    
    
    @Override
    public void Name(){
        
    }
    
    @Override
    public void EmployeeType(){
        this.employeeType = "Permanent Employee";
    }
    
    @Override
    public void Salary(){
        switch (type) {
            case 'A':
                this.salary = 4000.00;
                break;
            case 'B':
                this.salary = 3000.00;
                break;
            case 'C':
                this.salary = 2000.00;
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
    
    
}
