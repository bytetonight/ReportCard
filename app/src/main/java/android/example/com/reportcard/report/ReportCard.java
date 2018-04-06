package android.example.com.reportcard.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by ByteTonight on 24.05.2017.
 * The restrictions of this course prohibit using multiple public top level classes
 * because that would require multiple files.
 * To still somehow stick to the Single Responsibility Design
 * and implement some abstraction (Sorry guys but "things" that have properties can't
 * be Strings or ints)
 * I am forced to make use of programming technique called MESS
 */

public class ReportCard {

    public static final String NEW_LINE = "\n";
    private School school;
    private Student student;
    private int year = 0;
    private List<GradedSubject> subjects = new ArrayList<>();

    public ReportCard(String school, int year, String studentName) {
        this.school = new School(school);
        this.year = year;
        this.student = new Student(studentName);
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return an integer value for a given year, or the current year
     */
    public int getYear() {
        Calendar currentCalender = Calendar.getInstance();
        int currentYear = currentCalender.get(Calendar.YEAR);

        if (year == 0) {
            year = currentYear;
        }

        return currentYear;
    }

    public void addGradedSubject(String name, String grade) {
        grade = grade.toUpperCase();
        if (Grades.contains(grade) && !name.isEmpty()) {
            subjects.add(new GradedSubject(name, Grades.valueOf(grade)));
        }
    }

    @Override
    public String toString() {
        String output =
                school + " Report " + String.valueOf(getYear()) + NEW_LINE +
                        "Student" + " " + student + NEW_LINE +
                        "Subjects" + NEW_LINE;

        if (subjects.size() > 0) {
            for (GradedSubject gradedSubject : subjects) {
                output += gradedSubject + NEW_LINE;
            }
        } else {
            output += "You have not added any graded Subjects.";
        }

        return output;
    }
}

enum Grades {
    A, B, C, D, E, F;

    public static boolean contains(String s) {
        for (Grades grade : values())
            if (grade.name().equals(s))
                return true;
        return false;
    }
}

class School {
    private String name;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/**
 * No a Student is not a String Object
 */
class Student {
    private String firstName = "";
    private String lastName = "";

    public Student(String fullName) {
        if (fullName.contains(" ")) {
            String after = fullName.trim().replaceAll(" +", " ");
            String[] partials = after.split(" ");
            firstName = partials[0];
            lastName = partials[1];
        } else {
            firstName = fullName;
        }
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

/**
 * A gradable Subject
 */
class GradedSubject {
    private String name;
    private Grades grade;

    public GradedSubject(String name, Grades grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " : Grade " + grade;
    }
}
