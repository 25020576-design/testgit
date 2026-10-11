
class ArrayUntils {
    public static <T> void swap(T[] array, int i, int j) {
        T c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[i]) > 0) {
                    swap(array, j, i);
                }
            }
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Student other) {
        return Double.compare(this.score, other.score);
    }

    public String toString() {
        return name + " - " + score;
    }
}


public class Main {
    public static void main(String[] args) {

        Integer[] numbers = {5, 1, 3, 2};
        ArrayUntils.sort(numbers);

        System.out.println("Integer:");
        for (Integer n : numbers) {
            System.out.print(n + " ");
        }

        System.out.println("\n\nString:");
        String[] languages = {"Java", "C++", "Python"};
        ArrayUntils.sort(languages);

        for (String language : languages) {
            System.out.print(language + " ");
        }

        System.out.println("\n\nStudent:");
        Student[] students = {
            new Student("An", 8.5),
            new Student("Binh", 7.0),
            new Student("Cuong", 9.0)
        };

        ArrayUntils.sort(students);

        for (Student s : students) {
            System.out.println(s);
        }
    }
}

