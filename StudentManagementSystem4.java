import java.io.*;
import java.util.*;

// ======================= Student Class ===========================
class Student {
    private int rollNo;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }
}

// ======================= FileUtil Class ===========================
class FileUtil {

    // Read students from file
    public static ArrayList<Student> readStudents(String filename) {
        ArrayList<Student> list = new ArrayList<>();

        File file = new File(filename);
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Exists: " + file.exists());
        System.out.println("File Size: " + file.length() + " bytes");

        if (!file.exists()) {
            return list; // empty
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            System.out.println("Loaded students from file:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    int roll = Integer.parseInt(data[0]);
                    String name = data[1];
                    String email = data[2];
                    String course = data[3];
                    double marks = Double.parseDouble(data[4]);

                    Student s = new Student(roll, name, email, course, marks);
                    list.add(s);

                    s.display();
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return list;
    }

    // Write students to file
    public static void writeStudents(String filename, ArrayList<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("Data saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // RandomAccessFile demonstration
    public static void readRandom(String filename) {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            System.out.println("\nReading some random bytes from file:");
            byte[] buffer = new byte[20];
            raf.seek(0);  // Move to start
            raf.read(buffer);

            System.out.println(new String(buffer));
        } catch (Exception e) {
            System.out.println("RandomAccessFile Error: " + e.getMessage());
        }
    }
}

// ======================= StudentManager ===========================
class StudentManager {

    private ArrayList<Student> list = new ArrayList<>();
    private HashMap<String, Student> map = new HashMap<>();
    private final String filename = "students.txt";

    public StudentManager() {
        list = FileUtil.readStudents(filename); // load from file

        for (Student s : list) {
            map.put(s.getName().toLowerCase(), s);
        }

        FileUtil.readRandom(filename); // random read demo
    }

    // Add student
    public void addStudent(Student s) {
        list.add(s);
        map.put(s.getName().toLowerCase(), s);
        System.out.println("Student added successfully!");
    }

    // View all
    public void viewAll() {
        if (list.isEmpty()) {
            System.out.println("No record found.");
            return;
        }
        
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            s.display();
            System.out.println("------------------------");
        }
    }

    // Search
    public void searchByName(String name) {
        Student s = map.get(name.toLowerCase());
        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete
    public void deleteByName(String name) {
        Student s = map.remove(name.toLowerCase());
        if (s != null) {
            list.remove(s);
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Sort by marks
    public void sortByMarks() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Double.compare(b.getMarks(), a.getMarks()); // descending
            }
        });

        System.out.println("Sorted Student List by Marks:");
        viewAll();
    }

    // Save to file
    public void saveToFile() {
        FileUtil.writeStudents(filename, list);
    }
}

// ======================= MainApp / Menu ===========================
public class StudentManagementSystem4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    Student s = new Student(roll, name, email, course, marks);
                    manager.addStudent(s);
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    manager.searchByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    manager.deleteByName(sc.nextLine());
                    break;

                case 5:
                    manager.sortByMarks();
                    break;

                case 6:
                    manager.saveToFile();
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
