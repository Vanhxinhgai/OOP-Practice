package W4.B6_UniversalSorter;

class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T> void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return name + "(" + gpa + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {5, 1, 3, 2};
        ArrayUtils.sort(numbers);
        ArrayUtils.print(numbers);

        String[] languages = {"Java", "C++", "Python"};
        ArrayUtils.sort(languages);
        ArrayUtils.print(languages);

        Student[] students = {
                new Student("An", 3.2),
                new Student("Binh", 2.8),
                new Student("Chi", 3.6)
        };
        ArrayUtils.sort(students);
        // ArrayUtils.print(students);   // bỏ dấu // nếu muốn xem kết quả
    }
}
