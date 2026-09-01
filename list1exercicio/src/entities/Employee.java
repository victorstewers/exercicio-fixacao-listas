package entities;

public class Employee {
    private Integer id; 
    private String name;
    private Double salary;
    
    public Employee(){
    }

    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId(){
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getSalary(){
        return this.salary;
    }
    public void increaseSalary(Double increase){
        this.salary+=salary*(increase/100.0);
    }

    @Override
    public String toString() {
        return this.id+", "+this.name+", "+String.format("%.2f",this.salary);
    }
    

}
