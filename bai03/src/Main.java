
import java.util.Scanner;

interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

class OfficeWorker extends Employee {

    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculatePay() {
        return baseSalary;
    }

    public void work() {
        System.out.println("Soan thao van ban");
    }
}

class Technician extends Employee {
    private double overtimeHours;

    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    public void work() {
        System.out.println("Lap dat thiet bi");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Employee[] list = new Employee[n];

        for (int i = 0; i < n; i++) {
            String[] word = sc.nextLine().split(" ");

            String type = word[0];
            String id = word[1];
            String name = word[2];
            double baseSalary = Double.parseDouble(word[3]);

            if (type.equals("O")) {
                list[i] = new OfficeWorker(id, name, baseSalary);
            } 
            else if (type.equals("T")) {
                double overtimeHours = Double.parseDouble(word[4]);

                list[i] = new Technician(
                    id,
                    name,
                    baseSalary,
                    overtimeHours
                );
            }
        }

        double totalPay = 0;

        for (int i = 0; i < n; i++) {
            double pay = list[i].calculatePay();

            System.out.println(
                list[i].name + " - Pay: " + pay
            );

            list[i].work();

            totalPay += pay;
        }

        System.out.println("Total Pay = " + totalPay);

        sc.close();
    
    }
}

