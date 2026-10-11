

import java.util.*;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

interface Operation<T> {
    T execute(T a, T b);
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().trim().split("\\s+");

            String id = data[0];
            String name = data[1];
            double gpa = Double.parseDouble(data[2]);

            students.add(new Student(id, name, gpa));
        }

        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        students.forEach(System.out::println);

        students.sort((s1, s2) ->
            s1.getName().compareTo(s2.getName())
        );

        System.out.println("After sorting by name:");
        students.forEach(System.out::println);

        //Operation<Double> add = (a, b) -> a + b;
        Operation<Double> add = new Operation<>() {
            public Double execute(Double a, Double b) {
                return a + b;
            }
        };
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> a / b;

        double a = 10.0;
        double b = 2.0;

        System.out.println("Addition: " + add.execute(a, b));
        System.out.println("Subtraction: " + subtract.execute(a, b));
        System.out.println("Multiplication: " + multiply.execute(a, b));

        if (b != 0.0) {
            System.out.println("Division: " + divide.execute(a, b));
        } else {
            System.out.println("Cannot divide by zero");
        }

        sc.close();
    }
}
