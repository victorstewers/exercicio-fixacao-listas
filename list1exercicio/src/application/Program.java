package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

//Ler um inteiro N e depois dados(id, nome, salario) de N funcionarios. Sem repetição de ID.
//Processar o aumento de X por cento no salário de um determinado funcionário. Para isso o Programa deve
//  ler um ID e o valor X. Caso ID nao exista, mostrar mensagem e abortar operação.
//Saida deve ser obrigatoriamente, com id ou nao, a lista atualizada dos funcionarios 
//Deve-se encapsular o salário, ou seja ser private, salário só pode ser aumentado com base na operação
// de aumento por porcentagem dada. 

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registred? ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("Employee #" + (i + 1));

            System.out.print("\nId: ");
            Integer id = sc.nextInt();
            while (checkId(list, id)) {
                System.out.println("ID already Taken! Try again!: ");
                id = sc.nextInt();
            }
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            
            list.add(new Employee(id, name, salary));
            System.out.println();
        }

        System.out.print("Enter the employee id that will have salary increase:");
        int newSalaryId = sc.nextInt();
        Employee employee = list.stream().filter(x -> x.getId().equals(newSalaryId)).findFirst().orElse(null);

        if (employee!=null) {
            System.out.print("Enter the percentage: ");
            double salaryIncrease = sc.nextDouble();
            employee.increaseSalary(salaryIncrease);
        } else {
            System.out.println("This id does not exist!");
        }
        System.out.println();
        System.out.println("List of employees:");
        for (Employee x : list) {
            System.out.println(x.toString());

        }
        sc.close();
    }

    public static boolean checkId(List<Employee> employees, Integer id) {
        Employee employee = employees.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return employee != null;
    }
    //Alternativa ao método com lambda/predicado.
    /*public static Integer position(List<Employee> list, int id){
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getId() == id) {
                return i;
            }
        }
        return null
    }
    */
}
