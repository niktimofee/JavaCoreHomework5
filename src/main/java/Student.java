import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        List<Student> result = students.stream()
                .filter(student -> "Informatics".equals(student.specialty))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                .limit(5)
                .collect(Collectors.toList());

        for (Student student : result) {
            System.out.println(student.name + ": " + student.getAverageGrade());
        }
    }
}